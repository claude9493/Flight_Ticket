package City;

import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class CityList {
	public ArrayList<City> city_list = new ArrayList<City>(); 
	
//	Add a new city to the list and the file
	public void add_city() throws Exception
	{
		Scanner input30 = new Scanner(System.in);
		System.out.println("==============================");
		System.out.print("City Name:\t");
		String name = input30.next();
		System.out.print("\nCity ID:\t");
		int ID = input30.nextInt();
		City new_city = new City(ID, name);
		city_list.add(new_city);
		write(new_city);
	}
	
//	Write cities'information to the file
	public void write(City newcity) throws Exception
	{
		int id = newcity.CityID;
		String name = newcity.name;
		Formatter output = new Formatter("City.txt");
		output.format("%d\t%s\n", id, name);
	}
	
//	Read the file and put the informations in the city_list
	public void read() throws Exception
	{
		Scanner input31 = new Scanner(new File("City.txt"));
		int ID;
		String name;
		while ( input31.hasNext() )
		{
			ID = input31.nextInt();
			name = input31.next();
			City now_city = new City(ID, name);
			city_list.add(now_city);
		}
	}
	
//	Get the index of the city while the city'sname is giver
	public int index_of(String name)
	{
		for(City s : city_list)
		{
			if(s.name.equals(name))
				return city_list.indexOf(s);
		}
		return -1;
	}
	
	
//	List all available cities
	public void all_city()
	{
		System.out.println("All cities:");
		for(City s : city_list)
		{
			System.out.printf("%s    ", s.name);
		}
		System.out.println();
		
	}


}
