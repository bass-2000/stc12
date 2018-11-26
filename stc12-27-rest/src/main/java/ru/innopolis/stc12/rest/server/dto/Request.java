package ru.innopolis.stc12.rest.server.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;

@XmlRootElement
public class Request {
    String fio;
    Calendar date;
    String dul;

    public Request() {
    }

    public Request(String fio, Calendar date, String dul) {
        this.fio = fio;
        this.date = date;
        this.dul = dul;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getDul() {
        return dul;
    }

    public void setDul(String dul) {
        this.dul = dul;
    }
}
