package com.ronx.hr.controller;

import com.ronx.hr.service.HumanResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    @Autowired
    private HumanResourcesService hrService;

    @RequestMapping(value = "/")
    public String redirect_main() {
        return "redirect:main";
    }

}