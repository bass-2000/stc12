package ru.innopolis.stc12.multithread;

import org.apache.log4j.Logger;

class Message {

    static volatile int count = 0;

    private Message() {
    }

    /**Метод выводит сообщение в консоль
     * @param s
     */
    static synchronized void sendMessage(String s, Logger logger) {
        logger.info(s);
    }
}
