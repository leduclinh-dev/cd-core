package dev.leduclinh.cdbusiness.services;

import dev.leduclinh.cdbusiness.domain.dtos.ProductDTO;
import dev.leduclinh.cdbusiness.domain.dtos.ProductTitleDTO;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;
import dev.leduclinh.cdbusiness.domain.requests.admin.ProductRequest;

import java.util.List;

public interface ProductService {
        ProductTitleDTO createProduct(CreateProductRequest request);
        List<ProductTitleDTO> getListProduct();
        void deleteProduct(Long id);
}
