package ru.innopolis.stc12.spring.db.pojo;

public class Student {
    private Integer id;
    private String name;
    private String familyName;
    private Integer age;
    private String group;

    public Student() {
    }

    public Student(Integer id, String name, String familyName, Integer age, String group) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.group = group;
    }

    public Student(String name, String familyName, Integer age, String group) {
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                '}';
    }
}