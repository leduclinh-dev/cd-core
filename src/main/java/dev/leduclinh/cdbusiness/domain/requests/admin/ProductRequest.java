package dev.leduclinh.cdbusiness.domain.requests.admin;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String status;
    private String code;
    private String name;
}
