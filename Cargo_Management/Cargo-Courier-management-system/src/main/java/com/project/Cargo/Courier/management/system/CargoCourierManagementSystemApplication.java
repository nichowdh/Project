package com.project.Cargo.Courier.management.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.Cargo.Courier.management.system.entity.Product;
import com.project.Cargo.Courier.management.system.repository.ProductRepository;

@SpringBootApplication
public class CargoCourierManagementSystemApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository pr;

	public static void main(String[] args) {
		SpringApplication.run(CargoCourierManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product p1 = Product.builder().ProductName("Table").ProductWeight(245.26).ProductDescription("laptop table")
				.ShippingPrice(2646.68).build();
		Product p2 = Product.builder().ProductName("Shoe").ProductWeight(0.750).ProductDescription("Puma")
				.ShippingPrice(1679.50).build();

		pr.save(p1);
		pr.save(p2);

		System.out.println("---------------All saved-------------");

	}

}
