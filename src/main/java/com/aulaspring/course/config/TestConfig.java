package com.aulaspring.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aulaspring.course.entities.Category;
import com.aulaspring.course.entities.Order;
import com.aulaspring.course.entities.OrderItem;
import com.aulaspring.course.entities.Product;
import com.aulaspring.course.entities.User;
import com.aulaspring.course.entities.enums.OrderStatus;
import com.aulaspring.course.repositories.CategoryRepository;
import com.aulaspring.course.repositories.OrderItemRepository;
import com.aulaspring.course.repositories.OrderRepository;
import com.aulaspring.course.repositories.ProductRepository;
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
   * de baixo acoplamento e associando uma instância
   */
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private OrderItemRepository orderItemRepository;

  /*
   * Metodo referente ao implements CommandLineRunner que será executado
   * com o inicio da aplicação.
   * 
   * Funcionara nesse momento apenas como um injetor de dados(Data seeding)
   */
  @Override
  public void run(String... args) throws Exception {

    // Adicao de dados de teste (Data seeding) = User
    User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
    User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

    // Adicao de dados de teste (Data seeding) = Order
    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
    Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
    Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

    // Adicao de dados de teste (Data seeding) = Category
    Category cat1 = new Category(null, "Eletronics");
    Category cat2 = new Category(null, "Books");
    Category cat3 = new Category(null, "Computers");

    // Adicao de dados de teste (Data seeding) = Product
    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
    Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
    Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
    Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
    Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

    // Salvamento dos dados
    userRepository.saveAll(Arrays.asList(u1, u2));
    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    // Associacao de categorias aos produtos
    p1.getCategories().add(cat2);
    p2.getCategories().add(cat1);
    p2.getCategories().add(cat3);
    p3.getCategories().add(cat3);
    p4.getCategories().add(cat3);
    p5.getCategories().add(cat2);

    // Salvamento das associacoes
    productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    // Adicao de dados de teste (Data seeding) = Orderitem
    OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
    OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
    OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
    OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

    // Salvamento dos dados
    orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
  }
}
