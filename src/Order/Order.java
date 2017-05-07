package Order;

import java.util.Date;

import Passenger.Passenger_ind;
import Flight.Flight_ind;

public class Order {
	public int OrderID;
	public int passengerID;
	public int seat;
	public Flight_ind flight;
	public Date createDate;
	public enum StatusList{UNPAID,PAID,CANCEL};
	public StatusList status;
	
	public Order(Flight_ind f, Passenger_ind p)
	{
		this.flight = f;
		this.passengerID = p.passagerID;
		this.status = StatusList.UNPAID;
	}

}
