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
	
//	Add a new flight
	public void AddFlight() throws Exception{
		System.out.println("Add New Flight:");
		Flight_ind new_flight = new Flight_ind();//New Flight
		new_flight.list.read();
		new_flight.list.all_city();
		new_flight.Flight_set();
		FlightList.add(new_flight);
		write(new_flight);
	}
	
//	write
	public void write(Flight_ind f) throws Exception
	{
		Formatter output = new Formatter("Flights.txt");
		output.format("%d\t%s\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t", 
				f.FlightID,f.startCity.name,f.arrivalCity.name,f.departureDate,
				f.startTime,f.arrivalTime,f.price,f.seatCapacity,f.currentPassengers);
		output.close();
	}
//	Read the flights information into the list
	public void read() throws Exception
	{
		Scanner input = new Scanner(new File("Flights.txt"));
		 Flight_ind newFlight = new Flight_ind();
		 while(input.hasNext())
		 {
			 newFlight.FlightID = input.next();
			 newFlight.startCity = newFlight.list.city_list.get(newFlight.list.index_of(input.next()));
			 newFlight.arrivalCity =newFlight.list.city_list.get(newFlight.list.index_of(input.next()));
			 newFlight.departureDate = input.next();
			 newFlight.startTime = input.next();
			 newFlight.arrivalTime = input.next();
			 newFlight.price = input.nextInt();
			 newFlight.seatCapacity = input.nextInt();
			 newFlight.currentPassengers = input.nextInt();
			 newFlight.status = FlightStatus.UNPUBLISHED;
			 FlightList.add(newFlight);
		 }
		 input.close();
	}
	
	public static void main(String[] args) throws Exception{
		Flights test = new Flights();
		test.AddFlight();
	}
	
	

}
