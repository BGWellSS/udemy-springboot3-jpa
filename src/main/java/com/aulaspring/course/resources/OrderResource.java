package com.aulaspring.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aulaspring.course.entities.Order;
import com.aulaspring.course.services.OrderService;

// Controlador Rest de recursos da entidade Order
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

  // Conexão com o serviço
  @Autowired
  private OrderService service;

  /*
   * Metodo endpoint para acesso as Orders
   * O tipo de retorno sera ResponseEntity<T> do Spring que e responsavel
   * por retornar requisicoes web
   * 
   * Utilizamos a annotation GetMapping para indicar que o metodo sera
   * usado pra responder as requisicoes HTTP - GET do endpoint '/orders'
   * 
   * O retorno sera de todos itens de Order casastrados
   * 
   * Elemento do CRUD - READ
   **/
  @GetMapping
  public ResponseEntity<List<Order>> findAll() {

    List<Order> OrderList = service.findAll();

    return ResponseEntity.ok().body(OrderList);
  }

  /**
   * Mapeamento para o endpoint '/orders/id' para o retorno de um
   * unico Order em uma requisicao HTTP - GET
   * 
   * Elemento do CRUD - READ
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> findById(@PathVariable Long id) {
    Order obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  /**
   * Mapeamento para o endpoint '/orders', o corpo da requisicao
   * deve possuir um JSON do objeto a ser criado
   * 
   * Requisicao HTTP - POST
   * 
   * Elemento do CRUD - CREATE
   */
  @PostMapping
  public ResponseEntity<Order> insert(@RequestBody Order obj) {
    obj = service.insert(obj);
    /**
     * Para requisicoes PUT devemos retornar com o codigo HTTP 201
     * e tambem a URL(location) de onde esse novo recurso foi criado
     * 
     * Para isso usamos o codigo a seguir para atender o padrao
     */
    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }

  /**
   * Mapeamento para o endpoint '/orders/id' para a remocao de um User por ID
   * em uma requisicao HTTP - DELETE
   * 
   * Elemento do CRUD - DELETE
   */
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
