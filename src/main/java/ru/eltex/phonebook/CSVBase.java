package ru.eltex.phonebook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVBase implements DataBase, CSV{

    private String phoneBookDbName = "PhoneBook.csv";
    private ArrayList<User> usersArray;

    public CSVBase(){
        usersArray = new ArrayList<>();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        fromCSV();
        return usersArray;
    }

    @Override
    public void addUser(User user) {
        toCSV(user, true);
    }

    @Override
    public void deleteUserById(int id) {
        if(usersArray.removeIf(x -> x.getId() == id)) {
            boolean append = false;
            for (User user : usersArray) {
                toCSV(user, append);
                append = true;
            }
        }
    }

    @Override
    public boolean refreshBase(ArrayList<User> users) {
        return false;
    }

    @Override
    public void toCSV(User user, boolean append) {
        try {
            int id = user.getId();
            String name = user.getName();
            String phone = user.getPhoneNumber();
            String str = id + ";" + name + ";" + phone;

			FileWriter fw = new FileWriter(phoneBookDbName, append);
			fw.write(str + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void fromCSV() {
        try {
            usersArray = new ArrayList<>();
            User.resetIdHolder();
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
    }
}
