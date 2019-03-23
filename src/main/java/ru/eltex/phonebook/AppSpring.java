package ru.eltex.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
public class AppSpring {
    public static void main(String[] args) {
        SpringApplication.run(AppSpring.class, args);
    }
}

@RestController
class RestUsers{
    @RequestMapping
    public ArrayList<User> getUsers(){
        return new SqlBase().getAllUsers();
    }
}