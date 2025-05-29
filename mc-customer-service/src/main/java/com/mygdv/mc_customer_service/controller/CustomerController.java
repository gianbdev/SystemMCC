package com.mygdv.mc_customer_service.controller;

import com.mygdv.mc_customer_service.dto.CustomerDTO;
import com.mygdv.mc_customer_service.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;

    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return this.iCustomerService.getAll();
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        return this.iCustomerService.add(customerDTO);
    }

    @GetMapping("cu/{cu}")
    public CustomerDTO getCustomerById(@PathVariable String cu) {
        return iCustomerService.getByCu(cu);
    }

}