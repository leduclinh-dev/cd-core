package dev.leduclinh.cdbusiness.services.impls;

import dev.leduclinh.cdbusiness.domain.dtos.CustomerDTO;
import dev.leduclinh.cdbusiness.domain.dtos.OrderDTO;
import dev.leduclinh.cdbusiness.domain.entities.CustomerEntity;
import dev.leduclinh.cdbusiness.domain.entities.OrderEntity;
import dev.leduclinh.cdbusiness.domain.entities.OrderItemEntity;
import dev.leduclinh.cdbusiness.domain.requests.employee.CustomerRequest;
import dev.leduclinh.cdbusiness.domain.responses.CustomerResponse;
import dev.leduclinh.cdbusiness.repositories.CustomerRepository;
import dev.leduclinh.cdbusiness.repositories.OrderItemRepository;
import dev.leduclinh.cdbusiness.repositories.OrderRepository;
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

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

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

    @Override
    public CustomerDTO getCustomer(Long id) {
        CustomerEntity entity = repository.findById(id).orElse(null);
        CustomerDTO customerDTO = new CustomerDTO();
        if (entity != null) {
            customerDTO.buildListResponse(entity);
        }
        return customerDTO;
    }

    @Override
    public CustomerResponse getCustomerByCode(String code) {
        CustomerResponse response = new CustomerResponse();
        CustomerEntity entity = repository.findByCode(code);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.buildListResponse(entity);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        if (entity != null) {
            List<OrderEntity> orderEntities = orderRepository.getOrderEntityByCustomerId(entity.getId());
            List<OrderItemEntity> orderItemEntities = new ArrayList<>();
            for (OrderEntity orderEntity: orderEntities) {
                OrderDTO orderDTO = new OrderDTO();
                orderItemEntities = orderItemRepository.getOrderItemEntityByOrderId(orderEntity.getId());
                orderDTO.buildOrder(orderEntity, orderItemEntities);
                orderDTOS.add(orderDTO);
            }
        }
        response.setOrders(orderDTOS);
        response.setCustomer(customerDTO);
        return response;
    }

    @Override
    public String deleteCustomer(Long id) {
        if (id != null) {
            this.repository.deleteById(id);
            return "SUCCESS";
        }
        return "FAIL";
    }
}
