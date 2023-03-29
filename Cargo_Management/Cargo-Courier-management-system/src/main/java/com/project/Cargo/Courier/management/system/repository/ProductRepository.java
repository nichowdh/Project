package com.project.Cargo.Courier.management.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Cargo.Courier.management.system.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
