package Passenger;

import java.util.ArrayList;

public class PassengerOfTheFlight {
	int MaxPassenger;
	ArrayList<Passenger_ind> List;
	int CurrentNumber = List.size();
	
//	Add a passenger to flight
	public void Add(PassengerOfTheFlight PLF, Passenger_ind newguy){
		if (CurrentNumber < MaxPassenger){
			PLF.List.add(newguy);
			System.out.println("Successfully add new passenger!!!");
		}
		else{
			System.out.println("There is no seat on this flight!!!");
		}
	}
	
	

}
