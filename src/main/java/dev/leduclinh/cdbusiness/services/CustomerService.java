package dev.leduclinh.cdbusiness.services;

import dev.leduclinh.cdbusiness.domain.dtos.CustomerDTO;
import dev.leduclinh.cdbusiness.domain.requests.employee.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerRequest request);
    List<CustomerDTO> getListCustomer();
}
