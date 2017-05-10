package Application;
/**
 * Entry of the whole program.
 * Main method is used to start the program and initialize necessary data
 * Different sub_interfaces of different roles are written in other classes in this package
 * 
 */

import java.util.Scanner;

import Admin.Admins;
import Flight.Flights;
import Passenger.passenger;

public class Main_interface {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			Admin.Admins.Admins_init();

		} catch (Exception e) {
			System.out.println("Sorry, program crashed, please try again.");
		}

		passenger p = new passenger();
		Flights f = new Flights();
		Admins a = new Admins();

		try {
			p.read();
			f.read();
		} catch (Exception e) {

		}
		System.out.println("Admins inilize successfully!");
		UI.U_I(p,f,a);

	}

}	
