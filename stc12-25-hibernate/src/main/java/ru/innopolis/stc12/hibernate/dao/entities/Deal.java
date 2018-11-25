package ru.innopolis.stc12.hibernate.dao.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Deal {
    private Long id;
    private String buyer;
    private List<MobilePhone> mobilePhones = new ArrayList<>();

    public Deal() {
    }

    public Deal(String buyer) {
        this.buyer = buyer;
    }

    @Id
    @SequenceGenerator(name = "dealSeq", sequenceName = "DEAL_SEQUENCE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "deals_mobiles",
            joinColumns = @JoinColumn(name = "deal_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id"))
    public List<MobilePhone> getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(List<MobilePhone> mobilePhones) {
        this.mobilePhones = mobilePhones;
    }
}
