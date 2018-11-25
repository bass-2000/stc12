import com.mongodb.BasicDBObject;

import java.util.Date;

public class User extends BasicDBObject {
    private static final long serialVersionUID = 1231231241243124124L;
    private String id;
    private String name;
    private int age;
    private Date date;
    private Address address;

    public User(String name, int age, Date date, Address address) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}