package com.productservice.productservice.thirdPartyClients;

import com.productservice.productservice.DTO.FakeStoreProductDto;
import com.productservice.productservice.DTO.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Component
public class FakeStoreAdapter implements ThirdPartInterFace {
    private final RestTemplateBuilder restTemplateBuilder;

    //String fakeStoreUrl;

    //String pathForProducts;

    private String productsUrl;
    private String getAllProductsUrl;
    @Override
    public FakeStoreProductDto createProduct( GenericProductDto genericProductDto ) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity( productsUrl, genericProductDto, FakeStoreProductDto.class );
        return responseEntity.getBody();
    }
    FakeStoreAdapter( RestTemplateBuilder restTemplateBuilder,
                      @Value("${fakestore.api.url}")String fakeStoreUrl,
                      @Value("${fakestore.api.paths.products}" )String pathForProducts )
    {
        this.productsUrl = fakeStoreUrl + pathForProducts + "/{id}";
        this.getAllProductsUrl = fakeStoreUrl + pathForProducts;
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        // String url = getProductUrl + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(productsUrl, FakeStoreProductDto.class, id);
        if( responseEntity.getBody() == null )
        {
            throw new ProductNotFoundException("Product " + id + " Not found ");
        }
        return responseEntity.getBody();
    }

    @Override
    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate =  restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(getAllProductsUrl, FakeStoreProductDto[].class);
        return List.of(responseEntity.getBody());
    }

    @Override
    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(productsUrl, FakeStoreProductDto.class, id);
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity< FakeStoreProductDto > responseEntity = restTemplate.execute(productsUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }

    @Override
    public void updateProductById() {

    }
}
