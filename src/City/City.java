package City;

public class City {
	public String name;
	public int CityID;
	public int x, y;
	
	public City(String name){
		this.name = name;
	}
	
	public void set_location(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public City(){
		
	}
	public double distance(int x1, int y1, int x2, int y2){
		int n = x1 - x2, m = y1 - y2;
		return Math.pow(Math.pow((double)n*n, 2)+Math.pow((double)m*m, 2), 0.5);
	}

}
