package Flight;
/**
 * @author Claude
 * @Time 2017-5-1 19:30
 * 
 */

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

import City.CityList;
import Flight.Flight_ind.FlightStatus;

public class Flights {
	public ArrayList<Flight_ind> FlightList = new ArrayList<Flight_ind>();
	SimpleDateFormat DFC = new SimpleDateFormat("yyyy-MM-dd");

	// Add a new flight
	public void AddFlight() throws Exception {
		System.out.println("Add New Flight:");
		Flight_ind new_flight = new Flight_ind();// New Flight
		new_flight.list.read();
		new_flight.list.all_city();
		new_flight.Flight_set();
		FlightList.add(new_flight);
		write(new_flight);
	}

	// write flight's information to the file
	public void write(Flight_ind f) throws Exception {
		Formatter output = new Formatter("Flights.txt");
		Date date = new Date();
		output.format("%d\t%s\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t", f.FlightID, f.startCity.name, f.arrivalCity.name, f.date,
				f.startT, f.arrivalT, f.price, f.seatCapacity, f.currentPassengers);
		output.close();
	}

	// Read the file and add the flights information into the list
	public void read() throws Exception {
		Scanner input50 = new Scanner(new File("Flights.txt"));
		CityList cl = new CityList();
		cl.read();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
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
			newFlight.status = FlightStatus.AVAILABLE;
			// System.out.printf("%s is added\n", newFlight.FlightID);
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
			all_flights();
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
			default: System.out.println();
		}

	}

	// inquire function for passengers
	public void inquire_p() {
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
				this.all_flights();
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
						if (fi.FlightID.equals(ID)
								&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
							fi.print();
					System.out.println();
				} else if (choose2 == 2) {
					System.out.println("\nEnter a part of the FlightID:  ");
					String ID = input52.next().trim();
					for (Flight_ind fi : this.FlightList)
						if (fi.FlightID.contains(ID)// .matches("\\w+" + ID +
													// "\\w+")
								&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
							fi.print();
					System.out.println();
				} else
					System.out.println("Please check your input.");
				break;
			case 3:
				System.out.println();
				System.out.printf("Enter the arrival city's name:  ");
				String ac = input52.next().trim();
				for (Flight_ind fi : this.FlightList)
					if (fi.arrivalCity.name.equals(ac)
							&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
						fi.print();
				break;
			case 4:
				System.out.printf("\nEnter the departureDate in such form: YYYY-MM-DD\n");
				String dd = input52.next().trim();
				for (Flight_ind fi : this.FlightList)
					if (DFC.format(fi.date).equals(dd)
							&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
						fi.print();
				break;
			}
		}
		System.out.println("Inquire Stops.");
	}

	// List All of the flights
	public void all_flights() {
		System.out.println();
		System.out.println("All Flights:");
		for (int i = 0; i < FlightList.size(); i++) {
			// System.out.println(i);
			if (FlightList.get(i).status == FlightStatus.AVAILABLE || FlightList.get(i).status == FlightStatus.FULL)
				FlightList.get(i).print();
		}
	}

	// Check whether a FlightID has a corresponding Flight
	public int check(String ID) {
		for (Flight_ind f : FlightList) {
			if (f.FlightID.equals(ID))
				return FlightList.indexOf(f);
		}
		return -1;
	}
	
	
//	Compare each flight's date and startT with current time and modify its status
	public void statuscheck() throws ParseException {
		Date now = new Date();
		SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		System.out.println(now);
//		System.out.println("Now it is: " + DF.format(now));
		for (Flight_ind fi : FlightList) {
			if (DF.parse(fi.DFC.format(fi.date)+" "+ fi.DFT.format(fi.startT)).before(now))
				fi.set_status(FlightStatus.TERMINATE);
		}
	}

	// main method used to testing the code while coding
	public static void main(String[] args) throws Exception {
		Flights test = new Flights();
		test.read();
		test.statuscheck();
		test.all_flights();
		SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date da = new Date();
		for(Flight_ind fi : test.FlightList)
			System.out.println(DF.format(DF.parse(fi.DFC.format(fi.date)+" "+ fi.DFT.format(fi.startT))));
		// System.out.println(test.FlightList.toString());
		// test.inquiry();
		// test.AddFlight();
	}

}
