package com.ronx.hr.dao.impl;

import com.ronx.hr.dao.HumanResourcesDAO;
import com.ronx.hr.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HumanResourcesDAOImpl implements HumanResourcesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void create(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();
    }

    public Employee getEntityById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Employee) session.get(Employee.class, id);
        } finally {
            session.close();
        }
    }

    public void update(Employee employee) {

    }

    public List<Employee> getAll() {
        Session session = sessionFactory.openSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        session.close();
        return employeeList;
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(session.get(Employee.class, id));
        tx.commit();
        session.close();
    }
}
