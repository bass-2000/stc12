package ru.innopolis.stc12.servlets.pojo;

public class Student {
    private int id;
    private String name;
    private String familyName;
    private int age;
    private String contact;
    private int city;

    public Student(int id, String name, String familyName, int age, String contact, int city) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.contact = contact;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", contact='" + contact + '\'' +
                ", city=" + city +
                '}';
    }
}