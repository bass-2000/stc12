package ru.innopolis.stc12.jms.request;

import java.util.UUID;

public class ItemRequest {
    private Integer itemId;
    private UUID id;

    public ItemRequest(Integer itemId, UUID id) {
        this.itemId = itemId;
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItemRequest{" +
                "itemId=" + itemId +
                ", id=" + id +
                '}';
    }
}
