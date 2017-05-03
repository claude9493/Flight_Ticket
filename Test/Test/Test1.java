package Test;

import java.util.Scanner;

/**
 * This class is used to test the possibility of input data in a call of one method
 * @author Claude
 * 
 * @RESULT:	It is okay to input data in a call of one method
 *
 */

public class Test1 {
	public String value;
	public void set_value(String s)
	{
		this.value = s;
	}
	/*
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		Test1 tes = new Test1();
		String s = "Hello";
		tes.set_value(input.nextLine());
		System.out.println(tes.value);
		tes.set_value(s);
		System.out.println(tes.value);
		input.close();

	}
	
	*/
	

}
