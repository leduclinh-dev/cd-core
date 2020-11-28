package dev.leduclinh.cdbusiness.services.impls;

import dev.leduclinh.cdbusiness.domain.dtos.ProductDTO;
import dev.leduclinh.cdbusiness.domain.dtos.ProductTitleDTO;
import dev.leduclinh.cdbusiness.domain.entities.CategoryEntity;
import dev.leduclinh.cdbusiness.domain.entities.ProductEntity;
import dev.leduclinh.cdbusiness.domain.entities.ProductTitleEntity;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;
import dev.leduclinh.cdbusiness.domain.requests.admin.ProductRequest;
import dev.leduclinh.cdbusiness.repositories.ProductRepository;
import dev.leduclinh.cdbusiness.repositories.ProductTitleRepository;
import dev.leduclinh.cdbusiness.services.ProductService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTitleRepository productTitleRepository;

    @Override
    public ProductTitleDTO createProduct(CreateProductRequest request) {
        ProductTitleDTO productTitleDTO = new ProductTitleDTO();
        ProductTitleEntity productTitleEntity = new ProductTitleEntity();
        ProductEntity productEntity = new ProductEntity();
        if (request != null) {
            productTitleEntity.setName(request.getName());
            productTitleEntity.setCategory(new CategoryEntity(request.getCategoryId()));
            productTitleEntity.setPrice(request.getPrice());
            productTitleEntity.setImage(request.getImage());
            productTitleEntity.setDescription(request.getDescription());
            productTitleEntity.setQuantity(request.getQuantity());
            productTitleRepository.save(productTitleEntity);
            productEntity.setCode(RandomStringUtils.randomAlphabetic(8).toUpperCase());
            productEntity.setStatus(request.getProduct().getStatus());
            productEntity.setProductTitleEntity(new ProductTitleEntity(productTitleEntity.getId()));
            productEntity.setName(productTitleEntity.getName());
            productRepository.save(productEntity);
            productTitleEntity.setQuantity(productRepository.findAll().size());
            productTitleRepository.save(productTitleEntity);
            request.getProduct().setCode(productEntity.getCode());
            productTitleDTO.BuildProductTitleDTO(request);
        }
        return productTitleDTO;
    }

    @Override
    public List<ProductTitleDTO> getListProduct() {
        List<ProductTitleEntity> productTitleEntities = productTitleRepository.findAll();
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductTitleDTO> productTitleDTOS = new ArrayList<>();
        if (!CollectionUtils.isEmpty(productTitleEntities)) {
            for (ProductTitleEntity titleEntity: productTitleEntities) {
                ProductTitleDTO productTitleDTO = new ProductTitleDTO();
                productTitleDTO.BuildProductTitleDTOS(titleEntity, productEntities);
                productTitleDTOS.add(productTitleDTO);
            }
        }
        return productTitleDTOS;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
