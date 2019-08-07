package io.yodo.crmdemo.controller;

import io.yodo.crmdemo.entity.Customer;
import io.yodo.crmdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final CustomerService customerService;

    @Autowired
    public SearchController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String getSearchResults(@RequestParam("q") String query, Model model) {
        List<Customer> customers = customerService.findCustomers(query);

        model.addAttribute("searchQuery", query);
        model.addAttribute("customers", customers);

        return "search-results";
    }
}
