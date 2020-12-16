package dev.leduclinh.cdbusiness.domain.dtos;

import dev.leduclinh.cdbusiness.domain.entities.ProductEntity;
import dev.leduclinh.cdbusiness.domain.requests.admin.ProductRequest;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String code;
    private String status;

    public ProductDTO() {
    }

    public void ProductDTO(ProductRequest request) {
        if (request != null) {
            this.status = request.getStatus();
            this.code = request.getCode();
        }
    }

    public void ProductDTO(ProductEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.code = entity.getCode();
            this.status = entity.getStatus();
        }
    }


}
