package ru.innopolis.stc12.jmsTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MessageReceiver {
    private final ConnectionFactory connectionFactory;
    private JmsTemplate jmsTemplate;

    @Autowired
    public MessageReceiver(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @PostConstruct
    public void init() {
        this.jmsTemplate = new JmsTemplate(connectionFactory);
    }

    public void receive(String queue) {
        Message message = jmsTemplate.receive(queue);
        TextMessage textMessage = (TextMessage) message;
        String text;
        try {
            text = textMessage.getText();
        } catch (JMSException e) {
            e.printStackTrace();
            text = "";
        }
        System.out.println("Received: " + text);
    }
}
