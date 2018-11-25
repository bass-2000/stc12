package ru.innopolis.stc12.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class ConsumerImpl {
    private final static String TOPIC = "stc12-topic";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";

    public static void main(String[] args) {
        try {
            runConsumer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Consumer<Long, String> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "Stc12Consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        final Consumer<Long, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(TOPIC));
        return consumer;
    }

    private static void runConsumer() throws Exception {
        final Consumer<Long, String> consumer = createConsumer();
        final int giveUp = 100;
        int noRecordsCount = 0;
        while (noRecordsCount <= giveUp) {
            final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
            if (consumerRecords.count() == 0) {
                noRecordsCount++;
            }
            consumerRecords.forEach(record -> System.out.printf("Consumer record: (%d, %s, %d, %d)\n",
                    record.key(), record.value(), record.partition(), record.offset()));
            consumer.commitAsync();
        }
        consumer.close();
        System.out.println("ALL DONE!");
    }
}
