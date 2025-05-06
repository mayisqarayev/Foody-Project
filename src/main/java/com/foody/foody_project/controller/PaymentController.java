package com.foody.foody_project.controller;


import ch.qos.logback.core.joran.event.SaxEventRecorder;
import com.foody.foody_project.dto.request.AddPaymentRequestDto;
import com.foody.foody_project.dto.response.PaymentResponseDto;
import com.foody.foody_project.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public void addPayment(@RequestBody AddPaymentRequestDto requestDto) {
        service.addPayment(requestDto);
    }

    @GetMapping
    public List<PaymentResponseDto> getPayments() {
        return service.getPayments();
    }
}
