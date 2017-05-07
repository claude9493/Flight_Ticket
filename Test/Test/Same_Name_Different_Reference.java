package Test;
/**
 * NOTE:
 * This class is used to test the possibility of recreate objects with one name in a loop(i.e What is the scope of a object)
 * 
 * APPEARANCE: 
 * In the while loop, the program create a new object named test1, and change test1.var to be same with the current n
 * then I input a new n and this n decides the following process(end up the loop or go ahead).
 * And there is no bug!!!
 * 
 * RESULT:
 * The scope of an object in a loop is limited to the loop.
 * It is okay to use this feature to achieve the read() method in Flights.java and passenger.java 
 * (Where the information stored in the document is gotten and added to the corresponding ArrayList)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Same_Name_Different_Reference {

	public int var;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Same_Name_Different_Reference> list = new ArrayList<Same_Name_Different_Reference>();
		int n = 1;
		System.out.println(list.toString());
		Scanner input = new Scanner(System.in);
		while (n != 0) {
			Same_Name_Different_Reference test1 = new Same_Name_Different_Reference();
			test1.var = n;
			list.add(test1);
			System.out.println(list.toString());
			n = input.nextInt();
		}
		System.out.println();
		for (Same_Name_Different_Reference s : list)
			System.out.println(s.var);

	}

}
