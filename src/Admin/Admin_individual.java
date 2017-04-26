package Admin;
/***
 * Admin_induvidual class 
 * @author Claude
 */
public class Admin_individual {
	public String userName;
	public String password;
	public enum Status_List{ONLINE, OFFLINE};
	public Status_List status;
	
	public Admin_individual(String name, String password){
		this.userName = name;
		this.password = password;
		this.status = Status_List.OFFLINE;
	}
	

	public void Admin_inquiry(int Flight_ID){
		
	}
	public void Admin_inquiry(String city){
		
	}
	public void createFlight(){
		
	}
	

}
