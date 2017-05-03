package Order;

import java.util.Date;

import Flight.Flight_ind;

public class Order {
	public int passengerID;
	public String seat;
	public Flight_ind flight;
	public Date createDate;
	public enum StatusList{UNPAID,PAID,CANCEL};
	public StatusList status;

}
