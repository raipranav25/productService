package com.productservice.productservice;


import com.productservice.productservice.Models.Category;
import com.productservice.productservice.Models.Price;
import com.productservice.productservice.Models.Product;
import com.productservice.productservice.inheritanceRelation.Joined.MentorRepository;
import com.productservice.productservice.inheritanceRelation.Joined.Mentor;
import com.productservice.productservice.repository.CategoryRepository;
import com.productservice.productservice.repository.PriceRepository;
import com.productservice.productservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication {//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}	/* @Autowired
	private MentorRepository mentorRepository;
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final PriceRepository priceRepository;

	ProductServiceApplication ( ProductRepository productRepository, CategoryRepository categoryRepository,
								PriceRepository priceRepository)
	{
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.priceRepository = priceRepository;
	}*/

	/*@Override
 @Transactional
	//Runs whole function in single transaction in DB
	//In case of lazy loading, data is fetched from DB when DB queries are part of same transaction
	public void run( String... args ) throws Exception {
	*//*Mentor mentor = new Mentor();
	mentor.setRating(4);
	mentor.setName("xyz");
	mentor.setEmail("xyz@academy.com");
	mentorRepository.save(mentor);

	Mentor mentor1 = new Mentor();
	mentor1.setRating(3);
	mentor1.setEmail("abc@academy.com");
	mentor1.setName("abc");

	System.out.println( mentorRepository.save(mentor1).toString() );
*/	/*Category category = new Category();
	category.setName("Apple Products");
*/
	/*Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("abf26184-ec45-4c46-b894-39306e82fa7c"));
	if( optionalCategory.isEmpty() )
	{
		throw new Exception("Category not found");
	}
	Product product = new Product();
	product.setCategory(optionalCategory.get());
	product.setTitle("Iphone 15");
	product.setDescription("Best iphone");
	product.setPrice(100000);

	//categoryRepository.save(category);
	//List<Product> productList = productRepository.findAll();
*//*	List<Product> productList = optionalCategory.get().getProductlist();
    for( Product product1 : productList )
	{
		System.out.println(product.getTitle());
	}*//*
	productRepository.save(product);
	*/
	/*Price price = new Price();
	price.setCurrency("inr");
	price.setValue(100000);
	//Price price1 = priceRepository.save(price);

	Category category = new Category();
	category.setName("Apple");
	Category category1 = categoryRepository.save(category);

	Product product = new Product();
	product.setCategory(category1);
	product.setTitle("Iphone 15");
	product.setDescription("Best iphone");
	product.setPrice(price);
	productRepository.save(product);*/

	//productRepository.deleteById(UUID.fromString("4925403f-a65f-4ba9-9b94-58940a32536f"));
		/*Category category = new Category();
		category.setName("Phone");
		categoryRepository.save(category);*/

		/*Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("6a37b3ea-6a7c-4422-83b9-e7a1cebcd68c"));
		if( optionalCategory.get() == null )
		{
			throw new Exception("Category not found");
		}
		Category category = optionalCategory.get();
		Price price = new Price();
		price.setValue(10000);
		price.setCurrency("inr");
		priceRepository.save(price);

		Product product = new Product();
		product.setDescription("Iphone");
		product.setTitle("15");
		product.setCategory(category);
		product.setPrice(price);
		productRepository.save(product);

		Price price1 = new Price();
		price1.setValue(20000);
		price1.setCurrency("inr");
		priceRepository.save(price1);

		Product product1 = new Product();
		product1.setDescription("Iphone");
		product1.setTitle("12");
		product1.setCategory(category);
		product1.setPrice(price1);
		productRepository.save(product1);

		Price price2 = new Price();
		price2.setValue(20000);
		price2.setCurrency("inr");
		priceRepository.save(price2);

		Product product2 = new Product();
		product2.setDescription("Iphone");
		product2.setTitle("12");
		product2.setCategory(category);
		product2.setPrice(price2);
		productRepository.save(product2);*/

		//List<Product> products = productRepository.findAllByTitle("12");
		/*List<Product> products = productRepository.findAllByPrice_ValueGreaterThan(4000);
		for( Product productItr : products )
		{
			System.out.println(productItr.toString());
		}*/


	//}
