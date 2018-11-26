package ru.innopolis.stc12.rest.server.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userName")
public class Message {
    String name;
    String text;

    public Message() {
    }

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getText() {
        return text;
    }
}
