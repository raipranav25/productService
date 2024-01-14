package com.productservice.productservice.Controller;

import com.productservice.productservice.DTO.GenericProductDto;
import com.productservice.productservice.Exceptions.ProductNotFoundException;
import com.productservice.productservice.Service.ProductService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {
    @Captor
    private ArgumentCaptor<Long> argumentCaptor;
    @Inject
    ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("Testing 1 + 1 is 2")
    void TestAPIExample()
    {
        //assert( 1 + 1 == 2);
       // assertEquals(11, 1+1, "1+1 should be 2");
        //assertTrue(2+2 == 5 );
        //assertNull();
        //assertNotEquals();
    }
@Test
    void testGetProductByIdNegativeTC(){
        //()-> Lambda expression
        //here it converts the function to executable
       // assertThrows(ProductNotFoundException.class, () -> productController.getProductById(10000L));
    }
@Test
    void testGetProductByIdMocking() throws ProductNotFoundException {
    GenericProductDto genericProductDto = new GenericProductDto();
        try {
            //When productService.getProductById will be called from productController in this function
            //This mock productService will be called instead
            //This check functionality of only controller
            when(productService.getProductById(1000L)).thenReturn( genericProductDto);
           // when(productService.getProductById(any(Long.class))).thenReturn( genericProductDto);
            //for any long value
        }
        catch (Exception e )
        {
            System.out.println();
        }
        //assertNull(productController.getProductById(100L));
        assertEquals(genericProductDto, productController.getProductById(1000L));
    }
    @Test
    void testGetProductByIdExceptionMocking() throws ProductNotFoundException
    {
        when(productService.getProductById(1L)).thenThrow(ProductNotFoundException.class);

        assertThrows(ProductNotFoundException.class, () -> productController.getProductById(1L));
    }

    @Test
    @DisplayName("testProductControllerPassingSameIdToProductService")
    void testIfSameArgument() throws ProductNotFoundException {
        Long id = 100L;
        when(productController.getProductById(id)).thenReturn(new GenericProductDto());
        GenericProductDto genericProductDto = productController.getProductById(id);
        verify(productService).getProductById(argumentCaptor.capture());
        assertEquals(id,argumentCaptor.getValue());
    }
}
