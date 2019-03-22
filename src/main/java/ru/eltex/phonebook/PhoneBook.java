package ru.eltex.phonebook;

import java.util.*;

public class PhoneBook{

	private DataBase dataBase;

    public PhoneBook(){
		dataBase = new CSVBase();//new SqlBase();
		createMenu();
	}

	void createMenu(){
		Scanner in = new Scanner(System.in);
		System.out.println("PhoneBook");
		while(true) {
			printMenu();
			System.out.print("input: ");
			switch(in.nextInt()) {
				case 1: showAllUsers(); break;
				case 2: addUser(); break;
				case 3: deleteUser(); break;
				case 4: return;
				default: return;
			}
		}
	}

	private void addUser() {
		Scanner in = new Scanner(System.in);
		System.out.print("Input name: ");
		String name = in.nextLine();
		System.out.print("Input phone number: ");
		String number = in.nextLine();

		dataBase.addUser(new User(name, number));
	}

	private void deleteUser() {
		System.out.print("Input id: ");
		Scanner in = new Scanner(System.in);
		dataBase.deleteUserById(in.nextInt());
	}

	private void showAllUsers() {

		System.out.println("id Name \tNumber");

		for(User user : dataBase.getAllUsers()){
			int id = user.getId();
			String name = user.getName();
			String phone = user.getPhoneNumber();
			System.out.print(id + "  " + name + "\t\t" + phone + "\n");
		}
	}

	private void printMenu() {
		System.out.println("\n1) Show all users\n"
				+ "2) Add user\n"
				+ "3) Delete user\n"
				+ "4) Exit\n");
	}

	public static void main(String[] argv) {
		new PhoneBook();
	}
}
