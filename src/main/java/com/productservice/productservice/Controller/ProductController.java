package com.productservice.productservice.Controller;

import com.productservice.productservice.DTO.ExceptionDto;
import com.productservice.productservice.DTO.FakeStoreProductDto;
import com.productservice.productservice.DTO.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.Service.FakeStoreProductService;
import com.productservice.productservice.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    private ProductService productService;
//@Autowired: Not needed
    //@Autowired
    //ProductController( @Qualifier("fakeStoreProductService") ProductService productService )
    @Autowired
    ProductController( ProductService productService )
    {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") long id) throws ProductNotFoundException
    {
        return productService.getProductById(id);
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts()
    {
      return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    public void updateProductById( @PathVariable("id") long id )
    {

    }
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") long id)
    {
        return productService.deleteProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct( @RequestBody GenericProductDto genericProductDto)
    {
        return productService.createProduct(genericProductDto);
    }
/*@ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException)
    {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMsg(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ExceptionDto>( exceptionDto, HttpStatus.NOT_FOUND);
        //System.out.println("Got product not found exception");
    }*/
}
