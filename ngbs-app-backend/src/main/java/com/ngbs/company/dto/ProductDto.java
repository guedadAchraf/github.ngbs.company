package com.ngbs.company.dto;


import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;


    // Constructors
    public ProductDto() {}

    public ProductDto(Long id, String name, String description, Double price,String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category=category;
    }


}
