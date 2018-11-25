package ru.innopolis.stc12.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc12.hibernate.dao.entities.MobilePhone;

import java.util.List;

@Repository
public class MobilePhoneDaoImpl implements MobilePhoneDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public MobilePhone getPhoneById(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MobilePhone phone = (MobilePhone) session.get(MobilePhone.class, id);
        session.close();
        return phone;
    }

    @Override
    public List<MobilePhone> getPhonesList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MobilePhone.class);
        List<MobilePhone> phones = criteria.list();
        session.close();
        return phones;
    }

    @Override
    public void addPhone(MobilePhone phone) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(phone);
        phone.setCost(20000);
        session.getTransaction().commit();
        session.close();

    }
}
