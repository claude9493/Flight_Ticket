package Admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
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
import java.util.Formatter;
import java.util.Scanner;

import Flight.Flights;
import Order.Order;
import Passenger.Passenger_ind;
import Passenger.passenger;

public class Admins {

	public ArrayList<Admin_individual> List_Admin = new ArrayList<Admin_individual>();

	
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
	public int LOG() {
		Scanner input81 = new Scanner(System.in);
//		System.out.println("");
		System.out.print("Admin name:\t");
		String name = input81.next();
		System.out.print("Password:\t");
		String password = input81.next();
		if (check(name) != -1) {
			int index = check(name);
			if (List_Admin.get(index).get_password().equals(password)) {
				System.out.println("Successfully Log In!\n");
				System.out.println("======================================================");
				return index;
			} else {
				System.out.println("Password may be wrong!");
				return -1;
			}
		} else
			System.out.println("Such admin doesn't exist.");
		return -1;

	}

	// Register
	public void register() throws Exception {
		Scanner input82 = new Scanner(System.in);
//		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("======================================================");
		System.out.print("Name:\t");
		String name = input82.next();
		System.out.print("\nPassword:\t");
		String password = input82.next();
		if (check(name) != -1) {
			System.out.println("Such admin already exists in system.");
			return;
		}
		Admin_individual newAdmin = new Admin_individual(name, password);
		List_Admin.add(newAdmin);
		this.write(newAdmin);
		System.out.println("Successfully add a new Admin.");
	}

	// super inquire for admins
	public void inquire(Flights f, passenger p) {
		Scanner input83 = new Scanner(System.in);
//		System.out.println("======================================================");
		while (true) {
			System.out.printf("1.Inquire Flight\n2.Inquire Order\n3.Inquire Passenger\n0.Exit\n");
			int choose = input83.nextInt();
			if (choose == 0) {
				System.out.println();
				break;
			}
			switch (choose) {
			case 1:
				f.inquire_p(0);
				System.out.println();
				break;
			case 2:
				p.Order_inquire();
				System.out.println();
				break;
			case 3:

				System.out.print("1.List all passengers    2.Inquire by PassengerID\n");
				int choose2 = input83.nextInt();
				if (choose2 == 1) {
					for (Passenger_ind pi : p.PassengerList)
						System.out.printf("%d %s %s\n", pi.passagerID, pi.identityID, pi.realName);
					System.out.println();
				} else if (choose2 == 2) {
					System.out.print("Enter the passengerID:  ");
					int ID = input83.nextInt();
					for (Passenger_ind pi : p.PassengerList)
						if (pi.passagerID == ID) {
							System.out.printf("%d  %s  %s\nAll his\\her order:\n", pi.passagerID, pi.identityID,
									pi.realName);
							for (Order o : pi.myorder)
								o.Oprint();
							System.out.println();
							break;
						}
				} else
					System.out.println("Invalid input.\n");
				break;
			default:
				System.out.println("Invalid input.\n");
				break;
			}
		}
	}

	// manage function for admins: manage order and flight and admins list
	public void manage(Admin_individual ai, Flights f) throws Exception {
//		System.out.println();
		Scanner input84 = new Scanner(System.in);
		while (true) {
//			System.out.println("======================================================");
			System.out.printf(
					"MANAGE\n1.AdminsManage\t2.FlightsManage\n3.PassengerManage\t0.Exit\n");
			int choose = input84.nextInt();
//			System.out.println();
			if (choose == 0)
				break;
			switch (choose) {
			case 1:
				while (true) {
					System.out.printf("1.Add a new admin\t2. Modify self information\t0.Exit\n");
					int choose2 = input84.nextInt();
					if (choose2 == 0)
						break;
					if (choose2 == 1) {
						register();
					} else if (choose2 == 2) {
						System.out.print("New name:  ");
						ai.userName = input84.next().trim();
						System.out.print("New password:  ");
						ai.set_password(input84.next().trim());
						rewrite();
						System.out.println("Succseefully modify self information.");
					} else
						System.out.println("Invalid input.");
				}
				break;
			case 2:
				while (true) {
					System.out.print("1.Modify\t2.Add\t0.Exit\n");
					int choose2 = input84.nextInt();
					if (choose2 == 0)
						break;
					if (choose2 == 1) {
						f.modify();
						f.rewrite();
						System.out.println();
					} else if (choose2 == 2) {
						f.AddFlight();
//						f.rewrite();
						System.out.println();
					} else
						System.out.println("Invalid input.");
				}
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

	// Rewrite the whole file after modify informations, by deleting the file
	// first and then write all information again.
	public void rewrite() throws Exception {
//		File file = new File("Admins.txt");
//		file.delete();
//		file.createNewFile();
		RandomAccessFile r = new RandomAccessFile("Admins.txt", "rw");
//		r.seek(r.length());
		for (Admin_individual ai : List_Admin) {
			r.writeBytes(String.format("%s\t%s\t%s\r\n", ai.userName, ai.get_password(), ai.status));
		}
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
