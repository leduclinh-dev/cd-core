package dev.leduclinh.cdbusiness.repositories;

import dev.leduclinh.cdbusiness.domain.entities.ProductTitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTitleRepository extends JpaRepository<ProductTitleEntity, Long> {
}
