package com.example.domainshop.service;

import com.example.domainshop.repository.TldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TldService {
    private final TldRepository tldRepository;

    @Autowired
    public TldService(TldRepository tldRepository) {
        this.tldRepository = tldRepository;
    }
}
