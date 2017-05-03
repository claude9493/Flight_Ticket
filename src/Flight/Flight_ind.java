package Flight;

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

	public void Flight_set() 
	{
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("FlightID\t	StartTime\t		ArrivalTime\t	departureDate\t		price\n");//output information
		String FlightID = input.next(), StartTime = input.next(), ArrivalTime = input.next();//ID, StartTime, ArrivalTime
		String departureDate = input.next();//departureDate
		int price = input.nextInt();//price
		this.FlightID = FlightID;
		this.startTime = StartTime;
		this.arrivalTime = ArrivalTime;
		this.departureDate = departureDate;
		this.price = price;
		System.out.println("currentPassengers\t		seatCapacity\t		StartCity\t		ArrivalCity");
		int currentPassengers = input.nextInt();
		int seatCapacity = input.nextInt();
		String StartCity = input.next();
		String ArrivalCity = input.next();
		this.currentPassengers = currentPassengers;
		this.seatCapacity = seatCapacity;
		this.startCity = list.city_list.get(list.index_of(StartCity));
		this.arrivalCity = list.city_list.get(list.index_of(ArrivalCity));
		this.status = FlightStatus.UNPUBLISHED;
	}
	
	public void write() throws Exception
	{
		Formatter output = new Formatter("Flights.txt");
		output.format("%s\t",this.FlightID );
	}

}