package ru.inopolis.stc12.gc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    private static List objects = new ArrayList();
    private static boolean cont = true;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String a = in.readLine(); //искуственная пауза чтобы открыть в visualvm нужный pid для просмотра
        while (cont) {
            System.out.println("Создаем объекты. " + sdf.format(Calendar.getInstance().getTime()));

            for (int i = 0; i < 5; i++) {
                createObjects();
                Thread.sleep(1000);

            }
            System.out.println("Удаляем объекты." + sdf.format(Calendar.getInstance().getTime()));
            for (int i = 0; i < 5; i++) {
                removeObjects();
            }
        }
    }

    private static void createObjects() {
        for (int i = 0; i < 2; i++) {
            objects.add(new byte[1000 * 1000 * 100]);
        }
    }

    private static void removeObjects() {
        int start = objects.size() - 1;
        int end = start - 2;
        for (int i = start; ((i >= 0) && (i > end)); i--) {
            objects.remove(i);
        }
    }
}