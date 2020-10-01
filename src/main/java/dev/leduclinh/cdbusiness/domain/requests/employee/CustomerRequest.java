package dev.leduclinh.cdbusiness.domain.requests.employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {
    private String fullName;
    private String phone;
    private String address;
    private String email;
}
