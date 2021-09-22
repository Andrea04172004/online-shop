package com.shop.servicesImpl;

import com.shop.domain.ProductEntity;
import com.shop.dto.ProductDto;
import com.shop.enums.ProductStatus;
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
        productEntity = businessMapper.getProductEntity(productDto);
        productEntity.setStatus(ProductStatus.NEW);
        return businessMapper.getProductDto(productRepository.save(productEntity));
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(
                ()-> new RuntimeException("Product with such id not found"));

        if(productDto.getName() != null){
            productEntity.setName(productDto.getName());
        }
        if(productDto.getCode() != null){
            productEntity.setCode(productDto.getCode());
        }
        if(productDto.getAmount() != null){
            productEntity.setAmount(productDto.getAmount());
        }
        if(productDto.getDescription() != null){
            productEntity.setDescription(productDto.getDescription());
        }
        if(productDto.getPrice() != null){
            productEntity.setPrice(productDto.getPrice());
        }
        if(productDto.getStatus() != null){
            productEntity.setStatus(ProductStatus.valueOf(productDto.getStatus()));
        }

        return businessMapper.getProductDto(productRepository.save(productEntity));
    }

    @Override
    public ProductDto deleteProduct(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElseThrow(
                ()-> new RuntimeException("Product with such id not found"));

        productRepository.deleteById(productId);
        return businessMapper.getProductDto(productEntity);
    }

    @Override
    public ProductDto findProductByName(String name) {
        return businessMapper.getProductDto(productRepository.findByName(name));
    }

    @Override
    public ProductDto findProductByCode(String code) {
        return businessMapper.getProductDto(productRepository.findByCode(code));
    }

    @Override
    public List<ProductDto> findAllProducts() {
        return businessMapper.collectionToList(productRepository.findAll(), businessMapper.productFromEntityToDto);
    }
}
