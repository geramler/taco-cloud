package example.sia5.tacos.respository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import example.sia5.tacos.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}