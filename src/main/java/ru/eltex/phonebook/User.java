package ru.eltex.phonebook;

public class User {
	
	private int id;
	private String name;
	private String phoneNumber;
	private static int usersQuantity = 0;
	private static int idHolder = 0;

	public static void resetIdHolder(){
		usersQuantity = 0;
		idHolder = 0;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		if(!name.isEmpty()) {
			this.name = name;
		}
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	private void setPhoneNumber(String phoneNumber) {
		if(!phoneNumber.isEmpty()) {
			this.phoneNumber = phoneNumber;
		}
	}

	User(String name, String phoneNumber){
		this(++idHolder, name, phoneNumber);
	}
	
	User(int id, String name, String phoneNumber){
		if(idHolder < id)
			idHolder = id;
		this.id = id;
		setName(name);
		setPhoneNumber(phoneNumber);
	}
}
