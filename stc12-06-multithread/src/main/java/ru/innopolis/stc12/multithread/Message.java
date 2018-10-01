package ru.innopolis.stc12.multithread;

import org.apache.log4j.Logger;

class Message {

    volatile static int count = 0;

    /**Метод выводит сообщение в консоль
     * @param s
     */
    synchronized static void sendMessage(String s, Logger logger) {
        logger.info(s);
    }
}
