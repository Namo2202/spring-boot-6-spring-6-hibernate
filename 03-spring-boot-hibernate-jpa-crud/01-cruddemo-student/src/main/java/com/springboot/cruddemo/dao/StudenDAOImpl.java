package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudenDAOImpl implements  StudentDAO{
//    define field for entity manager
    private EntityManager entityManager;

//    inject entity manager using construcor injection

    @Autowired
    public StudenDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //    implement save methode
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
