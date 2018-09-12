package ru.innopolis.stc12.sockets.lesson;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Integer CLIENT_PORT = 4998;
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", Server.SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            OutputStreamWriter serverOutput = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader serverInput = new InputStreamReader(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            String message;
            BufferedReader bufferedReader = new BufferedReader(serverInput);
            while ((message = scanner.nextLine()) != "") {
                BufferedWriter bufferedWriter = new BufferedWriter(serverOutput);
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println("Server echo: " + bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}