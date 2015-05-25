package com.ronx.hr.dao;

import com.ronx.hr.model.Employee;

import java.util.List;

public interface HumanResourcesDAO {
    void create(Employee employee);
    Employee getEntityById(Long id);
    void update(Employee employee);
    void delete(Long id);
    List<Employee> getAll();
}
