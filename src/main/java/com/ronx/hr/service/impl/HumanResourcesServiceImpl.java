package com.ronx.hr.service.impl;


import com.ronx.hr.dao.HumanResourcesDAO;
import com.ronx.hr.model.Employee;
import com.ronx.hr.model.Position;
import com.ronx.hr.service.HumanResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanResourcesServiceImpl implements HumanResourcesService {

    @Autowired
    private HumanResourcesDAO<Employee> employeeDAO;
    @Autowired
    private HumanResourcesDAO<Position> positionDAO;

    public void hire(Employee employee) {
        employeeDAO.create(employee);
    }

    public void fire(Employee employee) {
        employeeDAO.delete();
    }
}
