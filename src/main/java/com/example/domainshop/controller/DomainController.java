package com.example.domainshop.controller;

import com.example.domainshop.dto.FilterAvailableDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomainController {

    @GetMapping("/domains/available")
    public Object check(FilterAvailableDto filterAvailableDto) {
        // TODO: Implementation starting point
        return null;
    }
}
