package com.devsuperior.uri2602.dtos;

import com.devsuperior.uri2602.projections.CustomerNameMinProjection;

public class CustomerMinDTO {

    private String name;

    public CustomerMinDTO(String name){
       this.name = name;
    }
    public CustomerMinDTO(CustomerNameMinProjection customerNameMinProjection){
        this.name = customerNameMinProjection.getName();
    }

    public String getName() {
        return name;
    }
}
