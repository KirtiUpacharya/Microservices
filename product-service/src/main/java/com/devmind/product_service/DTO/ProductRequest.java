package com.devmind.product_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String userId;
    private String productName;
    private String productDescription;

}








