package dev.leduclinh.cdbusiness.domain.dtos;

import dev.leduclinh.cdbusiness.domain.entities.ProductEntity;
import dev.leduclinh.cdbusiness.domain.entities.ProductTitleEntity;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductTitleDTO {

    private Long id;

    private String name;

    private Integer price;

    private String image;

    private CategoryDTO category;

    private String description;

    private Integer quantity;

    private List<ProductDTO> products;

    public void BuildProductTitleDTO(CreateProductRequest productRequest) {
        this.id = productRequest.getId();
        this.name = productRequest.getName();
        this.price = productRequest.getPrice();
        this.image = productRequest.getImage();
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.CategoryDTO(productRequest.getCategoryId());
        this.category = categoryDTO;
        this.description = productRequest.getDescription();
        this.quantity = productRequest.getQuantity();
        ProductDTO productDTO = new ProductDTO();
        productDTO.ProductDTO(productRequest.getProduct());
        List<ProductDTO> productDTOS = new ArrayList<>();
        productDTOS.add(productDTO);
        this.products = productDTOS;
    }

    public void BuildProductTitleDTOS(ProductTitleEntity productTitleEntity, List<ProductEntity> productEntityList) {
        if (productTitleEntity != null) {
            this.id = productTitleEntity.getId();
            this.name = productTitleEntity.getName();
            this.price = productTitleEntity.getPrice();
            this.image = productTitleEntity.getImage();
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.buildResponse(productTitleEntity.getCategory());
            this.category = categoryDTO;
            this.description = productTitleEntity.getDescription();
            this.quantity = productTitleEntity.getQuantity();
            List<ProductDTO> productDTOS = new ArrayList<>();
            if (!CollectionUtils.isEmpty(productEntityList)) {
                for (ProductEntity product : productEntityList) {
                    if (productTitleEntity.getId().equals(product.getProductTitleEntity().getId()) && product.getStatus().equals("ACTIVE")) {
                        ProductDTO productDTO = new ProductDTO();
                        productDTO.ProductDTO(product);
                        productDTOS.add(productDTO);
                    }
                }
            }
            this.products= productDTOS;
        }

    }


}
