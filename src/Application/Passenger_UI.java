package Application;

import java.util.Scanner;

import Passenger.passenger;

public class Passenger_UI {

	public static void Passeager(passenger who) throws Exception {
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.printf(
				"1.LOG\n2.REGISTER\n3.INQUIRE\n(Input the serial number to execute the corresponding operation)");
		int choose = input.nextInt();
		input.close();
		System.out.println();
		switch (choose) {
		case 1:
			who.log();
			break;
		case 2:
			who.register();
			break;
		case 3: 
		}

	}
}
