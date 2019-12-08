package ru.trushkin.spring.example2.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class SpeakerRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Speaker speaker) {
        entityManager.persist(speaker);
    }

    public List<Speaker> findByName(String name) {
        return (List<Speaker>) hibernateTemplate.findByNamedParam("select s from Speaker as s where s.name=:name", "name", name);
    }
}
