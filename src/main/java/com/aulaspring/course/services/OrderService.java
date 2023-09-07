package com.aulaspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.course.entities.Order;
import com.aulaspring.course.repositories.OrderRepository;

/**
 * Anotattion Service - Registrar no spring que a classe será usada como um
 * serviço
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
