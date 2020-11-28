package dev.leduclinh.cdbusiness.services.impls;

import dev.leduclinh.cdbusiness.domain.dtos.OrderDTO;
import dev.leduclinh.cdbusiness.domain.entities.CustomerEntity;
import dev.leduclinh.cdbusiness.domain.entities.OrderEntity;
import dev.leduclinh.cdbusiness.domain.entities.OrderItemEntity;
import dev.leduclinh.cdbusiness.domain.entities.ProductEntity;
import dev.leduclinh.cdbusiness.domain.requests.employee.CreateOrderRequest;
import dev.leduclinh.cdbusiness.domain.requests.employee.OrderItemRequest;
import dev.leduclinh.cdbusiness.domain.requests.employee.UpdateOrderRequest;
import dev.leduclinh.cdbusiness.repositories.CustomerRepository;
import dev.leduclinh.cdbusiness.repositories.OrderItemRepository;
import dev.leduclinh.cdbusiness.repositories.OrderRepository;
import dev.leduclinh.cdbusiness.repositories.ProductRepository;
import dev.leduclinh.cdbusiness.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public OrderDTO createOrder(CreateOrderRequest order) {
        OrderEntity orderEntity = new OrderEntity();
        OrderDTO orderDTO = new OrderDTO();
        CustomerEntity customerEntity = new CustomerEntity();
        if (order !=null) {
            orderEntity.setCustomerId(new CustomerEntity(order.getCustomer()));
            orderEntity.setDate(order.getDateCurrent());
            orderEntity.setStatus(order.getStatus());
            orderEntity.setTotal(order.getTotal());
            orderEntity.setEmployee(order.getEmployee());
            orderRepository.save(orderEntity);
            customerEntity = customerRepository.getOne(order.getCustomer());
            customerEntity.setDebt(customerEntity.getDebt()+order.getTotal());
            customerRepository.save(customerEntity);
            for(OrderItemRequest item : order.getOrderItems()) {
                    OrderItemEntity orderItemEntity = new OrderItemEntity();
                    ProductEntity productEntity = productRepository.getOne(item.getProduct().getId());
                    orderItemEntity.setOrderId(orderEntity);
                    orderItemEntity.setProductId(new ProductEntity(item.getProduct()));
                    productEntity.setStatus("NO");
                    productRepository.save(productEntity);
                    orderItemEntity.setDate(item.getDateCurrent());
                    orderItemEntity.setPrice(item.getPrice());
                    orderItemEntity.setStatus("NO");
                    orderItemEntity.setReturnDate(item.getDateReturn());
                    orderItemRepository.save(orderItemEntity);
            }
        }

        return orderDTO;
    }

    @Override
    public OrderDTO updateOrder(UpdateOrderRequest request) {
        ProductEntity productEntity = productRepository.findById(request.getProductId()).orElse(null);
        CustomerEntity customerEntity = customerRepository.findById(request.getCustomerId()).orElse(null);
        OrderEntity orderEntity = orderRepository.findById(request.getOrderId()).orElse(null);
        OrderItemEntity orderItemEntity = orderItemRepository.findById(request.getOrderItemId()).orElse(null);
        if (productEntity != null && customerEntity != null && orderEntity!=null && orderItemEntity != null) {
            List<OrderItemEntity> orderItemEntities = orderItemRepository.getOrderItemEntityByOrderId(orderEntity.getId());
            orderItemEntity.setStatus("NO");
            orderItemRepository.save(orderItemEntity);

            for (OrderItemEntity itemEntity: orderItemEntities) {
                if (itemEntity.getStatus().equals("NO")) {
                    orderEntity.setStatus("NO");
                }
            }
            productEntity.setStatus("ACTIVE");
            customerEntity.setDebt(customerEntity.getDebt()-orderItemEntity.getPrice());
            productRepository.save(productEntity);
            customerRepository.save(customerEntity);
            orderRepository.save(orderEntity);
        }

        return null;
    }


}
