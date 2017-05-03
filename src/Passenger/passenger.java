package Passenger;
/**
 * This class stores the information of all the passengers 
 * admins can use the method provided to manage the passengers
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class passenger {

	public final int MAXLEN = 100;
	public ArrayList<Passenger_ind> PassengerList = new ArrayList<Passenger_ind>();

	// Register and store the information of the new passenger to the file
	public void register() throws Exception {
		Scanner input = new Scanner(System.in);
		Passenger_ind new_passenger = new Passenger_ind();
		System.out.println("REGISTER");
		System.out.print("UserName:\t");
		new_passenger.identityID = input.nextLine().trim();
		System.out.print("\nPassword:\t");
		new_passenger.set_password(input.nextLine().trim());
		PassengerList.add(new_passenger);
		write(new_passenger);
		input.close();
		System.out.println("\nCongratulations, you have successfully registered.");
	}

	// LOG
	public void log() {
		Scanner input = new Scanner(System.in);
		System.out.print("Your identityID:\t");
		String ID = input.nextLine().trim();
		System.out.print("\nPassword:\t");
		String password = input.nextLine().trim();
		input.close();
		if (check(ID) == -1)
			System.out.println("\nSuch passenger doesn't exist in system.");
		else if (!PassengerList.get(check(ID)).equals(password))
				System.out.println("Wrong password, please try again.\n");
		else{
			PassengerList.get(check(ID)).change_status();
			System.out.println("\nCongratulations, you have successfully loged in.");
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

	public int check(String name) {
		for (Passenger_ind p : PassengerList) {
			if (p.identityID.equals(name))
				return PassengerList.indexOf(p);
		}
		return -1;
	}

	// read the passengers'information from the file
	public void read() throws Exception {
		Scanner input = new Scanner(new File("Passengers.txt"));
		Passenger_ind np = new Passenger_ind();
		while (input.hasNext()) {
			np.passagerID = input.nextInt();
			np.identityID = input.next();
			np.set_password(input.next());
			np.realName = input.next();
			PassengerList.add(np);
		}
		input.close();
	}

	// write information to the file
	public void write(Passenger_ind p) throws Exception {
		Formatter output = new Formatter("Passengers.txt");
		output.format("%d\t%s\t%s\t%s\t", p.passagerID, p.identityID, p.get_password(), p.realName);
		output.close();
	}

}
