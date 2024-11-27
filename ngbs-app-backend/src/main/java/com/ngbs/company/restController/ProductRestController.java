package com.ngbs.company.restController;


import com.ngbs.company.dto.ProductDto;
import com.ngbs.company.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = "*",
        methods = { RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE }
)
public class ProductRestController {


    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return  productService.createProduct(productDto);
    }

    @GetMapping(value = "/getAll")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/update/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productDto.setId(id);
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


























}
