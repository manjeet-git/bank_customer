package com.bank.customer.controller;

import com.bank.customer.Respository.CutomerRepository;
import com.bank.customer.custom.exception.CustomerNotFoundException;
import com.bank.customer.entity.Customer;
import com.bank.customer.response.entity.CustomerResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/bank-customer")
public class CustomerController {
     @Autowired
    private CutomerRepository repository;

     @PostMapping(path="/store",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> storeCutomerDetails(@Valid @RequestBody Customer customer){
         Customer cust=repository.save(customer);
         return new ResponseEntity<>(cust, HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/get-by-id/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(name = "customerId") Integer id){
        Optional<Customer> custOpt=repository.findById(id);
         Customer cust=null;
         if(custOpt.isPresent())
            cust=custOpt.get();

         if(cust==null){
             throw new CustomerNotFoundException("Customer having id : "+id+" is not avalaible.");
          }
         return new ResponseEntity<Customer>(cust,HttpStatus.FOUND);
    }

    @ApiOperation(value = "Getting cutomer by his gender and specific bank name", response = Customer.class, notes = "Might be available")
    @GetMapping(path = "/get-customer-by-bankname-and-gender/{bankName}/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getCustomerByBankAndGender(@PathVariable(name="bankName") String bank, @PathVariable(name="gender") String gender){
        return  new ResponseEntity<List<Customer>>( repository.findByBankNameAndGender(bank,gender),HttpStatus.FOUND);
    }

}
