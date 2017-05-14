package Application;

import java.util.Scanner;

import Admin.Admins;
import Flight.Flights;
import Passenger.passenger;

public class UI {
//	public static Scanner inpu = new Scanner(System.in);
	public static void U_I(passenger p,Flights f,Admins a) throws Exception {
		Scanner input00 = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.print("1.Admin\n2.Passenger\n3.Inquiry\n0.Exit\n");
			int choose = input00.nextInt();
			if (choose == 0)// Exit program
				return;

			switch (choose) {
			case 1:
				Admins_UI.Admin(f,p);
				break;
			case 2:
				try {
					Passenger_UI.Passeager(p,f);
				} catch (Exception e) {
					System.out.println("\nSorry there is something wrong with our system.\nPlease try again");
					break;
				};
				break;
			case 3: 
				f.statuscheck();
				f.inquire_t();
			}
			 
		}
	}
}
