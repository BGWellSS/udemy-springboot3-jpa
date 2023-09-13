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

  @Autowired
  private ProductService service;

  /*
   * Metodo endpoint para acesso aos Products
   * O tipo de retorno sera ResponseEntity<T> do Spring que e responsavel
   * por retornar requisições web
   * 
   * Utilizamos a annotation GetMapping para indicar que o metodo sera
   * usado pra responder as requisicoes HTTP - GET do endpoint '/products'
   * 
   * O retorno sera de todos itens de Product casastrados
   * 
   * Elemento do CRUD - READ
   **/
  @GetMapping
  public ResponseEntity<List<Product>> findAll() {

    List<Product> productList = service.findAll();

    return ResponseEntity.ok().body(productList);
  }

  /**
   * Mapeamento para o endpoint '/products/id' para o retorno de um
   * unico Product em uma requisicao HTTP - GET
   * 
   * Elemento do CRUD - READ
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    Product obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }
}
