package Order;

import java.text.SimpleDateFormat;
import java.util.Date;

import Flight.Flight_ind;
import Passenger.Passenger_ind;

public class Order {
	public int OrderID;
	public int passengerID;
	public int seat;
	public Flight_ind flight;
	public Date createDate;
	public enum StatusList{UNPAID,PAID,CANCEL};
	public StatusList status;
	public SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	public Order(Flight_ind f, Passenger_ind p)
	{
		this.flight = f;
		this.passengerID = p.passagerID;
		this.status = StatusList.UNPAID;
	}
	public void Oprint(){
		System.out.printf("%-6d%-7sfrom %s to %s on %-6s   seat%-4d %-6s  created on %s \n", OrderID, flight.FlightID,
								flight.startCity.name, flight.arrivalCity.name, df.format(flight.date),seat,status, df.format(createDate));
	}

}
