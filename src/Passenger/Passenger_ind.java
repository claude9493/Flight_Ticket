package Passenger;

import java.util.ArrayList;

import Order.Order;

class Passenger_ind {
	public int passagerID;
	public String realName;
	public String identityID;
	private String password;
	public ArrayList<Order> myorder;

	enum status_list {
		ONLINE, OFFLINE
	};
	status_list status = status_list.OFFLINE;

	public void set_password(String password) {
		this.password = password;
	}

	public String get_password() {
		return this.password;
	}
	
	public void change_status(){
		if(this.status == status_list.OFFLINE)
			status = status_list.ONLINE;
		else
			status = status_list.OFFLINE;
	}
}
