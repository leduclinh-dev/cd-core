package dev.leduclinh.cdbusiness.services.impls;

import dev.leduclinh.cdbusiness.domain.dtos.CustomerDTO;
import dev.leduclinh.cdbusiness.domain.entities.CustomerEntity;
import dev.leduclinh.cdbusiness.domain.requests.employee.CustomerRequest;
import dev.leduclinh.cdbusiness.repositories.CustomerRepository;
import dev.leduclinh.cdbusiness.services.CustomerService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerImpl implements CustomerService {
    @Autowired
    CustomerRepository repository;

    @Override
    public CustomerDTO createCustomer(CustomerRequest request) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setPhone(request.getPhone());
        customerEntity.setAddress(request.getAddress());
        customerEntity.setFullName(request.getFullName());
        customerEntity.setEmail(request.getEmail());
        customerEntity.setCode(RandomStringUtils.randomNumeric(8));
        customerEntity.setDebt(0);
        repository.save(customerEntity);
        CustomerDTO customerRes = new CustomerDTO();
        customerRes.buildResponse(customerEntity);
        return customerRes;
    }

    @Override
    public List<CustomerDTO> getListCustomer() {
        List<CustomerEntity> entities = repository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(entities)) {
            for (CustomerEntity entity: entities) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.buildListResponse(entity);
                customerDTOS.add(customerDTO);
            }
        }

        return customerDTOS;
    }
}
