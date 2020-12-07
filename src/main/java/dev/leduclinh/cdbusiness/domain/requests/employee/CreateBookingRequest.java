package dev.leduclinh.cdbusiness.domain.requests.employee;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateBookingRequest {
    private Long customer;
    private Long product;
}
