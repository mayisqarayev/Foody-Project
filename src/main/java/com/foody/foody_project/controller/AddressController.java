package com.foody.foody_project.controller;

import com.foody.foody_project.service.AddressService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService service;
    public AddressController(AddressService service) {
        this.service = service;
    }
}
