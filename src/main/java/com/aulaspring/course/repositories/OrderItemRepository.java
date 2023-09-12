package com.aulaspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.course.entities.OrderItem;

/* Repositório da entidade OrderItem
 *
 * Como a interface extende JpaRepository, ela ja possuira uma implementação
 * padrão dos metodos do JPA
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
