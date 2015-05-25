package com.ronx.hr.service;

import com.ronx.hr.model.Employee;

import java.util.List;

public interface HumanResourcesService {
    void hire(Employee employee);
    void fire(Long id);
    Employee search(Long id);
    void updateProfile(Employee employee);

    List<Employee> getAllEmployees();
}
