package ru.eltex.phonebook;

import java.io.*;
import java.util.*;

public class PhoneBook implements CSV{

	private String phoneBookDbName = "PhoneBook.csv";
	private	ArrayList<User> usersArray;

	public boolean addUser(String name, String phoneNumber) {
		usersArray.add(new User(name, phoneNumber));
		String str = getStrForCSV(getSizeBook() - 1);
		toCSV(str, true);
		return true;
	}
	
	public void deleteUser(Integer id) {
		for(int i = 0; i < getSizeBook(); i++) {
			if(usersArray.get(i).getId() == id) {
				usersArray.remove(i);
				overwriteCSV();
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
		fromCSV();
	}
    
    public void overwriteCSV() {
    	boolean append = false;
    	Integer count = 0;
    	for(User i : usersArray) {
    		String str = getStrForCSV(count);
    		toCSV(str, append);
    		append = true;
    		count++;
    	}
    }
    
    public String getStrForCSV(Integer id) {
		Integer userId = usersArray.get(id).getId();
		String name = usersArray.get(id).getName();
		String phone = usersArray.get(id).getPhoneNumber();
		String str = userId.toString() + ";" + name + ";" + phone;
		return str;
    }

	@Override
	public void toCSV(String str, boolean append) {
		try {
			FileWriter fw = new FileWriter(phoneBookDbName, append);
			fw.write(str + "\n"); 
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String fromCSV() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(phoneBookDbName));  
			String buff = ""; 
			while(( buff = br.readLine() ) != null) { 
				String[] spliteStr = buff.split(";");
				Integer id = Integer.valueOf(spliteStr[0]);
				usersArray.add(new User(id, spliteStr[1], spliteStr[2]));
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
