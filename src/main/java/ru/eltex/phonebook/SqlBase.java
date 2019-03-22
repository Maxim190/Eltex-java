package ru.eltex.phonebook;

import java.sql.*;
import java.util.ArrayList;

public class SqlBase implements DataBase {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private final String USER_NAME = "Max";
    private final  String USER_PSW = "qwerty";
    private final String BD_NAME = "phonebook";
    private final  String TB_NAME = "users";

    private ArrayList<User> usersArray;

    SqlBase(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + BD_NAME +
                            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
                            "useLegacyDatetimeCode=false&serverTimezone=UTC",
                    USER_NAME, USER_PSW);
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getAllUsers() {
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM " + TB_NAME);

            User.resetIdHolder();
            usersArray = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String phone = resultSet.getString(3);
                usersArray.add(new User(id, name, phone));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return usersArray;
    }

    @Override
    public void addUser(User user) {
        try {
            int id = user.getId();
            String name = user.getName();
            String phone = user.getPhoneNumber();
            statement.executeUpdate("INSERT INTO " + TB_NAME + " " +
                    "VALUES (" + id + "," +
                     " '" + name + "', " +
                     "' " + phone + "' )");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUserById(int id) {
        try {
            statement.executeUpdate("DELETE FROM " + TB_NAME + " WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean refreshBase(ArrayList<User> users) {
        return false;
    }
}
