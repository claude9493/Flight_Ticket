package Application;
/**
 * Entry of the whole program.
 * Main method is used to start the program and initialize necessary data
 * Different sub_interfaces of different roles are written in other classes in this package
 * 
 */

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
		UI.UI();

	}

}

	

	

