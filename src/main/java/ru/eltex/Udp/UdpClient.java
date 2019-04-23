//package ru.eltex.phonebook;

import java.net.*;
import java.io.*;

class UdpClient{
    public static void main(String[] args){
        try{
            DatagramSocket socket = new DatagramSocket();
            String s = "Hello";
            byte[] buff = s.getBytes();
            DatagramPacket pack = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"), 4016);
            socket.send(pack);
        }
        catch(IOException e){}
    }
}