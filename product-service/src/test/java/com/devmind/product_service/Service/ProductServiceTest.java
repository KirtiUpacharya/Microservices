package com.devmind.product_service.Service;

import com.devmind.product_service.Repository.productRepository;
import com.devmind.product_service.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.devmind.product_service.DTO.ProductResponse;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {


    @Mock
    private ProductResponse productresposne;

    @Mock
    private productRepository productRepository; // Dependency to be mocked

   @InjectMocks
   private ProductService productService; // Class under test



    @Test
    @DisplayName("Just to ckeck the Assert, JUIT")
    public void MethodCall(){
        //ProductService ps=new ProductService(null);
        //List<ProductResponse> p=productService.getAllProduct();
        Mockito.lenient().when(productService.getAllProduct()).thenReturn(List.of(productresposne));
        //Assertions.assertNotNull(p);


    }

}