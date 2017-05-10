package Admin;
/***
 * Admin_induvidual class 
 * @author Claude
 */
public class Admin_individual {
	public String userName;
	private String password;
	public enum Status_List{ONLINE, OFFLINE};
	public Status_List status;
	
	public Admin_individual(String name, String password){
		this.userName = name;
		this.password = password;
		this.status = Status_List.OFFLINE;
	}
	
	public String get_password(){
		return this.password;
	}
	
	public void set_password(String np){
		this.password = np;
	}
	
	public void createFlight(){
		
	}
	
}
