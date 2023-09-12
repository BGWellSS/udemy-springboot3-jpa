package com.aulaspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * Método endpoint para acesso aos usuários
     * O tipo de retorno é ResponseEntity<T> do Spring que é responsavel por
     * retornar requisições web
     * 
     * Para indicar que o método será usado pra responder requisições GET do HTTP
     * utilizamos a annotation GetMapping
     **/
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> categoryList = service.findAll();

        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
