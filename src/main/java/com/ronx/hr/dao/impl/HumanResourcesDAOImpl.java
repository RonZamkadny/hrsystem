package com.ronx.hr.dao.impl;

import com.ronx.hr.dao.HumanResourcesDAO;
import com.ronx.hr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HumanResourcesDAOImpl<T> implements HumanResourcesDAO<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public void getEntityById(T entity, Long id) {
        entityManager.find(entity.getClass(), id);
    }

    public void update() {

    }

    public void delete() {

    }
}
