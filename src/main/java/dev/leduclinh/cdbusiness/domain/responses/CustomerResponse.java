package dev.leduclinh.cdbusiness.domain.responses;

import dev.leduclinh.cdbusiness.domain.dtos.CustomerDTO;
import dev.leduclinh.cdbusiness.domain.dtos.OrderDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerResponse {
    private CustomerDTO customer;
    private List<OrderDTO> orders;
}
