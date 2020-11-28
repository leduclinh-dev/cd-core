package dev.leduclinh.cdbusiness.controllers.employee;

import dev.leduclinh.cdbusiness.domain.requests.employee.CreateOrderRequest;
import dev.leduclinh.cdbusiness.domain.requests.employee.UpdateOrderRequest;
import dev.leduclinh.cdbusiness.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Controller
@RequestMapping("/employee/order")
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping("/createOrder")
    public ResponseEntity<?> CreateOrder(@RequestBody CreateOrderRequest orderRequest) {
        return new ResponseEntity<>(orderService.createOrder(orderRequest), HttpStatus.OK);
    }

    @PostMapping("/updateOrder")
    public ResponseEntity<?> UpdateOrder(@RequestBody UpdateOrderRequest request) {
        return new ResponseEntity<>(orderService.updateOrder(request), HttpStatus.OK);
    }
}
