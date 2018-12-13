package ru.eltex.phonebook;
import  java.util.*;

public class PhoneBook {

	private	ArrayList<User> usersArray;

	public boolean addUser(String name, String phoneNumber) {
		return usersArray.add(new User(name, phoneNumber));			
	}
	
	public void deleteUser(Integer id) {
		for(int i = 0; i < getSizeBook(); i++) {
			if(usersArray.get(i).getId() == id) {
				usersArray.remove(i);
			}
		}
	}

	public String getUserName(Integer numberInArray) {
		return usersArray.get(numberInArray).getName();
	}
	
	public String getUserPhoneNumber(Integer numberInArray) {		
		return usersArray.get(numberInArray).getPhoneNumber();
	}
	
	public Integer getUserId(Integer numberInArray) {
		return usersArray.get(numberInArray).getId();
	}
	
	public Integer getSizeBook() {
		return usersArray.size();
	}
	
    PhoneBook(){
		usersArray = new ArrayList<User>();
	}
}
