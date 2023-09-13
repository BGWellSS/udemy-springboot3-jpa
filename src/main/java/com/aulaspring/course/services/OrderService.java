package com.aulaspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.course.entities.Order;
import com.aulaspring.course.repositories.OrderRepository;

/**
 * Anotattion Service - Registrar no spring que a classe sera usada como um
 * servico
 */
@Service
public class OrderService {

  @Autowired
  private OrderRepository repository;

  // Elemento do CRUD - READ
  public List<Order> findAll() {
    return repository.findAll();
  }

  public Order findById(Long id) {
    Optional<Order> obj = repository.findById(id);
    return obj.get();
  }

  // Elemento do CRUD - CREATE
  public Order insert(Order obj) {
    return repository.save(obj);
  }

  // Elemento do CRUD - DELETE
  public void delete(Long id) {
    repository.deleteById(id);
  }
}
