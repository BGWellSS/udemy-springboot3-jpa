package com.aulaspring.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspring.course.entities.User;

// Controlador Rest de recursos da entidade User
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    /*
     * Método endpoint para acesso aos usuários
     * O tipo de retorno é ResponseEntity<T> do Spring que é responsavel por
     * retornar requisições web
     * 
     * Para indicar que o método será usado pra responder requisições GET do HTTP
     * utilizamos a annotation GetMapping
     **/
    @GetMapping
    public ResponseEntity<User> findAll() {
        // Usuário de exemplo para testes
        User u = new User(1L, "Maria", "maria@gmail.com", "91955555555", "123456789");
        return ResponseEntity.ok().body(u);
    }
}
