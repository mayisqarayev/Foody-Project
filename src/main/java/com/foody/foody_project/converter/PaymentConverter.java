package com.foody.foody_project.converter;

import com.foody.foody_project.dto.request.AddPaymentRequestDto;
import com.foody.foody_project.dto.response.PaymentResponseDto;
import com.foody.foody_project.model.Payment;
import com.foody.foody_project.service.AddressService;
import com.foody.foody_project.service.CartItemService;
import com.foody.foody_project.service.CartService;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter {

    private final CartItemService cartItemService;
    private final CartService cartService;
    private final AddressService addressService;


    public PaymentConverter(CartItemService cartItemService, CartService cartService, AddressService addressService) {
        this.cartItemService = cartItemService;
        this.cartService = cartService;
        this.addressService = addressService;
    }


    public PaymentResponseDto toPaymentResponseDtoFromEntity(Payment entity) {
        String maskedNumber = "********";
        maskedNumber += entity.getCardNumber().substring(7);
        String maskedCvvCode = "***";

        return new PaymentResponseDto(
                entity.getPaymentMethod().name(),
                entity.getCardName(),
                maskedNumber,
                maskedCvvCode,
                entity.getTotalPay(),
                cartService.getCartItems(entity.getFkCartId()),
                addressService.getAddressById(entity.getFkAddressId())
        );
    }

    public Payment toEntityFromAddPaymentRequestDto(AddPaymentRequestDto requestDto) {
        Payment entity = new Payment();
        entity.setPaymentMethod(requestDto.getPaymentMethod());
        entity.setCardName(requestDto.getCard().getCardName());
        entity.setCardNumber(requestDto.getCard().getCardNumber());
        entity.setCardCvvCode(requestDto.getCard().getCardCvvCode());
        entity.setCardExpireDate(requestDto.getCard().getCardExpireDate());
        entity.setTotalPay(cartItemService.calculateTotalPrice(requestDto.getCartId()));
        entity.setFkCartId(requestDto.getCartId());
        entity.setFkAddressId(requestDto.getAddressId());

        return entity;
    }

}
