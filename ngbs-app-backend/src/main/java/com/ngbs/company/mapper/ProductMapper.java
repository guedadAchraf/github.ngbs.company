package com.ngbs.company.mapper;


import com.ngbs.company.dto.ProductDto;
import com.ngbs.company.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    // Convert Entity to DTO
    public ProductDto entityToDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory()
        );
    }


    // Convert DTO to Entity
    public Product dtoToEntity(ProductDto productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        return product;
    }











}
