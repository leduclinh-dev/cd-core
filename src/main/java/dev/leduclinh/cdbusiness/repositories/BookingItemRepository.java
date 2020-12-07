package dev.leduclinh.cdbusiness.repositories;

import dev.leduclinh.cdbusiness.domain.entities.BookingEntity;
import dev.leduclinh.cdbusiness.domain.entities.BookingItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingItemRepository extends JpaRepository<BookingItemEntity, Long> {
    @Query("SELECT t from BookingItemEntity t where" + " t.booking=:bookingId ")
    List<BookingItemEntity> findByBookingId(@Param("bookingId") Long bookingId);
}
