package Flight;

import java.util.Scanner;

import City.City;
import Passenger.PassengerOfTheFlight;

public class Flight_ind {
	
	public String FlightID, startTime, arrivalTime, departureDate;
	public int price, currentPassengers, seatCapacity;
	public enum FlightStatus{UNPUBLISHED, AVAILABLE, FULL, TERMINATE};
	FlightStatus status;
	public City startCity, arrivalCity;
	public PassengerOfTheFlight PLOF;
	
	public Flight_ind(){
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("FlightID\tStartTime\tArrivalTime\tdepartureDate\tprice\t");
		String FlightID = input.next(), StartTime = input.next(), ArrivalTime = input.next();
		String departureDate = input.next(); int price = input.nextInt();
		System.out.println("currentPassengers\tseatCapacity\tStatus\tStartCity\tArrivalCity");
	}
	public void Set_Flight(){
		
	}

}