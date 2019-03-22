package ru.eltex.phonebook;

import java.util.ArrayList;

public interface DataBase {

    ArrayList<User> getAllUsers();
    void addUser(User user);
    void deleteUserById(int id);
    boolean refreshBase(ArrayList<User> users);
}
