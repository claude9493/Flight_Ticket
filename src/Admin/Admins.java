package Admin;
/**
 * Admins class [Unfinished]
 * List_Admin存储Admins, 每次启动时，用 Admins_read 从文档中读取Admins的数据，提取到List_Admin里面
 * Admins_init初始化文档，提供几个 Admins 的实例 [staging] [finished]
 * Admins_show 展示文档中所有Admins，Name  Status [staging][finished]
 * check 检查 某 Admin 是否在List_Admin里面，若在返回其index，若不在返回-1 [finished]
 * Log and Register methods are [finished]
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import Admin.Admin_individual.Status_List;

public class Admins {

	ArrayList<Admin_individual> List_Admin = new ArrayList<Admin_individual>();
	int List_Length;

/*
 
	public void Admin_Register() {

		System.out.println("Please input your name and your password\n+++++++++++++++++++++++++++");
		System.out.print("Name:\t");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		System.out.print("Password:\t");
		String npassword = input.nextLine();
		input.close();
		if (contains(List_Admin, name))
			return;
		Admin_individual n = new Admin_individual(name, npassword);
		List_Admin[++List_Length] = n;
		System.out.println("New account is successfully established.");
	}

	public void Admin_Log_In() {
		System.out.print("Name:\t");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		if (contains(List_Admin, name)) {
			int index = numberof(List_Admin, name);
			System.out.print("Password:\t");
			String password = input.nextLine();
			if (List_Admin[index].password == password) {

				System.out.println("Successfully Log In!");
				List_Admin[index].status = Status_List.ONLINE;

			} else {
				System.out.println("Wrong Password!");
			}

		} else {
			System.out.println(
					"Such account does not exist, Please check the name you input or establish a new account. ");
		}
		input.close();
	}

	// check whether a name is in the list of Admins
	public boolean contains(Admin_individual[] AL, String iname) {
		for (Admin_individual i : AL) {
			if (i.userName == iname)
				return false;
		}
		return true;
	}

	// get the index of a name in the list of admins
	public int numberof(Admin_individual[] AL, String iname) {
		int n = 1;
		for (Admin_individual i : AL) {
			n++;
			if (i.userName == iname) {
				return n;
			}
		}
		return 0;
	}
	
*/	
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
//	Read Admins information from the list
	public void Admins_read() throws FileNotFoundException{
		Scanner input = new Scanner(new File("Admins.txt"));
		while(input.hasNext()){
			String name = input.next();
			String password = input.next();
			String status = input.next();
			Admin_individual newguy = new Admin_individual(name, password);
			List_Admin.add(newguy);
		}
		input.close();
	}
//	Create the file that stores the information of Admins
	public static void Admins_init() throws FileNotFoundException{
		Formatter output = new Formatter("Admins.txt");
		output.format("Zhangyun 123456 OFFLINE\nSunbokai 234567 OFFLINE\nLishiyi 34567 OFFLINE");
		output.close();
	}

//	Show all of the admins
	public void Admins_show() throws FileNotFoundException{
		Scanner read = new Scanner(new File("Admins.txt"));
		while(read.hasNext()){
			String Name = read.next();
			String password = read.next();
			String status = read.next();
			System.out.printf("%-12s%10s\n", Name, status);
		}
		read.close();
	}
	
//check whether some one is in the list
	public int check(String name){
		int count = 0;
		for(Admin_individual anyone : List_Admin){
			if(anyone.userName.equals(name))
//				String is reference which cannot be compared straightly, here we use equals method
				return count;
		}
		count++;
		return -1;
	}
	
//	Log
	public void LOG()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.print("Admin name:\t");
		String name = input.next();
		System.out.print("\nPassword:\t");
		String password = input.next();
		if (check(name) != -1)
		{
			int index = check(name);
			if(List_Admin.get(index).password.equals(password))
				System.out.println("Successfully Log In!");
		}
		else
		{
			System.out.println("Name or Password may be wrong!");
		}
		
	}
	
//	Register
	public void register(){
		Scanner input = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Name:\t");
		String name = input.next();
		System.out.print("\nPassword:\t");
		String password = input.next();
		if(check(name)!=-1)
			System.out.println("Such admin already exists in system.");
		Admin_individual newAdmin = new Admin_individual(name, password);
		List_Admin.add(newAdmin);
		input.close();
	}
//	super inquire for admins
	public void inquire(){
		
	}
//	manage function for admins: manage order and flight and admins list
	public void manage(){
		
	}
//	write data to the .txt file
	public void write(){
		
	}
	
	
//	main function used to test
	public void main(String[] a) throws FileNotFoundException{
		Admins_show();
		Admins_read();
		for(Admin_individual someone : List_Admin){
			System.out.println(someone.userName+"\t"+someone.password+"\t"+someone.status);
		}
		
	}

}
