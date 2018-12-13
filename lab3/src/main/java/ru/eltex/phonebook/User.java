package ru.eltex.phonebook;

public class User {
	
	private Integer id;
	private String name;
	private String phoneNumber;
	private static int usersQuantity;
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(!name.isEmpty()) {
			this.name = name;
		}
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		if(!phoneNumber.isEmpty()) {
			this.phoneNumber = phoneNumber;
		}
	}
	
	User(String name, String phoneNumber){
		id =  usersQuantity++; 
		setName(name);
		setPhoneNumber(phoneNumber);
	}
}
