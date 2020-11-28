package dev.leduclinh.cdbusiness.domain.requests.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOrderItem {
    private Long id;
    private String code;
    private String status;
}
