package dev.leduclinh.cdbusiness.domain.dtos;

import dev.leduclinh.cdbusiness.domain.entities.OrderEntity;
import dev.leduclinh.cdbusiness.domain.entities.OrderItemEntity;
import dev.leduclinh.cdbusiness.domain.requests.employee.CreateOrderRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private String status;
    private Integer total;
    private String employee;
    private Date date;
    private CustomerDTO customer;
    private List<OrderItemDTO> orderItems;

    public void buildOrder(OrderEntity orderRequest) {
        id = orderRequest.getId();
        status = orderRequest.getStatus();
        total = orderRequest.getTotal();
        employee = orderRequest.getEmployee();
        date = orderRequest.getDate();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.buildResponse(orderRequest.getCustomerId());
        customer = customerDTO;
        List<OrderItemDTO> orderItemDTO = new ArrayList<>();

    }

    public void buildOrder(OrderEntity orderEntity, List<OrderItemEntity> orderItemEntities) {
        id = orderEntity.getId();
        status = orderEntity.getStatus();
        total = orderEntity.getTotal();
        employee = orderEntity.getEmployee();
        date = orderEntity.getDate();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        for (OrderItemEntity itemEntity: orderItemEntities) {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.OrderItemDTO(itemEntity);
            orderItemDTOS.add(orderItemDTO);
        }
        orderItems = orderItemDTOS;
    }
}

