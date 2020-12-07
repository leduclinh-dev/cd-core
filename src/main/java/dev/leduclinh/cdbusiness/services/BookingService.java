package dev.leduclinh.cdbusiness.services;

import dev.leduclinh.cdbusiness.domain.dtos.BookingDTO;
import dev.leduclinh.cdbusiness.domain.requests.employee.CreateBookingRequest;
import dev.leduclinh.cdbusiness.domain.responses.BookingResponse;

public interface BookingService {
    BookingDTO createBooking(CreateBookingRequest request);
    BookingResponse getListBooking(Long customerID);
}
