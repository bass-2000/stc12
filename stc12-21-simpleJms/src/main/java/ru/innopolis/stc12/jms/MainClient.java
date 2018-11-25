package ru.innopolis.stc12.jms;

import com.google.gson.Gson;
import ru.innopolis.stc12.jms.request.Item;
import ru.innopolis.stc12.jms.request.ItemRequest;
import ru.innopolis.stc12.jms.request.ItemResponse;

import javax.jms.JMSException;
import java.util.Scanner;
import java.util.UUID;

public class MainClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;
        while ((message = scanner.nextLine()) != null) {
            try {
                System.out.println(getItem(message));
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Item getItem(String id) throws JMSException, InterruptedException {
        UUID reqId = UUID.randomUUID();
        ItemRequest itemRequest = new ItemRequest(Integer.valueOf(id), reqId);
        System.out.println(itemRequest);
        Sender sender = new Sender("itemsDao.in");
        sender.sendMessage(itemRequest);
        sender.close();
        Thread.sleep(3000);

        Receiver receiver = new Receiver("itemsDao.out");
        String answer = "";
        answer = receiver.receiveMessage();
        ItemResponse response = new Gson().fromJson(answer, ItemResponse.class);
        System.out.println(response);
        receiver.close();
        Thread.sleep(3000);
        if (reqId.equals(response.getId())) {
            return response.getItem();
        } else {
            System.out.println("Wrong UUID");
            return null;
        }
    }
}
