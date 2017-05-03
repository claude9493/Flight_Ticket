package Flight;
/**
 * @author Claude
 * @Time 2017-5-1 19:30
 * 
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

import Flight.Flight_ind.FlightStatus;

public class Flights {
	ArrayList<Flight_ind> FlightList = new ArrayList<Flight_ind>();

	// Add a new flight
	public void AddFlight() throws Exception {
		System.out.println("Add New Flight:");
		Flight_ind new_flight = new Flight_ind();// New Flight
		new_flight.list.read();
		new_flight.list.all_city();
		new_flight.Flight_set();
		FlightList.add(new_flight);
		write(new_flight);
	}

	// write flight's information to the file
	public void write(Flight_ind f) throws Exception {
		Formatter output = new Formatter("Flights.txt");
		output.format("%d\t%s\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t", f.FlightID, f.startCity.name, f.arrivalCity.name,
				f.departureDate, f.startTime, f.arrivalTime, f.price, f.seatCapacity, f.currentPassengers);
		output.close();
	}

	// Read the file and add the flights information into the list
	public void read() throws Exception {
		Scanner input = new Scanner(new File("Flights.txt"));
		Flight_ind newFlight = new Flight_ind();
		newFlight.list.read();
		while (input.hasNext()) {
			newFlight.FlightID = input.next();
			newFlight.startCity = newFlight.list.city_list.get(newFlight.list.index_of(input.next()));
			newFlight.arrivalCity = newFlight.list.city_list.get(newFlight.list.index_of(input.next()));
			newFlight.departureDate = input.next();
			newFlight.startTime = input.next();
			newFlight.arrivalTime = input.next();
			newFlight.price = input.nextInt();
			newFlight.seatCapacity = input.nextInt();
			newFlight.currentPassengers = input.nextInt();
			newFlight.status = FlightStatus.UNPUBLISHED;
			System.out.printf("%s is added\n", newFlight.FlightID);
			FlightList.add(newFlight);
		}
		input.close();
	}

	/*
	 * Inquiry for the people who didn't log user can list all the flight in the
	 * system user can also search by the FlightID and the Cities
	 */
	public void inquiry() {
		System.out.println("Inquiry");
		System.out.print("1.List all the flights\n2.Search by Flight ID\n3.Search by the city\n");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		switch (choose) {
		case 1:
			all_flights();
		case 2:
		}

	}

	// List All of the flights
	public void all_flights() {
		System.out.println();
		System.out.println(
				"FlightID\tstartCity\tarrivalCity\tdepartureDate\tstartTime\tarrivalTime\tprice\tseatCapacity\tcurrentPassengers\t");
		for (int i = 0; i < FlightList.size(); i++) {
			System.out.println(i);
			FlightList.get(i).print();
		}
	}

	// main method used to testing the code while coding
	public static void main(String[] args) throws Exception {
		Flights test = new Flights();
		test.read();
		// System.out.println(test.FlightList.toString());
		test.inquiry();
		// test.AddFlight();
	}

}
