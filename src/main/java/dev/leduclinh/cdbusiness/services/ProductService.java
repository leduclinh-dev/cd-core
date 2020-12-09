package dev.leduclinh.cdbusiness.services;

import dev.leduclinh.cdbusiness.domain.dtos.ProductDTO;
import dev.leduclinh.cdbusiness.domain.dtos.ProductTitleDTO;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;

import java.util.List;

public interface ProductService {
        ProductTitleDTO createProductTitle(CreateProductRequest request);
        String createProduct();
        List<ProductTitleDTO> getListProduct();
        void deleteProduct(Long id);
}
