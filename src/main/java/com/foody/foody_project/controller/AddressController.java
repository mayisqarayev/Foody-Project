package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.AddAddressRequestDto;
import com.foody.foody_project.dto.request.UpdateAddressRequestDto;
import com.foody.foody_project.dto.response.AddressResponseDto;
import com.foody.foody_project.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService service;
    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<AddressResponseDto> getAddressesByUserId(@PathVariable String userId) {
        return service.getAddressesByUserId(userId);
    }

    @PostMapping
    public void addAddress(@RequestBody AddAddressRequestDto requestDto) {
        service.addAddress(requestDto);
    }

    @PutMapping
    public void updateAddress(@RequestBody UpdateAddressRequestDto requestDto) {
        service.updateAddress(requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable String id) {
        service.deleteAddress(id);
    }

}
