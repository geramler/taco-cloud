package example.sia5.jdbc;

import tacos.Ingredient;

public interface IngredientRepository {
	Iterable<Ingredient> findAll();

	Ingredient findOne(String id);

	Ingredient save(Ingredient ingredient);
}