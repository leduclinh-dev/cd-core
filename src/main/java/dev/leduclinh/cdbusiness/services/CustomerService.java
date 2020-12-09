package dev.leduclinh.cdbusiness.services;

import dev.leduclinh.cdbusiness.domain.dtos.CustomerDTO;
import dev.leduclinh.cdbusiness.domain.requests.employee.CustomerRequest;
import dev.leduclinh.cdbusiness.domain.responses.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerRequest request);
    List<CustomerDTO> getListCustomer();
    CustomerDTO getCustomer(Long id);
    CustomerResponse getCustomerByCode(String code);
    String deleteCustomer(Long id);
}
