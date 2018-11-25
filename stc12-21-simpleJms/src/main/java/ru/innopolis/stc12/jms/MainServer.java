package ru.innopolis.stc12.jms;

import com.google.gson.Gson;
import ru.innopolis.stc12.jms.request.Item;
import ru.innopolis.stc12.jms.request.ItemRequest;
import ru.innopolis.stc12.jms.request.ItemResponse;

import javax.jms.JMSException;
import java.util.HashMap;
import java.util.Map;

public class MainServer {
    private static Map<Integer, Item> items = new HashMap<>();

    public static void main(String[] args) {
        createList();
        boolean cycleFlag = true;
        try {
            while (cycleFlag) {
                Receiver receiver = new Receiver("itemsDao.in");
                String request = receiver.receiveMessage();
                ItemRequest itemRequest = new Gson().fromJson(request, ItemRequest.class);
                Item item = items.get(itemRequest.getItemId());
                ItemResponse itemResponse = new ItemResponse(itemRequest.getId(), item);
                receiver.close();
                System.out.println(itemRequest);
                Thread.sleep(3000);

                Sender sender = new Sender("itemsDao.out");
                sender.sendMessage(itemResponse);
                sender.close();
                Thread.sleep(3000);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void createList() {
        items.put(1, new Item(1, "Nokia 3310", "Nokia", 12000.00, "Some descr"));
        items.put(2, new Item(2, "Siemens C35", "Siemens", 14000.00, "Some descr"));
        items.put(3, new Item(3, "Samsung s2", "Samsung", 18000.00, "Some descr"));
        items.put(4, new Item(4, "Iphone 4", "Apple", 17000.00, "Some descr"));
        items.put(5, new Item(5, "Iphone 1", "Apple", 10000.00, "Some descr"));
    }
}