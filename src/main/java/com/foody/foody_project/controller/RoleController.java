package com.foody.foody_project.controller;

import com.foody.foody_project.dto.request.CreateRoleRequestDto;
import com.foody.foody_project.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public void createRole(@RequestBody CreateRoleRequestDto requestDto) {
        service.createRole(requestDto);
    }

    @GetMapping("/{id}")
    public String getRole(@PathVariable String id) {
        return service.getRole(id);
    }
}
