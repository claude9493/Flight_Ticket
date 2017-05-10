package Passenger;

import java.util.ArrayList;
import java.util.Scanner;

import Flight.Flights;
import Flight.Flight_ind.FlightStatus;
import Order.Order;
import Order.Order.StatusList;

public class Passenger_ind {
	public int passagerID;// Provided by system
	public String realName;
	public String identityID;// Shen fen zheng hao
	private String password;
	public ArrayList<Order> myorder = new ArrayList<Order>();

	enum status_list {
		ONLINE, OFFLINE
	};

	status_list status = status_list.OFFLINE;

	public Passenger_ind(int ID) {
		this.passagerID = ID;
	}

	public Passenger_ind() {

	}

	public void set_password(String password) {
		this.password = password;
	}

	public String get_password() {
		return this.password;
	}

	public void change_status() {
		if (this.status == status_list.OFFLINE)
			status = status_list.ONLINE;
		else
			status = status_list.OFFLINE;
	}

	// ReserveFlight
	public void reserve(Flights All_flights) {
		System.out.println();
		System.out.print("Reserve flight\nEnter the FlightID:\t");
		Scanner input60 = new Scanner(System.in);
		String ID = input60.nextLine().trim();
		int index = All_flights.check(ID);
		if (index != -1 && All_flights.FlightList.get(index).get_status() == FlightStatus.AVAILABLE) {
			All_flights.FlightList.get(index).print();
			System.out.print("\nEnter your password to confirm your role\t");
			String ans1 = input60.nextLine();
			if (ans1.equals(this.get_password())) {
				All_flights.FlightList.get(index).currentPassengers++;
				Order newOrder = new Order(All_flights.FlightList.get(index), this);
				// System.out.println(newOrder.passengerID + " " +
				// newOrder.flight.FlightID);
				this.myorder.add(newOrder);
				newOrder.OrderID = this.myorder.size();
				System.out.print("\nHave you paid? Y/N\t");
				String ans2 = input60.nextLine().trim();
				while (ans2.equals("Y") == false || ans2.equals("N") == false) {
					if (ans2.equals("Y")) {
						newOrder.status = StatusList.PAID;
						newOrder.seat = All_flights.FlightList.get(index).currentPassengers;
						System.out.printf(
								"Your order is successfully created.\n Your OrderID is: %d\nYour seat is %d.\n\n",
								newOrder.OrderID, newOrder.seat);
						break;
					} else if (ans2.equals("N")) {
						System.out.println("Please pay your order as soon as possible.");
						break;
					} else
						System.out.println("Please check your input.");
					ans2 = input60.nextLine();
				}

			} else if (!ans1.equals(this.get_password()))
				System.out.println("Please check your password.\n");
		} else if (index == -1
				|| (index != -1 && (All_flights.FlightList.get(index).get_status() == FlightStatus.UNPUBLISHED
						|| All_flights.FlightList.get(index).get_status() == FlightStatus.TERMINATE)))
			System.out.println("Such flight doesn't exist.\n");
		else if (index != -1 && All_flights.FlightList.get(index).get_status() == FlightStatus.FULL)
			System.out.println("Sorry, this flight is full.\n");
	}

	// Un_subscribe Flights
	public void unsubscribe() {
		System.out.println();
		System.out.println("Cancel order.");
		System.out.println("All of your orders are showed below:");
		for (Order o : this.myorder)
			o.Oprint();
		if (this.myorder.size() == 0) {
			System.out.println("You have no order yet.\n");
			return;
		}
		System.out.print("Enter the ID of the order you want to cancel:\t");
		Scanner input61 = new Scanner(System.in);
		int ID = input61.nextInt();
		if (check_order(ID)) {

			if (this.myorder.get(ID - 1).flight.get_status() == FlightStatus.TERMINATE)
				System.out.println("Sorry, this flight has flown, you cannot cancel it now.\n");
			else {
				this.myorder.get(ID - 1).flight.currentPassengers--;
				this.myorder.get(ID - 1).flight.set_status(FlightStatus.AVAILABLE);
				this.myorder.get(ID - 1).status = StatusList.CANCEL;
				System.out.println("You have successfully canceled this order.");
				System.out.println("Refund is successfully returned.\n");
			}
		} else
			System.out.println("Please check your input, such order doesn't exist.\n");
	}

	public boolean check_order(int ID) {
		for (Order o : this.myorder) {
			if (o.OrderID == ID)
				return true;
		}
		return false;
	}

	// manage self information
	public void set_profile() {
		Scanner input62 = new Scanner(System.in);
		System.out.println("\nEdit Profile\n");
		System.out.printf("Your current profile:\nidentityID: %s   realName: %s\n", this.identityID, this.realName);
		while (true) {
			System.out.printf("1.identityID\t2.Password\n3.realName\t0.Exit\n");
			int choose62 = input62.nextInt();
			if (choose62 == 0) {
				break;
			}
			switch (choose62) {
			case 1:
				System.out.print("NewID:  ");
				this.identityID = input62.next();
				break;
			case 2:
				System.out.println("Please input your current password to confirm your role:  ");
				String currentPassword = input62.next().trim();
				if (currentPassword.equals(this.get_password())) {
					System.out.print("NewPassword:  ");
					this.set_password(input62.next());
				} else
					System.out.println("Password Is Wrong, Please Check Your Input.");
				break;
			case 3:
				System.out.print("NewName:  ");
				this.realName = input62.next();
				break;
			}
		}
	}

	public static void main(String[] a) throws Exception {
		Passenger_ind test = new Passenger_ind();
		test.set_password("12345");
		System.out.println(test.get_password());
		Flights F = new Flights();
		F.read();
		F.FlightList.get(1).set_status(FlightStatus.AVAILABLE);
		F.all_flights();
		test.reserve(F);
		test.reserve(F);
		test.unsubscribe();
		// for(Order o:test.myorder)
		// if(o.status != StatusList.CANCEL)
		// System.out.println(o.OrderID);
		// System.out.println(F.FlightList.get(1).currentPassengers);
	}
}
