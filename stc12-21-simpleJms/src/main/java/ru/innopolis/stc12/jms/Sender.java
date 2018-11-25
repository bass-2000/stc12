package ru.innopolis.stc12.jms;

import com.google.gson.Gson;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class Sender {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;
    private String queue;

    public Sender(String queue) {
        this.queue = queue;
        factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        try {
            connection = factory.createConnection();
            connection.setClientID("sender");
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(queue);
            producer = session.createProducer(destination);
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(Object object) throws JMSException {
        TextMessage message = session.createTextMessage();
        Gson gson = new Gson();
        message.setText(gson.toJson(object));
        producer.send(message);
    }

    public void close() {
        try {
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
