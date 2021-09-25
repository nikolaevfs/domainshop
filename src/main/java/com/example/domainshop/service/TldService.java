package com.example.domainshop.service;

import com.example.domainshop.model.Tld;
import com.example.domainshop.repository.TldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TldService {
    private final TldRepository tldRepository;

    @Autowired
    public TldService(TldRepository tldRepository) {
        this.tldRepository = tldRepository;
    }

    // I have to use "OrderBy" to pass given tests
    public List<Tld> getAllTlds(){
        return tldRepository.findAllByOrderByPrice();
    }
}
