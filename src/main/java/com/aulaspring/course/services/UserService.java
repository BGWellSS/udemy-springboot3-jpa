package com.aulaspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspring.course.entities.User;
import com.aulaspring.course.repositories.UserRepository;

/**
 * Anotattion Service - Registrar no spring que a classe será usada como um
 * serviço
 */
@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  // Elemento do CRUD - READ
  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = repository.findById(id);
    return obj.get();
  }

  // Elemento do CRUD - CREATE
  public User insert(User obj) {
    return repository.save(obj);
  }

  // Elemento do CRUD - DELETE
  public void delete(Long id) {
    repository.deleteById(id);
  }

  // Elemento do CRUD - UPDATE
  public User update(Long id, User obj) {
    User entity = repository.getReferenceById(id);
    updateData(entity, obj);
    return repository.save(entity);
  }

  // Metodo auxiliar para atualizacao dos dados
  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }
}
