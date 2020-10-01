package dev.leduclinh.cdbusiness.controllers.employee;

import dev.leduclinh.cdbusiness.domain.requests.employee.CustomerRequest;
import dev.leduclinh.cdbusiness.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Controller
@RequestMapping("/employee/customer")
public class CustomerController {
    @Autowired
    CustomerService service;

    @PostMapping("/createCustomer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest request) {
        return new ResponseEntity<>(service.createCustomer(request), HttpStatus.OK);
    }
    @GetMapping("/getListCustomer")
    public ResponseEntity<?> getListCustomer() {
        return new ResponseEntity<>(service.getListCustomer(), HttpStatus.OK);
    }
}
