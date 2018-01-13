package com.it355.projekat.Controllers;

import com.it355.projekat.Models.Customer;
import com.it355.projekat.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/registracija")
    public String registracija(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "addCustomer";
    }

    @RequestMapping(value = "/registracija", method = RequestMethod.POST)
    public String registracijaPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return "addCustomer";
        }
        List<Customer> customerList = customerService.getAllCustomers();

        for (int i = 0; i < customerList.size(); i++) {
            if (customer.getCustomerEmail().equals(customerList.get(i).getCustomerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "addCustomer";
            }

            if (customer.getUsername().equals(customerList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "addCustomer";
            }
        }
        customer.setEnabled(true);
        customerService.addCustomer(customer);
        return "uspesnaRegistracija";
    }

}
