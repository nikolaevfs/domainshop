package com.example.domainshop.service;

import com.example.domainshop.model.Domain;
import com.example.domainshop.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainService {
    private final DomainRepository domainRepository;

    @Autowired
    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    public boolean domainISFree(String checkingDomain) {
        List<Domain> busyDomains = domainRepository.findAll();
        for (Domain domain : busyDomains) {
            if(domain.getName().equals(checkingDomain))
                return false;
        }
        return true;
    }
}
