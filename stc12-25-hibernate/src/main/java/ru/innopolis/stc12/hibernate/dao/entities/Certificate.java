package ru.innopolis.stc12.hibernate.dao.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Certificate {
    private String id;
    private String number;
    private MobilePhone phone;

    public Certificate() {
    }

    public Certificate(String number, MobilePhone phone) {
        this.number = number;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @OneToOne(optional = false, mappedBy = "certificate")
    public MobilePhone getPhone() {
        return phone;
    }

    public void setPhone(MobilePhone phone) {
        this.phone = phone;
    }
}