package ru.innopolis.stc12.sockets.client;

import ru.innopolis.stc12.sockets.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class BotClient extends Client {

    public static void main(String[] args) {
        new BotClient().run();

    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        Random random = new Random();
        return "date_bot_" + (random.nextInt(100));
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if (message != null) {
                ConsoleHelper.writeMessage(message);
                SimpleDateFormat format = null;
                if (message.contains(": ")) {
                    String[] massiv = message.split(": ");
                    if (massiv.length == 2 && massiv[1] != null) {
                        String name = massiv[0];
                        String text = massiv[1];
                        switch (text) {
                            case "дата":
                                format = new SimpleDateFormat("d.MM.yyyy");
                                break;
                            case "день":
                                format = new SimpleDateFormat("d");
                                break;
                            case "месяц":
                                format = new SimpleDateFormat("MMMM");
                                break;
                            case "год":
                                format = new SimpleDateFormat("yyyy");
                                break;
                            case "час":
                                format = new SimpleDateFormat("H");
                                break;
                            case "минуты":
                                format = new SimpleDateFormat("m");
                                break;
                            case "секунды":
                                format = new SimpleDateFormat("s");
                                break;
                            default:
                                format = new SimpleDateFormat("H:mm:ss");
                                break;

                        }
                            sendTextMessage(String.format("Информация для %s: %s", name, format.format(Calendar.getInstance().getTime())));
                    }
                }
            }
        }
    }
}
