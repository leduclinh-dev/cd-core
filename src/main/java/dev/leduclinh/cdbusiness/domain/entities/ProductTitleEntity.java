package dev.leduclinh.cdbusiness.domain.entities;

import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "product_title")
@Getter
@Setter
public class ProductTitleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;

    private String description;

    private Integer quantity;

    public ProductTitleEntity(Long id) {
        this.id = id;
    }

    public ProductTitleEntity() {

    }



}
