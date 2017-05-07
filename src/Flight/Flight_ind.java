package Flight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 * Flight individual class
 * instance variables
 * A big set method.
 */

import java.util.Scanner;
import City.CityList;
import City.City;
import Passenger.PassengerOfTheFlight;

public class Flight_ind {

	public String FlightID, startTime, arrivalTime, departureDate;
	public int price, currentPassengers, seatCapacity;

	public enum FlightStatus {
		UNPUBLISHED, AVAILABLE, FULL, TERMINATE
	};

	FlightStatus status;
	public City startCity, arrivalCity;
	public PassengerOfTheFlight PLOF;
	public CityList list = new CityList();

	public void Flight_set() {
		System.out.println();
		Scanner input40 = new Scanner(System.in);
		System.out.println("FlightID\t	StartTime\t		ArrivalTime\t	departureDate\t		price\n");
		String FlightID = input40.next(), StartTime = input40.next(), ArrivalTime = input40.next();
		String departureDate = input40.next();// departureDate
		int price = input40.nextInt();// price
		this.FlightID = FlightID;
		this.startTime = StartTime;
		this.arrivalTime = ArrivalTime;
		this.departureDate = departureDate;
		this.price = price;
		System.out.println("currentPassengers\t		seatCapacity\t		StartCity\t		ArrivalCity");
		int currentPassengers = input40.nextInt();
		int seatCapacity = input40.nextInt();
		String StartCity = input40.next();
		String ArrivalCity = input40.next();
		this.currentPassengers = currentPassengers;
		this.seatCapacity = seatCapacity;
		this.startCity = list.city_list.get(list.index_of(StartCity));
		this.arrivalCity = list.city_list.get(list.index_of(ArrivalCity));
		this.status = FlightStatus.UNPUBLISHED;
	}

	public FlightStatus get_status() {
		return this.status;
	}

	public void set_status(FlightStatus nS) {
		this.status = nS;
	}

	public void print() {
		System.out.println();
		System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-6d%-6d%-6d\t", this.FlightID, this.startCity.name,
				this.arrivalCity.name, this.departureDate, this.startTime, this.arrivalTime, this.price,
				this.seatCapacity, this.currentPassengers);

	}
}