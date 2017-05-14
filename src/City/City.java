package City;

public class City {
	public String name;
	public int CityID;
	public int x, y;
//	Constructor: only name
	public City(String name){
		this.name = name;
	}
//	Constructor: ID and name
	public City(int index, String name){
		this.CityID = index;
		this.name = name;
	}
//	Location on Cartesian coordinate
	public void set_location(int x, int y){
		this.x = x;
		this.y = y;
	}
//	Constructor: no parameter
	public City(){
		this("Anywhere");
	}
//	Distance: calculate the distance between two cities
	public double distance(int x1, int y1, int x2, int y2){
		int n = x1 - x2, m = y1 - y2;
		return Math.pow(Math.pow((double)n, 2)+Math.pow((double)m, 2), 0.5);
	}

}
