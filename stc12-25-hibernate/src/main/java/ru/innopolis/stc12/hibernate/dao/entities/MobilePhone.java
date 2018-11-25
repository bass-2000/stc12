package ru.innopolis.stc12.hibernate.dao.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mobile")
public class MobilePhone {
    private Long id;
    private String model;
    private int cost;
    private String recense;
    private Manufacturer manufacturer;
    private Certificate certificate;
    private List<Deal> deals = new ArrayList<>();

    public MobilePhone() {
    }

    public MobilePhone(Long id, String model, int cost, String recense, Manufacturer manufacturer, Certificate certificate) {
        this.id = id;
        this.model = model;
        this.cost = cost;
        this.recense = recense;
        this.manufacturer = manufacturer;
        this.certificate = certificate;
    }

    @Id
    @Column(name = "mobile_id")
    @SequenceGenerator(name = "hibernateSeq", sequenceName = "mobile_squence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRecense() {
        return recense;
    }

    public void setRecense(String recense) {
        this.recense = recense;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "deals_mobiles",
            joinColumns = @JoinColumn(name = "phone_id"),
            inverseJoinColumns = @JoinColumn(name = "deal_id"))
    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                ", recense='" + recense + '\'' +
                '}';
    }
}
