package com.example.domainshop.service;

import com.example.domainshop.dto.ProcessedDomain;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FilterResponseService {

    public List<Map<String, Object>> filterList(List<Map<String, Object>> notFilteredList, ProcessedDomain processedDomain) {

        List<Map<String, Object>> filteredList = new ArrayList<>();

        switch (processedDomain.getFilterField()) {
            case "price":
                if (processedDomain.getHighestPrice() < processedDomain.getLowestPrice()) {  //case when user didn't specify highest price
                    for (Map<String, Object> record : notFilteredList) {
                        if (Double.parseDouble(record.get("price").toString()) >= processedDomain.getLowestPrice())
                            filteredList.add(record);
                    }
                }

                for (Map<String, Object> record : notFilteredList) {
                    if (Double.parseDouble(record.get("price").toString()) >= processedDomain.getLowestPrice() && Double.parseDouble(record.get("price").toString()) <= processedDomain.getHighestPrice())
                        filteredList.add(record);
                }

                return filteredList;

            case "tld":
                for (Map<String, Object> record : notFilteredList) {
                    if (processedDomain.getSuitableTlds().contains(record.get("tld").toString()))
                        filteredList.add(record);
                }
                return filteredList;

        }
        System.out.println("Incorrect filter's field");
        return notFilteredList;
    }
}