package example.sia5.tacos.respository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import example.sia5.tacos.model.Taco;

@Repository
public interface TacoRepository extends CrudRepository<Taco, Long> {
}
