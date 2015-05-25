package com.ronx.hr.service.impl;


import com.ronx.hr.dao.HumanResourcesDAO;
import com.ronx.hr.model.Employee;
import com.ronx.hr.service.HumanResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumanResourcesServiceImpl implements HumanResourcesService {

    @Autowired
    private HumanResourcesDAO employeeDAO;

    public void hire(Employee employee) {
        employeeDAO.create(employee);
    }

    public void fire(Long id) {
        employeeDAO.delete(id);
    }

    public Employee search(Long id) {
        return employeeDAO.getEntityById(id);
    }

    public void updateProfile(Employee employee) {
        employeeDAO.update(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }
}
