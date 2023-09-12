package com.aulaspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.course.entities.Product;
import com.aulaspring.course.services.ProductService;

// Controlador Rest de recursos da entidade Product
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

  // Conexão com o serviço
  @Autowired
  private ProductService service;

  /*
   * Método endpoint para acesso aos usuários
   * O tipo de retorno é ResponseEntity<T> do Spring que é responsavel por
   * retornar requisições web
   * 
   * Para indicar que o método será usado pra responder requisições GET do HTTP
   * utilizamos a annotation GetMapping
   **/
  @GetMapping
  public ResponseEntity<List<Product>> findAll() {

    List<Product> productList = service.findAll();

    return ResponseEntity.ok().body(productList);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    Product obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }
}
