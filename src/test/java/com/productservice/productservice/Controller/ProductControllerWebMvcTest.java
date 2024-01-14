package com.productservice.productservice.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.DTO.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.Service.ProductService;
import com.productservice.productservice.repository.ProductRepository;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)//Dependency
public class ProductControllerWebMvcTest {

    @MockBean
    private ProductService productService;


    @Inject
    private MockMvc mockMvc;
    // private ProductRepository

    @Inject
    private ObjectMapper objectMapper;

    @Test
    void testGetAllProductsReturnEmptyList() throws Exception {
        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string("[]"));
    }

    @Test
    void testGetAllProductsReturnValidList() throws Exception {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());
        genericProductDtos.add(new GenericProductDto());

        when(productService.getAllProducts())
                .thenReturn(genericProductDtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(genericProductDtos)));
    }

    @Test
    void createProductShouldCreateValidNewProduct() throws Exception {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle("Macbook");
        genericProductDto.setPrice(10000);
        genericProductDto.setDescription("Apple Macbook");
        genericProductDto.setCategory("Laptop");

        GenericProductDto outPutProductDto = new GenericProductDto();
        outPutProductDto.setTitle("Macbook");
        outPutProductDto.setPrice(10000);
        outPutProductDto.setDescription("Apple Macbook");
        outPutProductDto.setCategory("Laptop");
        outPutProductDto.setId(10000L);

        when(productService.createProduct(any(GenericProductDto.class)))
                .thenReturn(outPutProductDto);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(genericProductDto)))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(outPutProductDto)))
                .andExpect(jsonPath("$.title", is("Macbook")));
    }
}