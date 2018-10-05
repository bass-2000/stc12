package ru.innopolis.stc12.io;


import org.apache.log4j.Logger;

import java.util.List;


public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    private static final String DELETING = "Удаляю ";
    public static void main(String[] args) {

        EmployeeData.clearFile();
        Employee employee1 = new Employee("Alex", 28, 98000, Job.ENGENEER);
        Employee employee2 = new Employee("Fill", 29, 90800, Job.ADMINISTRATOR);
        Employee employee3 = new Employee("Gosha ", 38, 78000, Job.COORDINATOR);
        Employee employee4 = new Employee("Kira", 68, 6900, Job.CLERK);
        Employee employee5 = new Employee("Kara", 68, 6900, Job.CLERK);

        logger.info("Запись данных в файл: ");
        EmployeeData.save(employee1);
        EmployeeData.save(employee2);
        EmployeeData.save(employee3);
        EmployeeData.save(employee4);
        EmployeeData.save(employee5);
        logger.info("Данные записаны.");

        logger.info("Читаю данные из файла:");
        EmployeeData.printFile();

        logger.info("Приступаю к удалению:");
        logger.info(DELETING + employee3.getName());
        EmployeeData.delete(employee3);
        logger.info(DELETING + employee1.getName());
        EmployeeData.delete(employee1);

        logger.info("Добавляю " + employee1.getName());
        EmployeeData.save(employee1);
        logger.info("Добавляю " + employee1.getName());
        EmployeeData.save(employee1);

        logger.info(DELETING + employee1.getName());
        EmployeeData.delete(employee1);
        EmployeeData.printFile();

        logger.info("Метод поиска по имени: " + EmployeeData.getByName("Alex"));

        List<Employee> myList = EmployeeData.getByJob(Job.CLERK);
        logger.info("\nМетод поиска по Job: ");
        for (Employee employee : myList) logger.info(employee);

        logger.info("Метод saveOrUpdate:");
        EmployeeData.saveOrUpdate(new Employee("Kara", 68, 999999, Job.ADMINISTRATOR));
        EmployeeData.saveOrUpdate(new Employee("Karra", 68, 999999, Job.ADMINISTRATOR));
        EmployeeData.printFile();

        logger.info("Метод changeAllWork:");
        EmployeeData.changeAllWork(Job.ADMINISTRATOR, Job.COORDINATOR);
        EmployeeData.printFile();
    }
}
