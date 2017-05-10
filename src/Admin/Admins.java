package Admin;

/**
 * Admins class [Unfinished]
 * List_Admin�洢Admins, ÿ������ʱ���� Admins_read ���ĵ��ж�ȡAdmins�����ݣ���ȡ��List_Admin����
 * Admins_init��ʼ���ĵ����ṩ���� Admins ��ʵ�� [staging] [finished]
 * Admins_show չʾ�ĵ�������Admins��Name  Status [staging][finished]
 * check ��� ĳ Admin �Ƿ���List_Admin���棬���ڷ�����index�������ڷ���-1 [finished]
 * Log and Register methods are [finished]
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Formatter;
import Admin.Admin_individual.Status_List;

public class Admins {

	ArrayList<Admin_individual> List_Admin = new ArrayList<Admin_individual>();
	int List_Length;

	/*
	 * 
	 * public void Admin_Log_In() { System.out.print("Name:\t"); Scanner input =
	 * new Scanner(System.in); String name = input.nextLine(); if
	 * (contains(List_Admin, name)) { int index = numberof(List_Admin, name);
	 * System.out.print("Password:\t"); String password = input.nextLine(); if
	 * (List_Admin[index].password == password) {
	 * 
	 * System.out.println("Successfully Log In!"); List_Admin[index].status =
	 * Status_List.ONLINE;
	 * 
	 * } else { System.out.println("Wrong Password!"); }
	 * 
	 * } else { System.out.println(
	 * "Such account does not exist, Please check the name you input or establish a new account. "
	 * ); } input.close(); }
	 * 
	 * // check whether a name is in the list of Admins public boolean
	 * contains(Admin_individual[] AL, String iname) { for (Admin_individual i :
	 * AL) { if (i.userName == iname) return false; } return true; }
	 * 
	 * // get the index of a name in the list of admins public int
	 * numberof(Admin_individual[] AL, String iname) { int n = 1; for
	 * (Admin_individual i : AL) { n++; if (i.userName == iname) { return n; } }
	 * return 0; }
	 * 
	 */
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	// Read Admins information from the list
	public void read() throws FileNotFoundException {
		Scanner input80 = new Scanner(new File("Admins.txt"));
		while (input80.hasNext()) {
			String name = input80.next();
			String password = input80.next();
			String status = input80.next();
			Admin_individual newguy = new Admin_individual(name, password);
			List_Admin.add(newguy);
		}
	}

	// Create the file that stores the information of Admins
	public static void Admins_init() throws FileNotFoundException {
		Formatter output = new Formatter("Admins.txt");
		output.format("Zhangyun 123456 OFFLINE\nSunbokai 234567 OFFLINE\nLishiyi 34567 OFFLINE");
		output.close();
	}

	// check whether some one is in the list
	public int check(String name) {
		int count = 0;
		for (Admin_individual anyone : List_Admin) {
			if (anyone.userName.equals(name))
				// String is reference which cannot be compared straightly, here
				// we use equals method
				return count;
		}
		count++;
		return -1;
	}

	// Log
	public void LOG() {
		Scanner input81 = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.print("Admin name:\t");
		String name = input81.next();
		System.out.print("\nPassword:\t");
		String password = input81.next();
		if (check(name) != -1) {
			int index = check(name);
			if (List_Admin.get(index).get_password().equals(password))
				System.out.println("Successfully Log In!");
		} else {
			System.out.println("Name or Password may be wrong!");
		}

	}

	// Register
	public void register() throws Exception {
		Scanner input82 = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Name:\t");
		String name = input82.next();
		System.out.print("\nPassword:\t");
		String password = input82.next();
		if (check(name) != -1)
			System.out.println("Such admin already exists in system.");
		Admin_individual newAdmin = new Admin_individual(name, password);
		List_Admin.add(newAdmin);
		this.write(newAdmin);
	}

	// super inquire for admins
	public void inquire() {
		Scanner input83 = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.printf("1.Inquire Flight\n2.Inquire Order\n3.Inquire Passenger");
		int choose = input83.nextInt();
		switch (choose) {
		case 1:
		case 2:
		case 3:
		}
	}

	// manage function for admins: manage order and flight and admins list
	public void manage() {
		System.out.println();
		Scanner input84 = new Scanner(System.in);
		while (true) {
			System.out.printf("MANAGE\n1.AdminsManage2.FlightsManage3.PassengerManage\n0.Exit");
			int choose = input84.nextInt();
			if (choose == 0)
				break;
			switch (choose) {
			case 1:
				break;
			case 2:
				while (true) {
					System.out.print("1.Modify\t2.Add\t0.Exit\n");
					int choose2 = input84.nextInt();
					if (choose2 == 0)
						break;
					if(choose2 == 1){
						
					}
					else if(choose2 == 2 ){
						
					}
					else System.out.println("Invalid input.");
				}
				break;
			case 3:
				break;
			}
		}

	}

	// write data to the .txt file
	public void write(Admin_individual ai) throws Exception {
		RandomAccessFile r = new RandomAccessFile("Admins.txt", "rw");
		r.seek(r.length());
		r.writeBytes(String.format("%s\t%s\t%s\r\n", ai.userName, ai.get_password(), ai.status));
	}

	// main function used to test
	public void main(String[] a) throws FileNotFoundException {
		Admins test = new Admins();
		read();
		for (Admin_individual someone : List_Admin) {
			// System.out.println(someone.userName+"\t"+someone.+"\t"+someone.status);
		}
		test.LOG();

	}

}
