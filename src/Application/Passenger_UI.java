package Application;

import java.util.Scanner;

import Flight.Flights;
import Flight.Flight_ind.FlightStatus;
import Order.Order;
import Order.Order.StatusList;
import Passenger.Passenger_ind;
import Passenger.passenger;

public class Passenger_UI {
	public static Flights FList = new Flights();

	public static void Passeager(passenger who1, Flights f) throws Exception {
		System.out.println();
		FList.read();
		Scanner input10 = new Scanner(System.in);
		while (true) {
			System.out.printf(
					"1.LOG\n2.REGISTER\n3.INQUIRE\n0.EXIT\n(Input the serial number to execute the corresponding operation)\n");
			int choose = input10.nextInt();
			System.out.println();
			if (choose == 0)
				return;
			switch (choose) {
			case 1: {
				Passenger_ind me = who1.log();
				if (me.passagerID == -1)
					break;
//				System.out.println(me.passagerID + " " + me.identityID);
				After_Log(me, f, who1);
				break;
			}
			case 2:
				who1.register();
				break;
			case 3:who1.inquire(f);
				break;
			}
		}

	}

	public static void After_Log(Passenger_ind me, Flights f,passenger who2) throws Exception {
		System.out.println();
		Scanner input11 = new Scanner(System.in);
		while (true) {
			System.out.printf("1.Reserve Flight\t2.Inquire\n3.Cancel Flight\t4.My Orders\n5.Edit Profile\t0.Exit\n");
			int choose2 = input11.nextInt();
			if (choose2 == 0)
				return;
			switch (choose2) {
			case 1:
				me.reserve(FList);
				break;
			case 2:who2.inquire(f);
				break;
			case 3:
				me.unsubscribe();
				break;
			case 4:
				System.out.println("All your orders:");
				for (Order o : me.myorder)
					if (o.status != StatusList.CANCEL)
						System.out.printf("%-6d-6%sfrom %s to %s on %-6sseat%-6d%-6s\n", o.OrderID, o.flight.FlightID,
								o.flight.startCity.name, o.flight.arrivalCity.name, o.flight.departureDate,o.seat,o.status);
				System.out.println();
				break;
			case 5:
				me.set_profile();
				break;
				
			}
		}
	}

}
