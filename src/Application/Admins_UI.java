package Application;
/**
 * Before writing please concern: 
 * 		Flights.statuscheck();
 * 		
 * 
 */
import java.util.Scanner;

public class Admins_UI {
	public static void Admin() {
		Scanner input = new Scanner(System.in);
		Admin.Admins AD = new Admin.Admins();
		System.out.println();
		System.out.println("Please log in.");
		AD.LOG();
	}

}
