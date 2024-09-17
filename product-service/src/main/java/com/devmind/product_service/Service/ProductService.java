package com.devmind.product_service.Service;

import com.devmind.product_service.DTO.ProductRequest;
import com.devmind.product_service.DTO.ProductResponse;
import com.devmind.product_service.model.Product;
import com.devmind.product_service.Repository.productRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService
{

   private final productRepository productrepository;



    public List<ProductResponse> getAllProduct()
    {
        List<Product> products=productrepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
    public ProductResponse mapToProductResponse(Product product)
    {
       return  ProductResponse.builder()
                .userId(product.getUserId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription()).build();


    }

    public Product addProduct(ProductRequest productrequest)
    {
        Product product=Product.builder()
                .userId(productrequest.getUserId())
                .productName(productrequest.getProductName())
                .productDescription((productrequest.getProductDescription())).build();
        productrepository.save(product);

        return product;
    }


}
