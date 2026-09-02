package ecom.e_store.service;

import ecom.e_store.dto.OrderRequestDto;
import ecom.e_store.dto.OrderResponseDto;
import ecom.e_store.entity.Order;
import java.util.List;

public interface OrderService {
    void createOrder(OrderRequestDto orderRequest);

    List<OrderResponseDto> getCustomerOrders();

    List<OrderResponseDto> getAllPendingOrders();

    Order updateOrderStatus(Long orderId, String orderStatus);
}
