package com.aulaspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.course.entities.User;
import com.aulaspring.course.services.UserService;

// Controlador Rest de recursos da entidade User
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    // Conexão com o serviço
    @Autowired
    private UserService service;

    /*
     * Método endpoint para acesso aos usuários
     * O tipo de retorno é ResponseEntity<T> do Spring que é responsavel por
     * retornar requisições web
     * 
     * Para indicar que o método será usado pra responder requisições GET do HTTP
     * utilizamos a annotation GetMapping
     **/
    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        List<User> userList = service.findAll();

        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
