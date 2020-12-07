package dev.leduclinh.cdbusiness.services.impls;

import dev.leduclinh.cdbusiness.domain.dtos.BookingDTO;
import dev.leduclinh.cdbusiness.domain.entities.BookingEntity;
import dev.leduclinh.cdbusiness.domain.entities.BookingItemEntity;
import dev.leduclinh.cdbusiness.domain.entities.CustomerEntity;
import dev.leduclinh.cdbusiness.domain.entities.ProductEntity;
import dev.leduclinh.cdbusiness.domain.requests.employee.CreateBookingRequest;
import dev.leduclinh.cdbusiness.domain.responses.BookingResponse;
import dev.leduclinh.cdbusiness.repositories.BookingItemRepository;
import dev.leduclinh.cdbusiness.repositories.BookingRepository;
import dev.leduclinh.cdbusiness.repositories.ProductRepository;
import dev.leduclinh.cdbusiness.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookingImpl implements BookingService {


    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingItemRepository bookingItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public BookingDTO createBooking(CreateBookingRequest request) {
        BookingEntity bookingEntity = new BookingEntity();
        BookingItemEntity bookingItemEntity = new BookingItemEntity();
        ProductEntity productEntity = productRepository.findById(request.getProduct()).orElse(null);
        if (productEntity != null) {
            bookingEntity.setCustomer(new CustomerEntity(request.getCustomer()));
            bookingEntity.setStatus("ACTIVE");
            bookingRepository.save(bookingEntity);
            bookingItemEntity.setBooking(bookingEntity);
            bookingItemEntity.setProduct(new ProductEntity(request.getProduct()));
            bookingItemEntity.setStatus("ACTIVE");
            bookingItemRepository.save(bookingItemEntity);
        }
        return null;
    }

    @Override
    public BookingResponse getListBooking(Long customerID) {
        ProductEntity productEntity = new ProductEntity();
        List<BookingItemEntity> bookingItemEntities = new ArrayList<>();
        List<BookingEntity> bookingEntities =  bookingRepository.findByCustomerId(customerID);
        if (bookingEntities != null) {
            for (BookingEntity booking : bookingEntities) {
                List<BookingItemEntity> bookingItemEntityLis = bookingItemRepository.findByBookingId(booking.getId());
            }
        }
        return null;
    }
}
