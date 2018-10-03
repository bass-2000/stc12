package ru.innopolis.stc12.sockets.lesson.client;

import org.apache.log4j.Logger;
import ru.innopolis.stc12.sockets.lesson.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientListener extends Thread {
    private static Logger logger = Logger.getLogger(ClientListener.class);
    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(Server.SERVER_PORT);
             Socket socket = serverSocket.accept();
             InputStream fromServer = socket.getInputStream();
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(fromServer));) {

            String message = null;
            while ((message = serverReader.readLine()) != null) {
                logger.info(message);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
