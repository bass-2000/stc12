package ru.innopolis.stc12.sockets.lesson;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Integer CLIENT_PORT = 4998;
    private static Logger logger = Logger.getLogger(Client.class);
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", Server.SERVER_PORT);
             OutputStreamWriter serverOutput = new OutputStreamWriter(socket.getOutputStream());
             InputStreamReader serverInput = new InputStreamReader(socket.getInputStream());
        ) {
            Scanner scanner = new Scanner(System.in);
            String message;
            BufferedReader bufferedReader = new BufferedReader(serverInput);
            while ((message = scanner.nextLine()) != "") {
                BufferedWriter bufferedWriter = new BufferedWriter(serverOutput);
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                logger.info("Server echo: " + bufferedReader.readLine());
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }
}