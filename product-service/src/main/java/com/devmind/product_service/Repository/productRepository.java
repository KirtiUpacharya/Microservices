package com.devmind.product_service.Repository;

import com.devmind.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface productRepository extends MongoRepository<Product,String> {



}
