package dev.leduclinh.cdbusiness.repositories;

import dev.leduclinh.cdbusiness.domain.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    @Query("SELECT t from BookingEntity t where" + " t.customer=:customerId ")
    List<BookingEntity> findByCustomerId(@Param("customerId") Long customerId);

}
