package dev.leduclinh.cdbusiness.services;

import dev.leduclinh.cdbusiness.domain.dtos.OrderDTO;
import dev.leduclinh.cdbusiness.domain.requests.employee.CreateOrderRequest;
import dev.leduclinh.cdbusiness.domain.requests.employee.UpdateOrderRequest;

public interface OrderService {
    OrderDTO createOrder(CreateOrderRequest order);
    OrderDTO updateOrder(UpdateOrderRequest request);
}
