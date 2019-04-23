//package ru.eltex.phonebook;
import java.net.*;
import java.io.*;


class UdpServer{
    public static void main(String[] args){
        try{
           DatagramSocket socket = new DatagramSocket(4016);
           byte[] buff = new byte[65000];
           DatagramPacket pack = new DatagramPacket(buff, buff.length);
           while(true){
                socket.receive(pack);
                byte[] tmp = pack.getData();
                String s = new String(tmp);
                System.out.println(s);
           } 
        }
        catch(IOException e){}
    }
}