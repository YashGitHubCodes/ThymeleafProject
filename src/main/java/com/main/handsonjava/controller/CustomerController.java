package com.main.handsonjava.controller;

import com.main.handsonjava.dto.CustomerDto;
import com.main.handsonjava.exception.CustomerNotFoundException;
import com.main.handsonjava.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    //Add mapping to get customer list
    @GetMapping("/list")
    public String listCustomers(Model themModel){
        List<CustomerDto> customerDtos = customerService.fetchAllCustomers();
        themModel.addAttribute("customer", customerDtos);
        return "customer/list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model themModel){
        CustomerDto customerDto = new CustomerDto();
        themModel.addAttribute("customer", customerDto);
        return "customer/customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") @Valid CustomerDto customerDto, Model theModel){
        try {
            customerService.createCustomer(customerDto);
            return "redirect:/customer/list";
        } catch (Exception e) {
            theModel.addAttribute("errorMessage", e.getMessage());
            return "customer/customer-form";
        }
    }

    @GetMapping("/showformForUpdate")
    public String showformForUpdate(@RequestParam("customerId") int customerId, Model themModel){
        CustomerDto customerDto = customerService.findById(customerId);

        themModel.addAttribute("customer", customerDto);
        return "customer/customer-update";
    }
@PostMapping("/update")
    public String updateCustomer(@ModelAttribute("customer") @Valid CustomerDto customerDto, Model theModel){
        try {
            customerService.updateCustomer(customerDto);
            return "redirect:/customer/list";
        } catch (Exception e) {
            theModel.addAttribute("errorMessage", e.getMessage());
            return "customer/customer-update";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId){
        try {
            customerService.deleteCustomer(customerId);
            List<CustomerDto> customerDtos = customerService.fetchAllCustomers();
            return "redirect:/customer/list";
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
            return "customer/list-customers";
        }
    }
}
