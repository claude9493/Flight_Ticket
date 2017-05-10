package Flight;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Flight individual class
 * instance variables
 * A big set method.
 */

import java.util.Scanner;

import City.City;
import City.CityList;
import Passenger.PassengerOfTheFlight;

public class Flight_ind {

	public String FlightID; 
//	String startTime, arrivalTime, departureDate;
	public int price, currentPassengers, seatCapacity;
	public	Date startT ,arrivalT, date;
	public SimpleDateFormat DFT = new SimpleDateFormat("HH:mm");
	public SimpleDateFormat DFC = new SimpleDateFormat("yyyy-MM-dd");

	public enum FlightStatus {
		UNPUBLISHED, AVAILABLE, FULL, TERMINATE
	};

	FlightStatus status;
	public City startCity, arrivalCity;
	public PassengerOfTheFlight PLOF;
	public CityList list = new CityList();

	public void Flight_set() throws Exception {
		System.out.println();
		Scanner input40 = new Scanner(System.in);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("FlightID\t	StartTime\t		ArrivalTime\t	departureDate\t		price\n");
		String FlightID = input40.next(), StartTime = input40.next(), ArrivalTime = input40.next();
		String departureDate = input40.next();// departureDate
		int price = input40.nextInt();// price
		this.FlightID = FlightID;
		this.startT = df.parse(StartTime);
		this.arrivalT = df.parse(ArrivalTime);
		this.date = df2.parse(departureDate);
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
		System.out.printf("%s  from %-11s to %-11s on %-10s from %-6s to %-7s%-4dYuan%5dseats  %s\n", this.FlightID,
								this.startCity.name, this.arrivalCity.name, DFC.format(date), DFT.format(startT), DFT.format(arrivalT),
								this.price, this.seatCapacity, this.get_status());
//		System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-6d%-6d%-6d\t", this.FlightID, this.startCity.name,
//				this.arrivalCity.name, this.departureDate, this.startTime, this.arrivalTime, this.price,
//				this.seatCapacity, this.currentPassengers);

	}
}