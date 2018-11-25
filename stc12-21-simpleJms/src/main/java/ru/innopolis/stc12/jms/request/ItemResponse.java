package ru.innopolis.stc12.jms.request;

import java.util.UUID;

public class ItemResponse {
    private UUID id;
    private Item item;

    public ItemResponse(UUID id, Item item) {
        this.id = id;
        this.item = item;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ItemResponse{" +
                "id=" + id +
                ", item=" + item +
                '}';
    }
}
