package com.aulaspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.course.entities.Order;

/* Repositório da entidade Order
 *
 * Como a interface extende JpaRepository, ela á possui uma implementação
 * padrão para o tipo passado Order com o id (Long)
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}