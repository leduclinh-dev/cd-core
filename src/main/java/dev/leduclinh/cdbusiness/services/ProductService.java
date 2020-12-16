package dev.leduclinh.cdbusiness.services;

import dev.leduclinh.cdbusiness.domain.dtos.ProductDTO;
import dev.leduclinh.cdbusiness.domain.dtos.ProductTitleDTO;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductTitleRequest;

import java.util.List;

public interface ProductService {
        ProductTitleDTO createProductTitle(CreateProductTitleRequest request);
        ProductDTO createProduct(CreateProductRequest productRequest) throws Exception;
        List<ProductTitleDTO> getListProduct();
        boolean deleteProduct(Long id);
        boolean deleteProductTitle(Long id);
}
