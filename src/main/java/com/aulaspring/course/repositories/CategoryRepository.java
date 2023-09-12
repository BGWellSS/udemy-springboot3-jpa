package com.aulaspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
