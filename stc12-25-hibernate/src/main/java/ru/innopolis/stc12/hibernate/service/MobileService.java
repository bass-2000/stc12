package ru.innopolis.stc12.hibernate.service;

import ru.innopolis.stc12.hibernate.dao.entities.MobilePhone;

import java.util.List;

public interface MobileService {
    MobilePhone getMobilePhone(Long id);

    List<MobilePhone> getMobileList();

    void addPhone(Long id, String model, Integer cost);

}
