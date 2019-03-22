package ru.eltex.phonebook;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.eltex.phonebook.*;

public class Client implements Runnable{

    private Socket socket;
    private Thread thread;
    private InputStream inputStream;
    private OutputStream outputStream;
    private BufferedReader bufferedReader;

    private final String mainBrswFile = "html.html";

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
        bufferedReader = new BufferedReader
                (new InputStreamReader(inputStream));

        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    private String getFileName(String str){
        Pattern pattern = Pattern.compile("GET\\ \\/(.*?)\\ .*");
        Matcher matcher = pattern.matcher(str);

        if(matcher.find()){
            String mg = matcher.group(1);
            return  mg.equals("") ? mainBrswFile : mg;
        }
        return mainBrswFile;
    }

    private void sendResponse(String responseFromBrws)  {
        try {
            String fileName = getFileName(responseFromBrws);
            byte[] buff = null;
            if(fileName.equals("PhoneBook.csv")){
                buff = getHtmlUserTable();
            }
            else {
                File file = new File(fileName);
                FileInputStream inputStream = new FileInputStream(file);
                buff = new byte[(int) file.length()];
                inputStream.read(buff);
            }

            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html;charset=utf-8\r\n" +
                    "Content-Length: " + buff.length +
                    "\r\nConnection: close\r\n\r\n";

            outputStream.write(response.getBytes());
            outputStream.write(buff);
            outputStream.flush();

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] getHtmlUserTable(){

        DataBase dataBase = new SqlBase();

        StringBuilder builder = new StringBuilder();
        builder.append("<html><body><center>");
        builder.append("<table border = 1>");
        builder.append("<caption>PhoneBook</caption>");
        builder.append("<tr>" +
                "<th>Id</th>" +
                "<th>Name</th>" +
                "<th>Number</th>" +
                "</tr>");
        for(User i : dataBase.getAllUsers()){
            builder.append("<tr>" +
                    "<td>" + i.getId() + "</td>" +
                    "<td>" + i.getName() + "</td>" +
                    "<td>" + i.getPhoneNumber() + "</td>" +
                    "</tr>");
        }
        builder.append("</table><center></body></html>");
        return builder.toString().getBytes();
    }

    @Override
    public void run() {
        String response = null;
            try {
                response = bufferedReader.readLine();
                sendResponse(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
