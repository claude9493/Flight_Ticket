package Application;
/**
 * Before writing please concern: 
 * 		Flights.statuscheck();
 * 		
 * 
 */
import java.util.Scanner;

import Admin.Admin_individual;
import Admin.Admins;
import Flight.Flights;
import Passenger.passenger;

public class Admins_UI {
	public static void Admin(Flights f, passenger p) throws Exception {
		Admin.Admins AD = new Admin.Admins();
		AD.read();
		System.out.println("======================================================");
		System.out.println("Please log in.");
		int index = AD.LOG();
		if(index == -1)
		{
			System.out.println();
		}
		else{
		After_Log(AD.List_Admin.get(index),AD,f,p);
		}
	}
	
	public static void After_Log(Admin_individual ai, Admins ad, Flights f, passenger p) throws Exception{
		Scanner input20 = new Scanner(System.in);
		while(true){
			System.out.printf("1.Manage\n2.Inquire\n0.Exit\n");
			int choose = input20.nextInt();
			if(choose == 0)
				break;
			if(choose == 1)
			{
				System.out.println("======================================================");
				f.statuscheck();
				ad.manage(ai, f);
				System.out.println("======================================================");
				
			}else if (choose == 2)
			{
				System.out.println("======================================================");
				System.out.println("Inquire");
				f.statuscheck();
				ad.inquire(f, p);
				System.out.println("======================================================");
			}
		}
		
	}

}
