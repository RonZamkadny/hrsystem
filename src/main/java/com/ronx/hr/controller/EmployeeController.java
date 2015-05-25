package com.ronx.hr.controller;

import com.ronx.hr.model.Employee;
import com.ronx.hr.service.HumanResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public static final String GET_EMP = "/get/{id}";
    public static final String GET_ALL_EMP = "/all";
    public static final String CREATE_EMP = "/hire";
    public static final String DELETE_EMP = "/fire/{id}";
    public static final String UPDATE_EMP = "/updateProfile/{id}";

    @Autowired
    private HumanResourcesService hrService;

    @RequestMapping(value = GET_EMP, method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") int id) {
        logger.info("SEARCH EMPLOYEE ID = " + id);
        return hrService.search(new Long(id));
    }

    @RequestMapping(value = GET_ALL_EMP, method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployees() {
        logger.info("GET ALL EMPLOYEES");
        return hrService.getAllEmployees();
    }

    @RequestMapping(value = CREATE_EMP, method = RequestMethod.POST)
    @ResponseBody
    public void hireEmployee(@RequestBody Employee employee) {
        logger.info("HIRE EMPLOYEE " + employee.toString());
        hrService.hire(employee);
    }

    @RequestMapping(value = DELETE_EMP, method = RequestMethod.GET)
    @ResponseBody
    public void fireEmployee(@PathVariable("id") int id) {
        logger.info("FIRE EMPLOYEE ID = " + id);
        hrService.fire(new Long(id));
    }

    @RequestMapping(value = UPDATE_EMP, method = RequestMethod.POST)
    @ResponseBody
    public void updateEmployeesProfile(@RequestBody Employee employee) {
        logger.info("UPDATE EMPLOYEE ID = " + employee.getId());
        hrService.updateProfile(employee);
    }
}