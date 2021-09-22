package com.shop.servicesImpl;

import com.shop.domain.ProductEntity;
import com.shop.dto.ProductDto;
import com.shop.mapper.BusinessMapper;
import com.shop.repository.ProductRepository;
import com.shop.services.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRepository productRepository;
    @Resource
    private BusinessMapper businessMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        ProductEntity productEntity = productRepository.findByName(productDto.getName());
        if(productEntity!=null){
            throw new RuntimeException("Product with such name is already exist");
        }

    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        return null;
    }

    @Override
    public ProductDto deleteProduct(Long productId) {
        return null;
    }

    @Override
    public ProductDto findProductByName(String name) {
        return null;
    }

    @Override
    public ProductDto findProductByCode(String code) {
        return null;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return null;
    }
}
