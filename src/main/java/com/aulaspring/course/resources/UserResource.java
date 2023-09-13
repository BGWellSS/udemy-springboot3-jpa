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

import com.aulaspring.course.entities.User;
import com.aulaspring.course.services.UserService;

// Controlador Rest de recursos da entidade User
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    /*
     * Metodo endpoint para acesso aos usuarios
     * O tipo de retorno eh ResponseEntity<T> do Spring que eh responsavel por
     * retornar requisicoes web
     * 
     * Para indicar que o metodo sera usado pra responder as requisicoes HTTP - GET
     * do endpoint '/users', utilizamos a annotation GetMapping. Retornando todos os
     * Users
     * 
     * Elemento do CRUD - READ
     **/
    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        List<User> userList = service.findAll();

        return ResponseEntity.ok().body(userList);
    }

    /**
     * Mapeamento para o endpoint '/users/id' para o retorno de um unico User
     * em uma requisicao HTTP - GET
     * 
     * Elemento do CRUD - READ
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Mapeamento para a requisicao HTTP - POST para o endpoint '/users'
     * 
     * Elemento do CRUD - CREATE
     */
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj);
        /**
         * Como boa pratica devemos retornar uma requisicao POST com o
         * codigo HTTP 201 e tambem a URL(location) de onde esse novo
         * recurso foi criado. Para isso usamos o codigo a seguir para atender esses
         * requisitos
         */
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    /**
     * Mapeamento para o endpoint '/users/id' para a remocao de um User por ID
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
     * Mapeamento para o endpoint '/users/id' para a atualizacao de um User por ID
     * com um corpo de requisicao JSON com as modificacoes do User em uma requisicao
     * HTTP - PUT
     * 
     * Elemento do CRUD - UPDATE
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
