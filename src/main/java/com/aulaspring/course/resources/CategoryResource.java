package com.aulaspring.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aulaspring.course.entities.Category;
import com.aulaspring.course.services.CategoryService;

// Controlador Rest de recursos da entidade Category
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

  // Conexão com o serviço
  @Autowired
  private CategoryService service;

  /*
   * Metodo endpoint para acesso aos usuarios
   * O tipo de retorno sera ResponseEntity<T> do Spring que e responsavel
   * por retornar requisições web
   * 
   * Utilizamos a annotation GetMapping para indicar que o metodo sera
   * usado pra responder as requisicoes HTTP - GET do endpoint
   * '/categories'
   * 
   * O retorno sera de todos os itens de Category cadastrados
   * 
   * Elemento do CRUD - READ
   **/
  @GetMapping
  public ResponseEntity<List<Category>> findAll() {

    List<Category> categoryList = service.findAll();

    return ResponseEntity.ok().body(categoryList);
  }

  /**
   * Mapeamento para o endpoint '/categories/id' para o retorno de uma
   * unica Category em uma requisicao HTTP - GET
   * 
   * Elemento do CRUD - READ
   */
  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable Long id) {
    Category obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  /**
   * Mapeamento para o endpoint '/categories', o corpo da requisicao
   * deve possuir um JSON do objeto a ser criado.
   * 
   * Requisicao HTTP - POST
   * 
   * Elemento do CRUD - CREATE
   */
  @PostMapping
  public ResponseEntity<Category> insert(@RequestBody Category obj) {
    obj = service.insert(obj);
    /**
     * Para requisicoes PUT devemos retornar com o codigo HTTP 201
     * e tambem a URL(location) de onde esse novo recurso foi criado
     * 
     * Para isso usamos o codigo a serguir para atender o padrao
     */
    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }

  /**
   * Mapeamento para o endpoint '/categories/id' para a remocao de uma Category
   * por ID
   * em uma requisicao HTTP - DELETE
   * 
   * Elemento do CRUD - DELETE
   */
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  /**
   * Mapeamento para o endpoint '/categories/id' para a atualizacao de uma
   * Category por ID
   * com um corpo de requisicao JSON com as modificacoes da Category em uma
   * requisicao
   * HTTP - PUT
   * 
   * Elemento do CRUD - UPDATE
   */
  @PutMapping(value = "/{id}")
  public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category obj) {
    obj = service.update(id, obj);
    return ResponseEntity.ok().body(obj);
  }
}
