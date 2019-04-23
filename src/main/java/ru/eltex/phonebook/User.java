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

	public int getId() {
		return id;
	}

	private void setId(int id){
		try {
			if(idHolder < id)
				idHolder = id;
			this.id = id;
		}catch (NullPointerException e){
			throw new NullPointerException("field 'id' is null");
		}
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		try {
			if (name.isEmpty())
				throw new IllegalArgumentException("field 'name' is empty");
			this.name = name;
		}catch (NullPointerException e){
			throw new NullPointerException("field 'name' is null");
		}
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	private void setPhoneNumber(String phoneNumber) {
		try {
			if(phoneNumber.isEmpty())
				throw new IllegalArgumentException("field 'phoneNumber' is empty");
			this.phoneNumber = phoneNumber;

		}catch (NullPointerException e){
			throw new NullPointerException("field 'phoneNumber' is null");
		}
	}

	public User(String name, String phoneNumber){
		this(++idHolder, name, phoneNumber);
	}
	
	public User(int id, String name, String phoneNumber){
		setId(id);
		setName(name);
		setPhoneNumber(phoneNumber);
	}
}
