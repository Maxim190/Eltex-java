package ru.eltex.phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    DBConnection(){
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/PhoneBook","Max", "vbrc1998");
                Statement statement = connection.createStatement()){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
