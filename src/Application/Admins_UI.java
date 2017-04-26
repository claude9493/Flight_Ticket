package Application;

import java.util.Scanner;

public class Admins_UI {
	public static void Admin() {
		Scanner input = new Scanner(System.in);
		Admin.Admins AD = new Admin.Admins();
		System.out.println();
		System.out.println("1.  Log");
		System.out.println("2.  Register");
		int n = input.nextInt();
		switch(n){
		case 1:	
			AD.LOG();
			break;
		case 2:
			AD.register();
			break;
		}
	}

}
