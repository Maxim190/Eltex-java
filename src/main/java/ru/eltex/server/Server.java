package ru.eltex.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    private final int port = 8099;

    public static void main(String[] args)throws IOException {
        new Server();
    }

    private Server() throws IOException {
        try(ServerSocket socket = new ServerSocket(port)) {
            while (true) { 
                System.out.println("Server started");
                new Client(socket.accept());
                System.out.println("connected new client");
            }
        }catch (IOException e){
            e.getMessage();
        }
    }
}
