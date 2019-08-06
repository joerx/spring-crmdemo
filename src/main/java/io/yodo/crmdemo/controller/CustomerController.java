package io.yodo.crmdemo.controller;

import io.yodo.crmdemo.dao.CustomerDAO;
import io.yodo.crmdemo.entity.Customer;
import io.yodo.crmdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Customer> customers = customerService.getCustomers();

        model.addAttribute("customers", customers);

        return "customer-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newCustomer(Model model) {
        Customer customer = new Customer();

        model.addAttribute("customer", customer);
        model.addAttribute("title", "New Customer");

        return "customer-form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCustomer(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult binding,
            Model model,
            RedirectAttributes ra
    ) {
        if (binding.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("title", "New Customer");
            return "customer-form";
        }

        customerService.createCustomer(customer);
        ra.addFlashAttribute("flashMsg", "Customer saved (id="+customer.getId()+")");

        return "redirect:/customer/list";
    }
}
