package Test;

import java.util.Scanner;

public class Test_of_input_dot_nextline {
	public void LOG()
	{
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.print("Name\t\t\tPassword\n");
		String name = input.next().trim();//trim is used to remove the space in the input.
//		System.out.print("Password:\t");
		String password = input.next().trim();
		System.out.printf("Name:%s\npassword:%s",name, password	);
	}
	
	public static void main(String[] a){
		Test_of_input_dot_nextline test = new Test_of_input_dot_nextline();
		test.LOG();
	}

}

