package com.example.domainshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProcessedDomain {
    private String name;

    private String sortingField;
    private String sortingOrder;

    private String filterField;
    private double lowestPrice;
    private double highestPrice;
    private List<String> suitableTlds;
}
