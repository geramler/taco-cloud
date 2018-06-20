package example.sia5.tacos.respository;

import example.sia5.tacos.model.Order;

public interface OrderRepository {
	
	Order save(Order order);

}