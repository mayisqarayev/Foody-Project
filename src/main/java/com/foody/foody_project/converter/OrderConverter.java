package com.foody.foody_project.converter;

import com.foody.foody_project.dto.request.AddOrderRequestDto;
import com.foody.foody_project.dto.response.OrderResponseDto;
import com.foody.foody_project.dto.response.PaymentResponseDto;
import com.foody.foody_project.dto.response.RestaurantResponseDto;
import com.foody.foody_project.model.OrderEntity;
import com.foody.foody_project.service.PaymentService;
import com.foody.foody_project.service.RestaurantService;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {
    
    private final RestaurantService restaurantService;
    private final PaymentService paymentService;

    public OrderConverter(RestaurantService restaurantService, PaymentService paymentService) {
        this.restaurantService = restaurantService;
        this.paymentService = paymentService;
    }

    public OrderResponseDto toOrderResponseDtoFromEntity(OrderEntity entity) {
        RestaurantResponseDto restaurant = restaurantService.getRestaurantById(entity.getFkRestaurantId());
        PaymentResponseDto payment = paymentService.getPaymentDetails(entity.getFkPaymentId());
        int size = payment.getCart().size();

        return new OrderResponseDto(
                restaurant.getPhoto(),
                restaurant.getRestaurantName(),
                entity.getOrderStatus(),
                payment.getTotalPay().toString(),
                Integer.toString(size),
                payment.getPaymentDate()
        );
    }

    public OrderEntity toEntityFromAddOrderRequestDto(AddOrderRequestDto requestDto) {
        OrderEntity entity = new OrderEntity();
        entity.setFkPaymentId(requestDto.getPaymentId());
        entity.setOrderStatus(true);
        entity.setFkRestaurantId(requestDto.getRestaurantId());
        entity.setFkUserId(requestDto.getUserId());

        return entity;
    }
}
