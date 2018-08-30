package ru.innopolis.stc12.io;


import java.util.List;

public class Main {
    public static void main(String[] args) {

        EmployeeData.clearFile();
        Employee employee1 = new Employee("Alex", 28, 98000, Job.ENGENEER);
        Employee employee2 = new Employee("Fill", 29, 90800, Job.ADMINISTRATOR);
        Employee employee3 = new Employee("Gosha ", 38, 78000, Job.COORDINATOR);
        Employee employee4 = new Employee("Kira", 68, 6900, Job.CLERK);
        Employee employee5 = new Employee("Kara", 68, 6900, Job.CLERK);

        System.out.println("Запись данных в файл: ");
        EmployeeData.save(employee1);
        EmployeeData.save(employee2);
        EmployeeData.save(employee3);
        EmployeeData.save(employee4);
        EmployeeData.save(employee5);
        System.out.println("Данные записаны.");

        System.out.println("Читаю данные из файла:");
        EmployeeData.printFile();

        System.out.println("Приступаю к удалению:");
        System.out.println("Удаляю " + employee3.getName());
        EmployeeData.delete(employee3);
        System.out.println("Удаляю " + employee1.getName());
        EmployeeData.delete(employee1);

        System.out.println("Добавляю " + employee1.getName());
        EmployeeData.save(employee1);
        System.out.println("Добавляю " + employee1.getName());
        EmployeeData.save(employee1);

        System.out.println("Удаляю " + employee1.getName());
        EmployeeData.delete(employee1);
        EmployeeData.printFile();

        System.out.println("Метод поиска по имени: " + EmployeeData.getByName("Alex"));

        List<Employee> Mylist = EmployeeData.getByJob(Job.CLERK);
        System.out.println("\nМетод поиска по Job: ");
        for (Employee employee : Mylist) System.out.println(employee);

        System.out.println("Метод saveOrUpdate:");
        EmployeeData.saveOrUpdate(new Employee("Kara", 68, 999999, Job.ADMINISTRATOR));
        EmployeeData.saveOrUpdate(new Employee("Karra", 68, 999999, Job.ADMINISTRATOR));
        EmployeeData.printFile();

        System.out.println("Метод changeAllWork:");
        EmployeeData.changeAllWork(Job.ADMINISTRATOR, Job.COORDINATOR);
        EmployeeData.printFile();
    }
}
