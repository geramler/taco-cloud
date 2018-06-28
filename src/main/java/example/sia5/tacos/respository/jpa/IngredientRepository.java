package example.sia5.tacos.respository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import example.sia5.tacos.model.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}