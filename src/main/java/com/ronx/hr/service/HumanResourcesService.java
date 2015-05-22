package com.ronx.hr.service;

import com.ronx.hr.model.Employee;

public interface HumanResourcesService {
    void hire(Employee employee);
    void fire(Employee employee);
}
