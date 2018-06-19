package example.sia5.tacos.respository;

import example.sia5.tacos.model.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll();

	Ingredient findOne(String id);

	Ingredient save(Ingredient ingredient);
}