package Flight;

import City.City;
import Passenger.PassengerOfTheFlight;

public class Flight_ind {
	
	public String FlightID, startTime, arrivalTime, departureDate;
	public int price, currentPassengers, seatCapacity;
	public enum FlightStatus{ON, WAIT, LATE};
	FlightStatus status;
	public City startCity, arrivalCity;
	public PassengerOfTheFlight PLOF;
	
	
	public void Set_Flight(){
		
	}

}