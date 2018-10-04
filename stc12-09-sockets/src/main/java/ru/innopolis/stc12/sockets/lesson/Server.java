package ru.innopolis.stc12.sockets.lesson;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer SERVER_PORT = 4999;
    private static Logger logger = Logger.getLogger(Server.class);
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
             Socket socket = serverSocket.accept();
             InputStream fromClient = socket.getInputStream();
             OutputStream toClient = socket.getOutputStream();
             BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
             BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(toClient));) {

            String message = null;
            while ((message = clientReader.readLine()) != null) {
                logger.info(message);
                clientWriter.write("\"" + message + "\" received \n");
                clientWriter.flush();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}