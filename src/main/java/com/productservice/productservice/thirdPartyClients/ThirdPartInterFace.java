package com.productservice.productservice.thirdPartyClients;

import com.productservice.productservice.DTO.FakeStoreProductDto;
import com.productservice.productservice.DTO.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;

import java.util.List;

public interface ThirdPartInterFace {
    FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException;

    List<FakeStoreProductDto> getAllProducts();

    FakeStoreProductDto deleteProductById( Long id );

    FakeStoreProductDto createProduct( GenericProductDto genericProductDto );

    void updateProductById();
}
