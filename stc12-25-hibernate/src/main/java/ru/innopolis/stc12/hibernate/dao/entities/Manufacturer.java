package ru.innopolis.stc12.hibernate.dao.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    private Long id;
    private String name;
    private String country;
    private List<MobilePhone> phones = new ArrayList<>();

    public Manufacturer() {
    }

    public Manufacturer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    public List<MobilePhone> getPhones() {
        return phones;
    }

    public void setPhones(List<MobilePhone> phones) {
        this.phones = phones;
    }
}
