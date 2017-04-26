package Application;

import java.util.Scanner;

public class UI 
{
	public static void UI() 
	{
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("1.  Admin");
		System.out.println("2.  Passeager");
		System.out.println("3.  Inquiry");
		int n = input.nextInt();

		switch (n) 
		{
		case 1:
			Admins_UI.Admin();
			break;
		case 2:
			Passenger_UI.Passeager();
			break;
		}
	}
}

