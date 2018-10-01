package ru.innopolis.stc12.sockets.lesson.client;

import ru.innopolis.stc12.sockets.lesson.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientListener extends Thread {
    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(Server.SERVER_PORT);
             Socket socket = serverSocket.accept();
             InputStream fromServer = socket.getInputStream();
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(fromServer));) {

            String message = null;
            while ((message = serverReader.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
