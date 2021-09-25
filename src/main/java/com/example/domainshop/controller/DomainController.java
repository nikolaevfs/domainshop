package com.example.domainshop.controller;

import com.example.domainshop.dto.FilterAvailableDto;
import com.example.domainshop.model.Tld;
import com.example.domainshop.service.DomainService;
import com.example.domainshop.service.TldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DomainController {

    private DomainService domainService;
    private TldService tldService;

    @Autowired
    public DomainController(DomainService domainService, TldService tldService) {
        this.domainService = domainService;
        this.tldService = tldService;
    }


    @GetMapping("/domains/available")
    public Object check(FilterAvailableDto filterAvailableDto) {
        // TODO: Implementation starting point

        List<Map<Object ,Object>> response = new ArrayList<>();
        String domain=new String();

        for(Tld tld : tldService.getAllTlds()){
            Map<Object ,Object> record = new HashMap<>();
            domain=filterAvailableDto.getName() + "." + tld.getName();

            System.out.println(domain);
            record.put("domain", domain);
            record.put("tld", tld.getName());
            record.put("available", domainService.domainISFree(domain));
            record.put("price", tld.getPrice());
            response.add(record);
        }

        System.out.println(response);

        return response;
    }
}
