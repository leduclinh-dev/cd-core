package dev.leduclinh.cdbusiness.repositories;

import dev.leduclinh.cdbusiness.domain.dtos.CustomerDTO;
import dev.leduclinh.cdbusiness.domain.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Query("SELECT t from CustomerEntity t where" + " t.code=:code ")
    CustomerEntity findByCode(@Param("code") String code);


}
