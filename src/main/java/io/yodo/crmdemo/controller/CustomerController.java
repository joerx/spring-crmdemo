package io.yodo.crmdemo.controller;

import io.yodo.crmdemo.dao.CustomerDAO;
import io.yodo.crmdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/list")
    public String list(Model theModel) {
        List<Customer> customers = customerDAO.getCustomers();

        theModel.addAttribute("customers", customers);

        return "list-customers";
    }
}
