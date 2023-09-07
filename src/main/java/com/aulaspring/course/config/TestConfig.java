package com.aulaspring.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulaspring.course.entities.Order;
import com.aulaspring.course.entities.User;
import com.aulaspring.course.repositories.OrderRepository;
import com.aulaspring.course.repositories.UserRepository;

/*
 * Classe auxiliar de configuração do perfil de teste
 * 
 * As annotations Configuration e Profile indicam ao spring
 * que a classe é de configuração de perfil, que no caso é 
 * test
 * 
 * O implements CommandLineRunner faz com que a classe seja executada
 * no inicio da aplicação
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    /*
     * A annotation Autowired indica ao spring que existe uma dependencia
     * fazendo o spring tratar essa dependencia seguindo os padrões do SOLID
     * de baixo acoplamento e associando uma instância de userRepository
     */
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    /*
     * Método referente ao implements CommandLineRunner que será executado
     * com o inicio da aplicação.
     * 
     * Funcionará nesse momento apenas como um injetor de dados(Data seeding)
     */
    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}
