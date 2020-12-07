package dev.leduclinh.cdbusiness.domain.dtos;

import dev.leduclinh.cdbusiness.domain.entities.OrderEntity;
import dev.leduclinh.cdbusiness.domain.entities.OrderItemEntity;
import dev.leduclinh.cdbusiness.domain.entities.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderItemDTO {

    private Long id;
    private Date dateCurrent;
    private Date dateReturn;
    private String status;
    private ProductDTO product;
    private Integer price;
    private String name;

    public void OrderItemDTO(OrderItemEntity orderItemEntity) {
        id = orderItemEntity.getId();
        dateCurrent = orderItemEntity.getDate();
        dateReturn = orderItemEntity.getReturnDate();
        price = orderItemEntity.getPrice();
        status = orderItemEntity.getStatus();
        ProductDTO productDTO = new ProductDTO();
        productDTO.ProductDTO(orderItemEntity.getProductId());
        product = productDTO;
    }
    public OrderItemDTO() {

    }


}
