package Passenger;

import java.util.ArrayList;
import Admin.Admin_individual;

public class PassengerOfTheFlight {
	int MaxPassenger;
	ArrayList<Passenger_ind> List;
	int CurrentNumber = List.size();
	
//	Add a passenger to flight
	public void Add(PassengerOfTheFlight PLF, Passenger_ind newguy, Admin_individual ad){
		if (CurrentNumber < MaxPassenger){
			PLF.List.add(newguy);
			System.out.println("Successfully add new passenger!!!");
		}
		else{
			System.out.println("There is no seat on this flight!!!");
		}
	}
	
	

}