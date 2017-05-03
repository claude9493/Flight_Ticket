package Application;

import java.util.Scanner;

import Flight.Flights;
import Passenger.passenger;

public class UI {
	public static void UI(passenger p,Flights f) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.print("1.Admin\n2.Passenger\n3.Inquiry\n0.Exit(Input the serial number to choose your role)\n");
			int n = input.nextInt();

			if (n == 0)// Exit program
				break;

			switch (n) {
			case 1:
				Admins_UI.Admin();
				break;
			case 2:
				try {
					Passenger_UI.Passeager(p);
				} catch (Exception e) {
					System.out.println("Sorry there is something wrong with our system.\nPlease try again");
				};
				break;
			case 3: f.inquiry();
			}
			 
		}
		input.close();
	}
}
