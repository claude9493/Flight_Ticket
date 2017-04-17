package Admin;

//import java.util.ArrayList;
import java.util.Scanner;

import Admin.Admin_individual.Status_List;

class Admins {

	final int MAXADMINS = 20;
	Admin_individual[] List_Admin = new Admin_individual[MAXADMINS + 1];
	int List_Length;

	void LAInit(Admins ad) {
		ad.List_Length = 0;
	}

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

}
