package Passenger;

import java.util.ArrayList;

import Order.Order;

class Passenger_ind {
	public int passagerID;
	String realName;
	String identityID;
	String password;
	ArrayList<Order> orderlist;
	enum state{REGISTERED, UNREGISTERED};
}
