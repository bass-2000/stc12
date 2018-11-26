package ru.innopolis.stc12.rest.server.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Response {
    List<StopListItem> stopListItems;
    private String status;

    public Response() {
    }

    public Response(List<StopListItem> stopListItems, String status) {
        this.stopListItems = stopListItems;
        this.status = status;
    }

    public List<StopListItem> getStopListItems() {
        return stopListItems;
    }

    public void setStopListItems(List<StopListItem> stopListItems) {
        this.stopListItems = stopListItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
