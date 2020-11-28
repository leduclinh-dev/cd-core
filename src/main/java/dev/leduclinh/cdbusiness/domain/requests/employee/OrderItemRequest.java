package dev.leduclinh.cdbusiness.domain.requests.employee;

import dev.leduclinh.cdbusiness.domain.entities.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class OrderItemRequest {
    private Timestamp dateCurrent;
    private String status;
    private Timestamp dateReturn;
    private Integer price;
    private ProductEntity product;

}
