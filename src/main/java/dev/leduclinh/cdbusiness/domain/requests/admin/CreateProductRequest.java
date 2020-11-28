package dev.leduclinh.cdbusiness.domain.requests.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private Long id;

    private String name;

    private Integer price;

    private String image;

    private Long categoryId;

    private String description;

    private Integer quantity;

    private ProductRequest product;

}
