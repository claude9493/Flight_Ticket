package Test;

import java.util.ArrayList;

public class cheng {
	public int number;
	
	public static void main(String[] a){
		String[] list = {"a","b","c","d"};
		for(int i = 0; i<list.length; i++){
			System.out.println(list[i]);
		}
		
		for(String j : list)
			System.out.println(j);
		
//		cheng c = new cheng();
		
		ArrayList<cheng> cList = new ArrayList<cheng>();
		
		for(cheng c: cList){
			System.out.println(c.number);
		}	
	}
}
