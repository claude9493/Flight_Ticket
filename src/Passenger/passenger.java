package Passenger;
/**
 * This class stores the information of all the passengers 
 * admins can use the method provided to manage the passengers
 */

import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import Order.Order;

public class passenger {

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
		if(check(new_passenger.identityID) == -1){
		PassengerList.add(new_passenger);
		write(new_passenger);
		System.out.println("\nCongratulations, you have successfully registered.");}
		else{
			System.out.println("Such identityID has been used to register, please check your input.");
		}
	}

	// LOG
	public Passenger_ind log() {
		Scanner input72 = new Scanner(System.in);
		System.out.print("Your identityID:\t");
		String ID = input72.next().trim();
		System.out.print("Password:\t");
		String password = input72.next().trim();
		// I want to use the console method to achieve a effect like input the
		// password and display******
		// Console console = System.console();
		// char[] passwordChar = console.readPassword("Password: ");
		// String password = new String(passwordChar).trim();
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
	// write information to the file
	public void write(Passenger_ind p) throws Exception {
		// Formatter output = new Formatter("Passengers.txt");
		RandomAccessFile r = new RandomAccessFile("Passengers.txt", "rw");
		r.seek(r.length());
		r.writeBytes(String.format("%d\t%s\t%s\t%s\r\n", p.passagerID, p.identityID, p.get_password(), p.realName));

		// output.format("%d\t%s\t%s\t%s\t", p.passagerID, p.identityID,
		// p.get_password(), p.realName);
		// output.close();
	}

	public void Order_inquire() {
		System.out.println();
		Scanner input74 = new Scanner(System.in);
		SimpleDateFormat DFC = new SimpleDateFormat("yyyy-MM-dd");
		System.out.printf("Order inquire\n1.Inquire by flight ID\t2.Inquire by PassengerID\t0.Exit\n");
		while (true) {
			int choose = input74.nextInt();
			if (choose == 0)
				break;
			switch (choose) {
			case 1:
				System.out.print("Enter the FlightID:  ");
				String ID1 = input74.next().trim();
				for (Passenger_ind p : PassengerList)
					for (Order o : p.myorder)
						if (o.flight.FlightID.equals(ID1)) {
							System.out.printf("%s  %s  %s  %s  %s\n", p.identityID, p.realName,o.seat, o.status, DFC.format(o.createDate));
//							o.Oprint();
						}
				break;
			case 2:
				System.out.print("Enter the passengerID:  ");
				int ID2 = input74.nextInt();
				for (Passenger_ind p : PassengerList)
					if (p.passagerID == ID2)
						for (Order o : p.myorder)
							o.Oprint();
				break;
			}
		}
	}

	// rewrite the file after modify self information
	public void re_write() throws Exception {
//		File file = new File("Passengers.txt");
//		file.delete();
//		file.createNewFile();
		RandomAccessFile r = new RandomAccessFile("Passengers.txt", "rw");
//		r.seek(r.length());
		for (Passenger_ind p : PassengerList)
			r.writeBytes(String.format("%d\t%s\t%s\t%s\r\n", p.passagerID, p.identityID, p.get_password(), p.realName));
	}

}
