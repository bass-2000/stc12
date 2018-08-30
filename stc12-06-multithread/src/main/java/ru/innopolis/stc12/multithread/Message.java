package ru.innopolis.stc12.multithread;

class Message {

    volatile static int count = 0;

    /**Метод выводит сообщение в консоль
     * @param s
     */
    synchronized static void sendMessage(String s) {
        System.out.println(s);
    }
}
