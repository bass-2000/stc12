package ru.innopolis.stc12.sockets.lesson.server;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.sockets.lesson.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread {
    private static Logger logger = Logger.getLogger(ServerListener.class);
    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(Client.CLIENT_PORT);
             Socket socket = serverSocket.accept();
             InputStream fromClient = socket.getInputStream();
             BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));) {
            String message = null;
            while ((message = clientReader.readLine()) != null) {
                logger.info(message);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
