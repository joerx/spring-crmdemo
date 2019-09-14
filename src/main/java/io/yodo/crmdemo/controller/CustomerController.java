package io.yodo.crmdemo.controller;

import io.yodo.crmdemo.entity.Customer;
import io.yodo.crmdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static io.yodo.crmdemo.helper.FlashHelper.setFlashInfo;
import static io.yodo.crmdemo.helper.FlashHelper.setFlashErr;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    private static final String REDIRECT_CUSTOMER_LIST = "redirect:/customer/list";

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.findAllCustomers();

        model.addAttribute("customers", customers);

        return "customer-list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newCustomer(Model model) {
        Customer customer = new Customer();
        return prepareViewForCreate(model, customer);
    }

    @RequestMapping(value = "/edit/{customerId}", method = RequestMethod.GET)
    public String editCustomer(Model model, @PathVariable int customerId, RedirectAttributes ra) {
        Customer customer = customerService.findCustomer(customerId);

        if (customer == null) {
            setFlashErr(ra, "Customer with id "+customerId+" not found");
            return REDIRECT_CUSTOMER_LIST;
        }

        return prepareViewForUpdate(model, customer);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCustomer(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult binding,
            Model model,
            RedirectAttributes ra
    ) {
        if (binding.hasErrors()) {
            return prepareViewForCreate(model, customer);
        }

        customerService.createCustomer(customer);
        setFlashInfo(ra, "Customer saved (id="+customer.getId()+")");

        return REDIRECT_CUSTOMER_LIST;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCustomer(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult binding,
            Model model,
            RedirectAttributes ra
    ) {
        if (binding.hasErrors()) {
            return prepareViewForUpdate(model, customer);
        }

        customerService.updateCustomer(customer);
        setFlashInfo(ra, "Customer updated");

        return REDIRECT_CUSTOMER_LIST;
    }

    @RequestMapping(value = "/delete/{customerId}", method = RequestMethod.GET)
    public String deleteCustomers(@PathVariable int customerId, RedirectAttributes ra) {
        Customer customer = customerService.findCustomer(customerId);

        if (customer == null) {
            setFlashErr(ra, "Customer with id "+customerId+" not found");
            return REDIRECT_CUSTOMER_LIST;
        }

        customerService.deleteCustomer(customer);
        setFlashInfo(ra, "Customer " + customer.getFirstName() + " " + customer.getLastName() + " was deleted");

        return "redirect:/customer/list";
    }

    private void populateModel(Model model, Customer customer, String title, String action) {
        model.addAttribute("customer", customer);
        model.addAttribute("title", title);
        model.addAttribute("action", action);
    }

    private String prepareViewForCreate(Model model, Customer customer) {
        populateModel(model, customer, "New Customer", "create");
        return "customer-form";
    }

    private String prepareViewForUpdate(Model model, Customer customer) {
        populateModel(model, customer, "Edit Customer", "update");
        return "customer-form";
    }
}
