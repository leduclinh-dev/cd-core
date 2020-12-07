package dev.leduclinh.cdbusiness.domain.entities;

import dev.leduclinh.cdbusiness.domain.requests.admin.ProductRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_title_id", referencedColumnName = "id")
    private ProductTitleEntity productTitleEntity;


    public ProductEntity(ProductEntity productEntity) {
        id = productEntity.getId();
        code = productEntity.getCode();
        status = productEntity.getStatus();
        name = productEntity.getName();
        productTitleEntity = null;
    }

    public ProductEntity() {

    }
    public ProductEntity(Long idReq) {
        if (idReq !=null) {
            id = idReq;
        }
    }

    public void ProductEntity(Long id) {
        if (id != null) {
            this.productTitleEntity = new ProductTitleEntity(id);
        }
    }


}
