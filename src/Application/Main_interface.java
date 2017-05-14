package Application;
/**
 * Entry of the whole program.
 * Main method is used to start the program and initialize necessary data
 * Different sub_interfaces of different roles are written in other classes in this package
 * 
 */

import java.util.Scanner;

import Admin.Admin_individual;
import Admin.Admins;
import Flight.Flights;
import Passenger.passenger;

public class Main_interface {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		passenger p = new passenger();
		Flights f = new Flights();
		Admins a = new Admins();
		try {
			a.read();
			p.read();
			f.read();
			System.out.println("Passengers inilize successfully!\nFlights inilize successfully!\nAdmins inilize successfully!");

		} catch (Exception e) {
			System.out.println("Sorry, program crashed, please try again.");
		}
		System.out.println("=============================================");
//		for(Admin_individual ai:a.List_Admin)
//			System.out.println(ai.userName);
		UI.U_I(p,f,a);

	}

}	
