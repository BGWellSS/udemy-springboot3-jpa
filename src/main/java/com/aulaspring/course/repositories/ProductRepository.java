package com.aulaspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
