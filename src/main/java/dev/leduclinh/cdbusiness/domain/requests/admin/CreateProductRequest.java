package dev.leduclinh.cdbusiness.domain.requests.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private Long productTitleId;
    private String code;
}
