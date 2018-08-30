package ru.innopolis.stc12.io;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class EmployeeDataTest {

    @Test
    public void readListFromFile() {
        Employee employee1 = new Employee("Alex", 28, 98000, Job.ENGENEER);
        EmployeeData.clearFile();
        EmployeeData.save(employee1);
        ArrayList<Employee> list = EmployeeData.readListFromFile();
        Assert.assertEquals(employee1,list.get(0));
    }

    @Test
    public void save() {
        EmployeeData.clearFile();
        Employee employee1 = new Employee("Alex", 28, 98000, Job.ENGENEER);
        Employee employee2 = new Employee("Fill", 29, 90800, Job.ADMINISTRATOR);
        Assert.assertTrue(EmployeeData.save(employee1));
        Assert.assertTrue(EmployeeData.save(employee2));
        ArrayList<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        Assert.assertEquals(list, EmployeeData.readListFromFile());

    }
}
