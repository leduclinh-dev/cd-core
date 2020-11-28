package dev.leduclinh.cdbusiness.domain.requests.employee;

import dev.leduclinh.cdbusiness.domain.entities.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class CreateOrderRequest {
    private Long customer;
    private String status;
    private Integer total;
    private String employee;
    private Timestamp dateCurrent;
    private List<OrderItemRequest> orderItems;

}
