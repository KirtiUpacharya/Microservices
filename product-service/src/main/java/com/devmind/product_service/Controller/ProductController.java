package com.devmind.product_service.Controller;

import com.devmind.product_service.DTO.ProductRequest;
import com.devmind.product_service.DTO.ProductResponse;
import com.devmind.product_service.model.Product;
import com.devmind.product_service.Repository.productRepository;
import com.devmind.product_service.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    productRepository  productrepo;

    @Autowired
    ProductService productservice;

    @PostMapping("/api/product/{id}")
    public ResponseEntity<String> createProduct(@PathVariable("id") String id)
    {
        Product product=new Product();
        product.setUserId(id);
        productrepo.save(product);
     return  ResponseEntity.ok("Data created");
    }

    @PostMapping("/api/addProduct")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody ProductRequest productrequest)
    {
      return productservice.addProduct(productrequest) ;
    }

    @GetMapping("/api/getAllProducts")
    public ResponseEntity<List<ProductResponse>> getAllProducts()
    {

        return ResponseEntity.ok(productservice.getAllProduct());
    }

    @GetMapping("/api/getProducts")
    public ResponseEntity<String> getProducts()
    {

        return ResponseEntity.status(HttpStatus.CREATED).body("Good");
    }

    public void cal(int a, int b)
    {
        if(a==0 || b==0)
        {
            throw new ArithmeticException("please fill right value for a & b");
        }else{
            int result=a/b;
        }
    }


    public void Disply()
    {
        cal(1,2);

    }
}
