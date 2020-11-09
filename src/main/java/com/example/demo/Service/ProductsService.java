package com.example.demo.Service;

import com.example.demo.Dto.ProductDto;
import com.example.demo.Repository.ProductsRepository;
import com.example.demo.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        productsRepository.findAll().forEach(product -> {
            ProductDto productDto = productMapperToDto(product);
            productDtos.add(productDto);
        });

        return productDtos;
    }

    public List<ProductDto> findByProductName(String productName) {
       List<ProductDto> productDtos = new ArrayList<>();

        productsRepository.findByProductName(productName).forEach(product -> {
            ProductDto productDto = productMapperToDto(product);
            productDtos.add(productDto);
        });
        return productDtos;
    }
    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapperToEntity(productDto);
        productDto.setId(productsRepository.save(productEntity).getId());
        return productDto;
    }
    public void deleteByName(String productName) {
        List<ProductEntity> productEntities = productsRepository.findByProductName(productName);
        productEntities.forEach(product -> {
            productsRepository.delete(product);
        });

    }

    public void editCountByName(String productName, Integer productCount) {
        productsRepository.findByProductName(productName).forEach(product -> {
            //product.setProductCount(count);
            productsRepository.updateProductCountById(product.getId(),productCount);


        });



    }

    private ProductDto productMapperToDto(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setProductName(productEntity.getName());
        productDto.setProductCount(productEntity.getProductCount());
        productDto.setPrice(productEntity.getPrice());
        productDto.setImage(productEntity.getImage());
        return productDto;
    }

    private ProductEntity productMapperToEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getProductName());
        productEntity.setProductCount(productDto.getProductCount());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setImage(productDto.getImage());
        return productEntity;
    }

}
