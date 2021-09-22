package com.shop.mapper;

import com.shop.domain.CategoryEntity;
import com.shop.domain.ProductEntity;
import com.shop.dto.CategoryDto;
import com.shop.dto.ProductDto;
import com.shop.enums.ProductStatus;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BusinessMapper {
    @Resource
    private CategoryRepository categoryRepository;
    @Resource
    private ProductRepository productRepository;

    public Function<ProductDto, ProductEntity> productFromDtoToEntity = this::getProductEntity;
    public Function<ProductEntity, ProductDto> productFromEntityToDto = this::getProductDto;
    public Function<CategoryEntity, CategoryDto> categoryFromEntityToDto = this::getCategoryDto;
    public Function<CategoryDto, CategoryEntity> categoryFromDtoToEntity = this::getCategoryEntity;


    public <A, R> Set<R> collectionToSet(Collection<A> collection, Function<A, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toSet());
    }

    public <A, R> List<R> collectionToList(Collection<A> collection, Function<A, R> mapper) {
        return collection.stream().map(mapper).collect(Collectors.toList());
    }


    public ProductEntity getProductEntity(ProductDto productDto){
        return ProductEntity.builder()
                .amount(productDto.getAmount())
                .code(productDto.getCode())
                .images(productDto.getImages())
                .description(productDto.getDescription())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .status(ProductStatus.valueOf(productDto.getStatus()))
                .categoryEntity(categoryRepository.findByName(productDto.getCategory())).build();
    }
    public ProductDto getProductDto(ProductEntity productDto){
        return ProductDto.builder()
                .amount(productDto.getAmount())
                .code(productDto.getCode())
                .images(productDto.getImages())
                .description(productDto.getDescription())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .status(productDto.getStatus().name())
                .category(productDto.getCategoryEntity().getName()).build();
    }

    public CategoryDto getCategoryDto(CategoryEntity categoryEntity){
        return CategoryDto.builder()
                .created(categoryEntity.getCreated())
                .name(categoryEntity.getName())
                .productDtos(collectionToSet(categoryEntity.getProductEntities(),productFromEntityToDto)).build();
    }
    public CategoryEntity getCategoryEntity(CategoryDto categoryDto){
        return CategoryEntity.builder()
                .created(categoryDto.getCreated())
                .name(categoryDto.getName())
                .productEntities(collectionToSet(categoryDto.getProductDtos(),productFromDtoToEntity)).build();
    }





}

