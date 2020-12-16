package dev.leduclinh.cdbusiness.domain.requests.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductTitleRequest {
    private String name;

    private Integer price;

    private String image;

    private Long categoryId;

    private String description;

}
