package com.aulaspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.course.entities.Product;
import com.aulaspring.course.repositories.ProductRepository;

/**
 * Anotattion Service - Registrar no spring que a classe sera usada como um
 * servico
 */
@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  // Elemento do CRUD - READ
  public List<Product> findAll() {
    return repository.findAll();
  }

  public Product findById(Long id) {
    Optional<Product> obj = repository.findById(id);
    return obj.get();
  }
}
