package ru.eltex.phonebook;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] argv) {
		PhoneBook phoneBook = new PhoneBook();
		System.out.println("PhoneBook");
		while(true) {
			printMenu();
			switch(getInt()) {
				case 1: showAllUsers(phoneBook); break;
				case 2: addUser(phoneBook); break;
				case 3: deleteUser(phoneBook); break;
				case 4: return;
				default: break;
			}
		}
	}
	
	public static void addUser(PhoneBook phoneBook) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input name ");
		String name = in.nextLine();
		System.out.print("Input phone number ");
		String number = in.nextLine();
		phoneBook.addUser(name, number);
	}
	
	public static void deleteUser(PhoneBook phoneBook) {
		System.out.print("Input id");
		Integer id = getInt();
		phoneBook.deleteUser(id);
	}
	
	public static void showUser(PhoneBook phoneBook, Integer id) {
		String name = phoneBook.getUserName(id);
		String number = phoneBook.getUserPhoneNumber(id);
		System.out.println(name + "\t" + number);
	}
	
	public static void showAllUsers(PhoneBook phoneBook) {
		Integer size = phoneBook.getSizeBook();
		Integer count = 0;
		if(size < 0) return;
		System.out.println("id Name \tNumber");
		while(count < size) {
			System.out.print(phoneBook.getUserId(count) + "  ");
			showUser(phoneBook, count);
			count++;
		}
	}
	
	public static Integer getInt() {
		System.out.print(": ");
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public static void printMenu() {
		System.out.println("\n1) Show all users\n"
				+ "2) Add user\n"
				+ "3) Delete user\n"
				+ "4) Exit\n");
	}
}
