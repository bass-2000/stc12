package ru.innopolis.stc12.rest.server.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

@XmlRootElement
public class StopListItem {
    String number;
    Calendar dateAdded;
    Calendar dateToForget;

    public StopListItem() {
    }

    public StopListItem(String number, Calendar dateAdded, Calendar dateToForget) {
        this.number = number;
        this.dateAdded = dateAdded;
        this.dateToForget = dateToForget;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Calendar getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Calendar dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Calendar getDateToForget() {
        return dateToForget;
    }

    public void setDateToForget(Calendar dateToForget) {
        this.dateToForget = dateToForget;
    }
}