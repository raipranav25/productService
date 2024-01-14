package com.productservice.productservice.Service;

import com.productservice.productservice.DTO.FakeStoreProductDto;
import com.productservice.productservice.DTO.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws ProductNotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProductById( Long id );

    GenericProductDto createProduct( GenericProductDto genericProductDto );

    void updateProductById();

}
