package com.example.domainshop.service;

import com.example.domainshop.dto.ProcessedDomain;
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
    public List<Tld> getAllTlds() {
        return tldRepository.findAllByOrderByPrice();
    }

    public List<Tld> getAllTldsOrdered(ProcessedDomain processedDomain) {

        // if user specified sorting field but forgot to specify order - set default sorting order
        if (processedDomain.getSortingField() != null && processedDomain.getSortingOrder() == null)
            processedDomain.setSortingOrder("asc");

        if (processedDomain.getSortingField() != null)
            switch (processedDomain.getSortingField()) {
                case "price":
                    if (processedDomain.getSortingOrder().equals("asc")) {
                        return tldRepository.findAllByOrderByPriceAsc();
                    }
                    return tldRepository.findAllByOrderByPriceDesc();

                case "tld":
                    if (processedDomain.getSortingOrder().equals("asc")) {
                        return tldRepository.findAllByOrderByNameAsc();
                    }
                    return tldRepository.findAllByOrderByNameDesc();
            }
        return getAllTlds();
    }
}
