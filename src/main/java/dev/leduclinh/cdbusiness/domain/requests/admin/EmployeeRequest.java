package dev.leduclinh.cdbusiness.domain.requests.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private String fullName;
    private String address;
    private String phone;
    private String username;
    private String email;
}
