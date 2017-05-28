package Flight;
/**
 * @author Claude
 * @Time 2017-5-1 19:30
 * 
 */

import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import City.CityList;
import Flight.Flight_ind.FlightStatus;

public class Flights {
	public ArrayList<Flight_ind> FlightList = new ArrayList<Flight_ind>();
	SimpleDateFormat DFC = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat DFT = new SimpleDateFormat("HH:mm");
	public CityList list = new CityList();

	// Add a new flight
	public void AddFlight() throws Exception {
		System.out.println("Add New Flight:");
		Date now = new Date();
		Flight_ind new_flight = new Flight_ind();// New Flight
		new_flight.list.read();
		new_flight.list.all_city();
		new_flight.Flight_set();
		// Make sure the departure date is in the future.
		if (new_flight.date.before(now) && !sameDate(new_flight.date, now))
			System.out.println("WARNING: Invalid departure date!\n");
		// Make sure the start time is at least 2 hours later than now if the
		// flight is on today
		else if (sameDate(new_flight.date, now) && twohs(new_flight.startT, now)) {
			System.out.println("WARNING: Start time should be at least two hours later than now.\n");
			// Make sure the start time is later than the arrival time.
		} else if (new_flight.startT.after(new_flight.arrivalT)) {
			System.out.println("WARNING: Start time should be later than arrival time.\n");
		} else {
			FlightList.add(new_flight);
			write(new_flight);
			System.out.printf("Flight %s is added successfully.", new_flight.FlightID);
		}
	}

	// Check whether t1 is two hours later than t2
	public boolean twohs(Date t1, Date t2) {
		if (null == t1 || null == t2)
			return false;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(t1);
		cal1.set(Calendar.YEAR, 0);
		cal1.set(Calendar.MONTH,0);
		cal1.set(Calendar.DATE, 0);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(new Date(t2.getTime() + 2 * 60 * 60 * 1000));
		cal2.set(Calendar.YEAR, 0);
		cal2.set(Calendar.MONTH, 0);
		cal2.set(Calendar.DATE, 0);
		return cal1.after(cal2);
	}

	// Check whether d1 is on same date with d2
	public static boolean sameDate(Date d1, Date d2) {
		if (null == d1 || null == d2)
			return false;
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(d1);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		return cal1.getTime().equals(cal2.getTime());
	}

	// write flight's information to the file
	public void write(Flight_ind f) throws Exception {
		// Formatter output = new Formatter("Flights.txt");
		RandomAccessFile r = new RandomAccessFile("Flights.txt", "rw");
		r.seek(r.length());
		Date date = new Date();
		r.writeBytes(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%d\t%d\t%d\r\n", f.FlightID, f.startCity.name,
				f.arrivalCity.name, DFC.format(f.date), DFT.format(f.startT), DFT.format(f.arrivalT), f.price,
				f.seatCapacity, f.currentPassengers));
	}

	// rewrite the file after modify the information, by deleting the file first
	// then recreate it and write again
	public void rewrite() throws Exception {
		// File file = new File("Flights.txt");
		// file.delete();
		// file.createNewFile();
		RandomAccessFile r = new RandomAccessFile("Flights.txt", "rw");
		// r.seek(r.length());
		for (Flight_ind fi : FlightList) {
			r.writeBytes(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%d\t%d\t%d\r\n", fi.FlightID, fi.startCity.name,
					fi.arrivalCity.name, DFC.format(fi.date), DFT.format(fi.startT), DFT.format(fi.arrivalT), fi.price,
					fi.seatCapacity, fi.currentPassengers));
		}
	}

	// Read the file and add the flights information into the list
	public void read() throws Exception {
		Scanner input50 = new Scanner(new File("Flights.txt"));
		CityList cl = new CityList();
		cl.read();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		while (input50.hasNext()) {
			Flight_ind newFlight = new Flight_ind();
			newFlight.list = cl;
			newFlight.FlightID = input50.next();
			newFlight.startCity = newFlight.list.city_list.get(newFlight.list.index_of(input50.next()));
			newFlight.arrivalCity = newFlight.list.city_list.get(newFlight.list.index_of(input50.next()));
			newFlight.date = df2.parse(input50.next());
			newFlight.startT = df.parse(input50.next());
			newFlight.arrivalT = df.parse(input50.next());
			newFlight.price = input50.nextInt();
			newFlight.seatCapacity = input50.nextInt();
			newFlight.currentPassengers = input50.nextInt();
			if (sameDate(newFlight.startT, now)) {
				newFlight.status = FlightStatus.AVAILABLE;
			} else {
				newFlight.status = FlightStatus.AVAILABLE;
			}
			FlightList.add(newFlight);
		}
	}

	/*
	 * Inquiry for the people who didn't log user can list all the flight in the
	 * system user can also search by the FlightID and the Cities
	 */
	public void inquire_t() {
		System.out.println("Inquiry");
		System.out.print("1.List all the flights\n2.Search by Flight ID\n3.Search by the city\n");
		Scanner input51 = new Scanner(System.in);
		int choose = input51.nextInt();
		switch (choose) {
		case 1:
			all_flights(1);
			break;
		case 2:
			System.out.println();
			System.out.print("Enter the flight ID:  ");
			String ID = input51.next().trim();
			if (check(ID) == -1)
				System.out.println("Such flight doesn't exist.");
			else {
				FlightList.get(check(ID)).print();
			}
			break;
		case 3:
			System.out.printf("Enter the arrival city's name:  ");
			String ac = input51.next().trim();
			for (Flight_ind fi : this.FlightList)
				if (fi.arrivalCity.name.equals(ac)
						&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
					fi.print();
			break;
		default:
			System.out.println();
		}

	}

	// inquire function for passengers
	public void inquire_p(int r) {// r == 1: Passenger, r == 0: Admins
		System.out.println();
		Scanner input52 = new Scanner(System.in);
		while (true) {
			System.out.printf(
					"Inquire\n1.List all of the flights\t2.Inquire by FlightID\n3.Inquire by cities      \t4.Inquire by date\n0.Exit\n");
			int choose = input52.nextInt();
			if (choose == 0)
				break;
			switch (choose) {
			case 1:
				this.all_flights(r);
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.printf("1.Specific inquire\t\t2.Fuzzy inquire\n");
				int choose2 = input52.nextInt();
				if (choose2 == 1) {
					System.out.printf("\nEnter the FlightID:  ");
					String ID = input52.next().trim();
					for (Flight_ind fi : this.FlightList)
						if ((r == 1 && fi.FlightID.equals(ID)
								&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
								|| (r == 0 && fi.FlightID.equals(ID) && (fi.get_status() != FlightStatus.TERMINATE)))
							fi.print();
					System.out.println();
				} else if (choose2 == 2) {
					System.out.println("\nEnter a part of the FlightID:  ");
					String ID = input52.next().trim();
					for (Flight_ind fi : this.FlightList)
						if ((r == 1 && fi.FlightID.contains(ID)
								&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
								|| (r == 0 && fi.FlightID.contains(ID) && (fi.get_status() != FlightStatus.TERMINATE)))
							fi.print();
					System.out.println();
				} else
					System.out.println("Please check your input.");
				break;
			case 3:
				System.out.println();
				System.out.println("1.Start City     2.Arrival City");
				int choose3 = input52.nextInt();
				if (choose3 == 2) {
					String ac = input52.next().trim();
					for (Flight_ind fi : this.FlightList) {
						if ((r == 1 && fi.arrivalCity.name.equals(ac)
								&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
								|| (r == 0 && fi.arrivalCity.name.equals(ac)
										&& (fi.get_status() != FlightStatus.TERMINATE))) {
							fi.print();
						}
					}
				} else if (choose3 == 1) {
					String sc = input52.next().trim();
					for (Flight_ind fi : this.FlightList) {
						if ((r == 1 && fi.startCity.name.equals(sc)
								&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
								|| (r == 0 && fi.startCity.name.equals(sc)
										&& (fi.get_status() != FlightStatus.TERMINATE))) {
							fi.print();
						}
					}
				}

				break;
			case 4:
				System.out.printf("\nEnter the departureDate in such form: YYYY-MM-DD\n");
				String dd = input52.next().trim();
				for (Flight_ind fi : this.FlightList)
					if ((r == 1 && DFC.format(fi.date).equals(dd)
							&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
							|| (r == 0 && DFC.format(fi.date).equals(dd)
									&& (fi.get_status() != FlightStatus.TERMINATE)))
						fi.print();
				break;
			}
		}
		System.out.println("Inquire Stops.");
	}

	// List All of the flights
	public void all_flights(int r) {
		System.out.println();
		System.out.println("All Flights:");
		for (int i = 0; i < FlightList.size(); i++) {
			// System.out.println(i);
			if ((r == 1 && (FlightList.get(i).status == FlightStatus.AVAILABLE
					|| FlightList.get(i).status == FlightStatus.FULL))
					|| (r == 0 && FlightList.get(i).get_status() != FlightStatus.TERMINATE))
				FlightList.get(i).print();
		}
	}

	public int check(String ID, String date) {
		for (Flight_ind f : FlightList) {
			if (f.FlightID.equals(ID) && DFC.format(f.date).equals(date))
				return FlightList.indexOf(f);
		}
		return -1;
	}

	// Check whether a FlightID has a corresponding Flight
	public int check(String ID) {
		for (Flight_ind f : FlightList) {
			if (f.FlightID.equals(ID))
				return FlightList.indexOf(f);
		}
		return -1;
	}

	public void modify() throws Exception {
		System.out.print("Enter the FlightID of the flight and the departure date you want to modify:  ");
		Scanner input53 = new Scanner(System.in);
		String ID = input53.next().trim();
		String d = input53.next().trim();
		int index = check(ID, d);
		if (check(ID) == -1)
			System.out.println("Such flight do not exist.");
		else {

			FlightList.get(index).print();
			if (FlightList.get(index).get_status() == FlightStatus.TERMINATE) {
				System.out.println("The flight is terminate, you cannot modify it any more.");
				return;
			}

			if (FlightList.get(index).get_status().equals(FlightStatus.UNPUBLISHED)) {
				System.out.print(
						"\n1.FlightID   2.startCity    3.arrivalCity   4.Price\n5.startTime  6.arrivalTime  7.SeatCapacity  8.Delete this flight\n9.Modify Status 0.Exit\n");
				while (true) {
					int choose = input53.nextInt();
					if (choose == 0)
						break;
					switch (choose) {
					case 1:
						System.out.print("New FlightID:  ");
						FlightList.get(index).FlightID = input53.next();
						break;
					case 2:
						System.out.print("New startCity;  ");
						FlightList.get(index).startCity = list.city_list.get(list.index_of(input53.next()));
						break;
					case 3:
						System.out.print("New arrivalCity:  ");
						FlightList.get(index).arrivalCity = list.city_list.get(list.index_of(input53.next()));
						break;
					case 4:
						System.out.print("New price:  ");
						FlightList.get(index).price = input53.nextInt();
						break;
					case 5:
						System.out.print("New startTime:  ");
						FlightList.get(index).startT = FlightList.get(index).DFT.parse(input53.next());
						break;
					case 6:
						System.out.print("New arrivalTime:  ");
						FlightList.get(index).arrivalT = FlightList.get(index).DFT.parse(input53.next());
						break;
					case 7:
						System.out.print("New seatCapacity:  ");
						FlightList.get(index).seatCapacity = input53.nextInt();
						break;
					case 8:
						System.out.println("Flight " + FlightList.get(index).FlightID + " is successfully deleted.");
						FlightList.remove(index);
						break;
					case 9:
						FlightList.get(index).set_status(FlightStatus.AVAILABLE);
						System.out.println("Status of this flight is changed to AVALIABLE.");
						break;
					}
					if (choose == 8)
						break;
				} // while: true
			} // if:
				// FlightList.get(index).get_status().equals(FlightStatus.UNPUBLISHED)
			else if (FlightList.get(index).get_status().equals(FlightStatus.AVAILABLE)
					|| FlightList.get(index).get_status().equals(FlightStatus.FULL)) {
				System.out.println("This flight is published, only little information can be modified.");
				while (true) {
					System.out.println("1.Price  2.Seat Capacity  0.Exit");
					int choose2 = input53.nextInt();
					if (choose2 == 0)
						break;
					if (choose2 == 1) {
						System.out.print("New Price:  ");
						FlightList.get(index).price = input53.nextInt();
					} else if (choose2 == 2) {
						System.out.print("New seat capacity:  ");
						FlightList.get(index).seatCapacity = input53.nextInt();
					} else
						System.out.println("Invalid input.");// invalid
				} // while: true

			} // else if: FlightList.get(index).get_status.equals(AVALIABLE ||
				// FULL)
		} // else: check(ID) !== -1
	}// method

	// Compare each flight's date and startT with current time and modify its
	// status
	public void statuscheck() throws Exception {
		Date now = new Date();
		SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// System.out.println(now);
		// System.out.println("Now it is: " + DF.format(now));
		for (Flight_ind fi : FlightList) {
			fi.statuscheck();
		}
	}

	// main method used to testing the code while coding
	public static void main(String[] args) throws Exception {
		Flights test = new Flights();
		Scanner input = new Scanner(System.in);
		Date t1 = test.DFT.parse(input.next());
		Date t2 = new Date();
		System.out.println(t1 + "\n" + t2);
		System.out.println(test.twohs(t1, t2));
		// test.read();
		// test.statuscheck();
		// test.all_flights();

		// test.AddFlight();
		// SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// Date da = new Date();
		// for (Flight_ind fi : test.FlightList)
		// System.out.println(DF.format(DF.parse(fi.DFC.format(fi.date) + " " +
		// fi.DFT.format(fi.startT))));
		// System.out.println(test.FlightList.toString());
		// test.inquiry();
		// test.AddFlight();
	}

}
