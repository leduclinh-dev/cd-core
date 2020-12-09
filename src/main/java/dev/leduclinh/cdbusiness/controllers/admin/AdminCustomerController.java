package dev.leduclinh.cdbusiness.controllers.admin;

import dev.leduclinh.cdbusiness.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/admin/customer")
public class AdminCustomerController {

    @Autowired
    CustomerService service;

    @PostMapping("/deleteCustomer")
    public ResponseEntity<?> deleteCustomer(@RequestParam(name = "id") Long id ) {
        return new ResponseEntity<>(service.deleteCustomer(id), HttpStatus.OK);
    }
}
