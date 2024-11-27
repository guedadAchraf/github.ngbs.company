package com.ngbs.company.services;

import com.ngbs.company.dto.ProductDto;
import com.ngbs.company.models.Product;

import java.util.List;

public interface ProductService {


    ProductDto  createProduct(ProductDto productDto);
    List  <ProductDto> getAllProducts();
    void  deleteProduct(Long idProduct);
    ProductDto updateProduct(ProductDto productDto);

}
