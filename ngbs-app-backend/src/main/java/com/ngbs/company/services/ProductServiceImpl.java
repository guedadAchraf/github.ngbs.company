package com.ngbs.company.services;


import com.ngbs.company.dto.ProductDto;
import com.ngbs.company.exception.ProductException;
import com.ngbs.company.mapper.ProductMapper;
import com.ngbs.company.models.Product;
import com.ngbs.company.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.dtoToEntity(productDto);
        product = productRepository.save(product);
        return productMapper.entityToDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        // Check if the products list is empty
        if (products.isEmpty()) {
            throw new ProductException("No products found.");
        }

        return products.stream()
                .map(productMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long idProduct) {
        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new ProductException("Product not found with ID: " + idProduct));
        productRepository.delete(product);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product existingProduct = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new ProductException("Produit avec ID " + productDto.getId() + " introuvable."));

        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setCategory(productDto.getCategory());
        existingProduct.setPrice(productDto.getPrice());

        Product updatedProduct = productRepository.save(existingProduct);

        return productMapper.entityToDto(updatedProduct);

         }

}
