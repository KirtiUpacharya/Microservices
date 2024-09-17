package com.devmind.product_service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.devmind.product_service.Controller.ProductController;
import com.devmind.product_service.DTO.ProductRequest;
//import org.jetbrains.annotations.NotNull;
import com.devmind.product_service.Repository.productRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//integration test.
@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc

class ProductServiceApplicationTests {


	//@Value("${spring.data.mongodb.uri}")  to bring the value from app.properties & DynamicPropertyRegistry to set app.properties dynamically
	//private static String mongoUri; pls use, dynamicPropertyRegistry and dynamicPropertySource

	//@Autowired
	//private final productRepository productRepo;

	//@Autowired
	ProductController PD=new ProductController();

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ObjectMapper objectmapper;

	@Autowired
	productRepository productRepo;

	@Container
	static final MongoDBContainer mongoDBContainer =new MongoDBContainer("mongo:4.4.2");


	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicpropertyRegistry)
	{
	    dynamicpropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}




	@Test
	void shouldCreateProduct() throws Exception
	{
		ProductRequest productRequest=getProductBody();

		String ProductrequestJson=objectmapper.writeValueAsString(productRequest);


         mockMvc.perform(MockMvcRequestBuilders.post("/api/addProduct")
				.contentType(MediaType.APPLICATION_JSON)
				 .content(ProductrequestJson))
				 .andExpect(MockMvcResultMatchers.status().isCreated());
		 //.andExpect(RequestMatchers.content().contentType(MediaType.Application_JSOM_UTF8_VALUE))
		//.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)));
        /*.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].postName", Matchers.is("Post Name")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].userName", Matchers.is("User 1")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[1].postName", Matchers.is("Post Name 2")))
			.andExpect(MockMvcResultMatchers.jsonPath("$[1].userName", Matchers.is("User 2")));*/

		Assertions.assertEquals(1,productRepo.findAll().size());


	}

	public ProductRequest getProductBody()
	{
		return ProductRequest.builder().userId("Pratik_123").productName("Laptop").productDescription("Apple").build();
	}

	@Test
	@DisplayName("To test Asssert J Librrary")
	public void testException(){
		assertThatThrownBy(()->{PD.cal(1,0);}).isInstanceOf(ArithmeticException.class).hasMessage("please fill right value for a & b");

	}


}
