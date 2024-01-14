package com.productservice.productservice.Service;

import com.productservice.productservice.DTO.FakeStoreProductDto;
import com.productservice.productservice.DTO.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.FakeStoreAdapter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
//@Service("fakeStoreProductService")
@Service
public class FakeStoreProductService implements ProductService {
    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto )
    {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }
    private final FakeStoreAdapter fakeStoreAdapter;
    @Override
    public GenericProductDto createProduct( GenericProductDto genericProductDto ) {
        return convertToGenericProductDto( fakeStoreAdapter.createProduct( genericProductDto ) );
    }
    FakeStoreProductService( FakeStoreAdapter fakeStoreAdapter )
    {
        this.fakeStoreAdapter = fakeStoreAdapter;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        return convertToGenericProductDto( fakeStoreAdapter.getProductById(id) );
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> result = new ArrayList<>();
        for( FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos )
        {
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertToGenericProductDto( fakeStoreAdapter.deleteProductById(id) );
    }

    @Override
    public void updateProductById() {

    }
}
