package dev.leduclinh.cdbusiness.controllers.employee;

import dev.leduclinh.cdbusiness.domain.requests.employee.CreateBookingRequest;
import dev.leduclinh.cdbusiness.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Controller
@RequestMapping("/employee/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/createBooking")
    public ResponseEntity<?> createBooking(@RequestBody CreateBookingRequest bookingRequest) {
        return new ResponseEntity<>(bookingService.createBooking(bookingRequest), HttpStatus.OK);
    }

    @GetMapping("/getListBooking")
    public ResponseEntity<?> getListBooking(@RequestParam(name = "customerId") Long id) {
        return new ResponseEntity<>(bookingService.getListBooking(id), HttpStatus.OK);
    }

//    @GetMapping("/alertBooking")
//    public ResponseEntity<?> alertBooking() {
//        return new ResponseEntity<>(bookingService.alertBooking, HttpStatus.OK);
//    }
}
