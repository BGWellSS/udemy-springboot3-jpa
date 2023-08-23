package com.aulaspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aulaspring.course.entities.User;

/* Repositório da entidade User
 *
 * Como a interface extende JpaRepository, ela á possui uma implementação
 * padrão para o tipo passado User com o id (Long)
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
