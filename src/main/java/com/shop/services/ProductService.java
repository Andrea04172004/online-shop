package com.shop.services;

import com.shop.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long productId, ProductDto productDto);

    ProductDto deleteProduct(Long productId);

    ProductDto findProductByName(String name);

    ProductDto findProductByCode(String code);

    List<ProductDto> findAllProducts();
}
