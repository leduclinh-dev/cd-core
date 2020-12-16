package dev.leduclinh.cdbusiness.services.impls;

import dev.leduclinh.cdbusiness.domain.dtos.ProductDTO;
import dev.leduclinh.cdbusiness.domain.dtos.ProductTitleDTO;
import dev.leduclinh.cdbusiness.domain.entities.*;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductRequest;
import dev.leduclinh.cdbusiness.domain.requests.admin.CreateProductTitleRequest;
import dev.leduclinh.cdbusiness.repositories.BookingItemRepository;
import dev.leduclinh.cdbusiness.repositories.OrderItemRepository;
import dev.leduclinh.cdbusiness.repositories.ProductRepository;
import dev.leduclinh.cdbusiness.repositories.ProductTitleRepository;
import dev.leduclinh.cdbusiness.services.ProductService;
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

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    BookingItemRepository bookingItemRepository;

    @Override
    public ProductTitleDTO createProductTitle(CreateProductTitleRequest request) {
        ProductTitleDTO productTitleDTO = new ProductTitleDTO();
        ProductTitleEntity productTitleEntity = new ProductTitleEntity();
        if (request != null) {
            productTitleEntity.setName(request.getName());
            productTitleEntity.setCategory(new CategoryEntity(request.getCategoryId()));
            productTitleEntity.setPrice(request.getPrice());
            productTitleEntity.setImage(request.getImage());
            productTitleEntity.setDescription(request.getDescription());
            productTitleEntity.setQuantity(0);
            productTitleRepository.save(productTitleEntity);
            productTitleDTO.BuildProductTitleDTO(request);
        }
        return productTitleDTO;
    }

    @Override
    public ProductDTO createProduct(CreateProductRequest productRequest){
        ProductEntity productEntity = new ProductEntity();
        ProductDTO productDTO = new ProductDTO();
        productEntity.setStatus("ACTIVE");
        productEntity.setProductTitleEntity(new ProductTitleEntity(productRequest.getProductTitleId()));
        List<ProductEntity> productEntities = this.productRepository.findAll();
        if (!CollectionUtils.isEmpty(productEntities)) {
            for(ProductEntity entity: productEntities) {
                if (entity.getCode().equals(productRequest.getCode())) {
                    return null;
                }
            }
        }
        productEntity.setCode(productRequest.getCode());
        this.productRepository.save(productEntity);
        productDTO.ProductDTO(productEntity);
        return productDTO;
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
    public boolean deleteProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        if (productEntity !=null) {
            List<OrderItemEntity> orderItemEntities = orderItemRepository.getOrderItemEntityByProductId(id);
            List<BookingItemEntity> bookingItemEntities = bookingItemRepository.findByProduct(id);
            for (BookingItemEntity bookingItemEntity: bookingItemEntities) {
                if (bookingItemEntity.getStatus().equals("ACTIVE")) {
                    return false;
                }
                bookingItemRepository.delete(bookingItemEntity);
            }
            for(OrderItemEntity orderItemEntity: orderItemEntities) {
                if (orderItemEntity.getStatus().equals("ACTIVE")) {
                    return false;
                }
                orderItemRepository.delete(orderItemEntity);
            }
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProductTitle(Long id) {
        ProductTitleEntity titleEntity = productTitleRepository.findById(id).orElse(null);
        if (titleEntity != null) {
            this.productTitleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
