package com.aulaspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.course.entities.Category;
import com.aulaspring.course.repositories.CategoryRepository;

/**
 * Anotattion Service - Registrar no spring que a classe sera usada como um
 * servico
 */
@Service
public class CategoryService {

  @Autowired
  private CategoryRepository repository;

  // Elemento do CRUD - READ
  public List<Category> findAll() {
    return repository.findAll();
  }

  public Category findById(Long id) {
    Optional<Category> obj = repository.findById(id);
    return obj.get();
  }

  // Elemento do CRUD - CREATE
  public Category insert(Category obj) {
    return repository.save(obj);
  }

  // Elemento do CRUD - DELETE
  public void delete(Long id) {
    repository.deleteById(id);
  }

  // Elemento do CRUD - UPDATE
  public Category update(Long id, Category obj) {
    Category entity = repository.getReferenceById(id);
    updateCategoryData(entity, obj);
    return repository.save(entity);
  }

  private void updateCategoryData(Category entity, Category obj) {
    entity.setName(obj.getName());
  }
}
