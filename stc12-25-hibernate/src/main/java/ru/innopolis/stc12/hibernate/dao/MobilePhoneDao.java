package ru.innopolis.stc12.hibernate.dao;

import ru.innopolis.stc12.hibernate.dao.entities.MobilePhone;

import java.util.List;

public interface MobilePhoneDao {
    MobilePhone getPhoneById(Long id);

    List<MobilePhone> getPhonesList();

    void addPhone(MobilePhone phone);
}
