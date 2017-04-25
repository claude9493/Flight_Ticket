package Application;

import java.io.FileNotFoundException;
import java.util.Scanner;
import Admin.Admins;
import Admin.Admin_individual;


public class Main_interface {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Admin.Admins.Admins_init();
		System.out.println("Admins inilize successfully!");
		Admin.Admins.Admins_show();
		UI();

	}

	public static void UI() {
		System.out.println();
		System.out.println("1.  Admin");
		System.out.println("2.  Passeager");
		int n = input.nextInt();

		switch (n) {
		case 1:
			Admin();
			break;
		case 2:
			Passeager();
			break;
		}

	}

	public static void Passeager() {

	}

	public static void Admin() {
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
