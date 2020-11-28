package dev.leduclinh.cdbusiness.domain.requests.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrderRequest {
    private Long customerId;
    private Long productId;
    private Long orderId;
    private Long orderItemId;
    private Integer debt;

}
