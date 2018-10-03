package ru.innopolis.stc12.io;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.      Реализовать следующие методы:
 * <p>
 * a.      boolean save (Employee), дописывающий сотрудника в конец файла
 * b.      boolean delete (Employee), удаляющий сотрудника из файла
 * c.      Employee getByName (тип name), возвращающий сотрудника по полному совпадению имени
 * d.      List<Employee> getByJob(тип job), возвращающий список сотрудников по должности
 * e.      boolean saveOrUpdate (Employee), выполняющий обновление, либо сохранение сотрудника в зависимости от того, есть ли он уже в файле
 * f.       boolean changeAllWork (какую должноcть, на какую должность), выполняющий замену заданной должности на заданную для всех сотрудников
 * g.      Используем сериализацию/десериализацию «Из коробки»
 * 2.      Доп. Задание (+10%) в конец файла дописывать сумму зарплат всех сотрудников (с помощью Externalizable)
 * <p>
 * 3.      Доп. Задание (+10%) сделать все на кастомной сериализции/десериализации (BufferedReader/BufferedWriter)
 */

public class EmployeeData {
    private static String fileName = "C:\\TEMP\\MyTestData.txt";
    private static Logger logger = Logger.getLogger(EmployeeData.class);
    /**
     * Вспомогательный мето, сохраняющий List элементов в fileName файл
     *
     * @param list лист элементов Employee, записываемый в файл
     * @return true, если запись успешна. False если был эксепшен
     */
    private static boolean saveListToFile(List<Employee> list) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName, true))) {
            objectOutputStream.writeObject(list);
            return true;
        } catch (IOException e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    /**
     * Метод, возвращающий List элементов Employee из файла
     *
     * @return возвращает лист элементов
     */
    public static ArrayList<Employee> readListFromFile() {
        ArrayList<Employee> list = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            list = (ArrayList<Employee>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            logger.error(e.getMessage());
        }
        return list;
    }

    /**
     * метод, дописывающий сотрудника в конец файла
     *
     * @param employee дописываемый сотрудник
     * @return true, если запись успешна, false если был эксепшен
     */
    public static boolean save(Employee employee) {
        ArrayList<Employee> list = readListFromFile();
        list.add(employee);
        clearFile();
        return saveListToFile(list);
    }

    /**
     * метод, удаляющий сотрудника из файла
     *
     * @param employee удаляемый сотрудник
     * @return true, если успешное удаление, false если был эксепшен
     */
    public static boolean delete(Employee employee) {
        ArrayList<Employee> list = readListFromFile();
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(employee.getName())
                    && (list.get(i).getAge() == employee.getAge())
                    && (list.get(i).getJob().equals(employee.getJob()))
                    && (list.get(i).getSalary() == employee.getSalary())
                    ) {
                list.remove(list.get(i));
                list.remove(employee);
                result = true;
            }
        }

        clearFile();
        for (Employee empl : list) {
            save(empl);
        }
        return result;
    }

    /**
     * метод, возвращающий сотрудника по полному совпадению имени
     *
     * @param name имя сотрудника
     * @return сотрудника из файла
     */
    public static Employee getByName(String name) {
        ArrayList<Employee> list = readListFromFile();
        Employee resultEmployee = null;
        for (Employee empl : list) if (empl.getName().equals(name)) resultEmployee = empl;
        return resultEmployee;
    }

    /**
     * грязный хак как очистить файл от содержимого. Используется для добавления элементов в файл.
     */
    public static void clearFile() {
        try {
            new FileOutputStream(fileName).close();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * метод, возвращающий список сотрудников по должности
     *
     * @param job искомая должность
     * @return возвращает список сотрудников с искомой должностью
     */
    public static List<Employee> getByJob(Job job) {
        ArrayList<Employee> list = readListFromFile();
        List<Employee> resultList = new ArrayList<>();
        for (Employee empl : list) if (empl.getJob().equals(job)) resultList.add(empl);
        return resultList;
    }

    /**
     * метод, выполняющий обновление, либо сохранение сотрудника в зависимости от того, есть ли он уже в файле
     *
     * @param employee искомый сотрудник
     * @return возвращает True, если произошло обновление или сохранение, False если был Эксепшен
     */
    public static boolean saveOrUpdate(Employee employee) {
        ArrayList<Employee> list = readListFromFile();
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getName().equals(employee.getName()) && list.get(i).getAge() == employee.getAge())) {
                list.get(i).setSalary(employee.getSalary());
                list.get(i).setJob(employee.getJob());
                result = true;
            }
        }
        if (!result) list.add(employee);
        clearFile();
        result = saveListToFile(list);
        return result;
    }

    /**
     * Метод, выполняющий замену заданной должности на заданную для всех сотрудников
     *
     * @param pastJob   - заменяемая работа (какую)
     * @param futureJob - замещающая работа (на какую)
     * @return true, если успешно, false если был эксепшен
     */
    public static boolean changeAllWork(Job pastJob, Job futureJob) {
        ArrayList<Employee> list = readListFromFile();
        boolean result = false;
        for (Employee employee : list) {
            if (employee.getJob().equals(pastJob)) {
                employee.setJob(futureJob);
                result = true;
            }
        }
        clearFile();
        result = saveListToFile(list);
        return result;
    }

    /**
     * Метод вывода в консоль содержимого файла
     */
    public static void printFile() {
        ArrayList<Employee> list = EmployeeData.readListFromFile();
        for (Employee e : list) logger.info(e);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
