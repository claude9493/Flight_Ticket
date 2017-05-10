package Passenger;
/**
 * This class stores the information of all the passengers 
 * admins can use the method provided to manage the passengers
 */

import java.io.Console;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class passenger {

	public final int MAXLEN = 100;
	public ArrayList<Passenger_ind> PassengerList = new ArrayList<Passenger_ind>();

	// Register and store the information of the new passenger to the file
	public void register() throws Exception {
		Scanner input71 = new Scanner(System.in);
		Passenger_ind new_passenger = new Passenger_ind();
		System.out.println("REGISTER");
		System.out.print("Identity ID:\t");
		new_passenger.identityID = input71.nextLine().trim();
		System.out.print("\nPassword:\t");
		new_passenger.set_password(input71.nextLine().trim());
		new_passenger.passagerID = PassengerList.size();
		PassengerList.add(new_passenger);
		write(new_passenger);
		System.out.println("\nCongratulations, you have successfully registered.");
	}

	// LOG
	public Passenger_ind log() {
		Scanner input72 = new Scanner(System.in);
		System.out.print("Your identityID:\t");
		String ID = input72.next().trim();
		System.out.print("Password:\t");
		String password = input72.next().trim();
//		I want to use the console method to achieve a effect like input the password and display******
//		Console console = System.console();
//		char[] passwordChar = console.readPassword("Password: ");
//		String password = new String(passwordChar).trim();
		// input.close();
		if (check(ID) == -1) {
			System.out.println("\nSuch passenger doesn't exist in system.");
			return (new Passenger_ind(-1));
		} else if (!PassengerList.get(check(ID)).get_password().equals(password)) {
			System.out.println("Wrong password, please try again.\n");
			return (new Passenger_ind(-1));
		} else {
			PassengerList.get(check(ID)).change_status();
			System.out.println("\nCongratulations, you have successfully loged in.");
			return (PassengerList.get(check(ID)));
		}
	}

	// Delete a passenger from the list and the file
	public void PLDelete(int n) {
		if (n < 1 || n > this.PassengerList.size()) {
			System.out.print("Wrong index.");
		} else {
			this.PassengerList.remove(n);
		}
	}

	public int check(String ID) {
		for (Passenger_ind p : PassengerList) {
			if (p.identityID.equals(ID))
				return PassengerList.indexOf(p);
		}
		return -1;
	}

	// read the passengers'information from the file
	public void read() throws Exception {
		Scanner input73 = new Scanner(new File("Passengers.txt"));
		while (input73.hasNext()) {
			Passenger_ind np = new Passenger_ind();
			np.passagerID = input73.nextInt();
			np.identityID = input73.next();
			np.set_password(input73.next());
			np.realName = input73.next();
			PassengerList.add(np);
		}
	}
/*
	// Inquire method for passengers
	public void inquire_p(Flights f) {
		System.out.println();
		System.out.printf(
				"Inquire\n1.List all of the flights\t2.Inquire by FlightID\n3.Inquire by cities      \t4.Inquire by date\n0.Exit\n");
		Scanner input74 = new Scanner(System.in);
		while (true) {
			int choose = input74.nextInt();
			if (choose == 0)
				break;
			switch (choose) {
			case 1:
				f.all_flights();
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.printf("1.Specific inquire\t\t2.Fuzzy inquire\n");
				int choose2 = input74.nextInt();
				if (choose2 == 1) {
					System.out.printf("\nEnter the FlightID:  ");
					String ID = input74.next().trim();
					for (Flight_ind fi : f.FlightList)
						if (fi.FlightID.equals(ID)
								&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
							System.out.printf("%s  from %s to %s on %s from %s to %s  %dyuan %dseats %s\n", fi.FlightID,
									fi.startCity.name, fi.arrivalCity.name, fi.departureDate, fi.startTime,
									fi.arrivalTime, fi.price, fi.seatCapacity, fi.get_status());
					System.out.println();
				} else if (choose2 == 2) {
					System.out.println("\nEnter a part of the FlightID:  ");
					String ID = input74.next().trim();
					for (Flight_ind fi : f.FlightList)
						if (fi.FlightID.contains(ID)//.matches("\\w+" + ID + "\\w+")
								&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
							System.out.printf("%s  from %s to %s on %s from %s to %s  %dyuan %dseats %s\n", fi.FlightID,
									fi.startCity.name, fi.arrivalCity.name, fi.departureDate, fi.startTime,
									fi.arrivalTime, fi.price, fi.seatCapacity, fi.get_status());
					System.out.println();
				} else
					System.out.println("Please check your input.");
				break;
			case 3:
				System.out.println();
				System.out.printf("Enter the arrival city's name:  ");
				String ac = input74.next().trim();
				for (Flight_ind fi : f.FlightList)
					if (fi.arrivalCity.name.equals(ac)
							&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
						System.out.printf("%s  from %s to %s on %s from %s to %s  %dyuan %dseats %s\n", fi.FlightID,
								fi.startCity.name, fi.arrivalCity.name, fi.departureDate, fi.startTime, fi.arrivalTime,
								fi.price, fi.seatCapacity, fi.get_status());
				break;
			case 4:
				System.out.printf("\nEnter the departureDate in such form: YYYY-MM-DD\n");
				String dd = input74.next().trim();
				for (Flight_ind fi : f.FlightList)
					if (fi.departureDate.equals(dd)
							&& (fi.get_status() == FlightStatus.AVAILABLE || fi.get_status() == FlightStatus.FULL))
						System.out.printf("%s  from %s to %s on %s from %s to %s  %dyuan %dseats %s\n", fi.FlightID,
								fi.startCity.name, fi.arrivalCity.name, fi.departureDate, fi.startTime, fi.arrivalTime,
								fi.price, fi.seatCapacity, fi.get_status());
				break;

			}
		}
		System.out.println("Inquire Stops.");
	}
*/
	// write information to the file
	public void write(Passenger_ind p) throws Exception {
//		Formatter output = new Formatter("Passengers.txt");
		RandomAccessFile r = new RandomAccessFile("Passengers.txt","rw");
		r.seek(r.length());
		r.writeBytes(String.format("%d\t%s\t%s\t%s\r\n", p.passagerID, p.identityID, p.get_password(), p.realName));
		
//		output.format("%d\t%s\t%s\t%s\t", p.passagerID, p.identityID, p.get_password(), p.realName);
//		output.close();
	}
	
	
//	rewrite the file after modify self information
	public void re_write() throws Exception
	{
		Formatter output = new Formatter ("Passengers.txt");
		for(Passenger_ind p : this.PassengerList)
			output.format("%d\t%s\t%s\t%s\n", p.passagerID, p.identityID, p.get_password(), p.realName);
	}

}
