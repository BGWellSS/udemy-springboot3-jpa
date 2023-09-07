package com.aulaspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * Método endpoint para acesso aos usuários
     * O tipo de retorno é ResponseEntity<T> do Spring que é responsavel por
     * retornar requisições web
     * 
     * Para indicar que o método será usado pra responder requisições GET do HTTP
     * utilizamos a annotation GetMapping
     **/
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {

        List<Order> OrderList = service.findAll();

        return ResponseEntity.ok().body(OrderList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
