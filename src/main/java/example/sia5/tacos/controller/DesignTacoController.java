package example.sia5.tacos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import example.sia5.tacos.model.Ingredient;
import example.sia5.tacos.model.Ingredient.Type;
import example.sia5.tacos.model.Order;
import example.sia5.tacos.model.Taco;
import example.sia5.tacos.respository.IngredientRepository;
import example.sia5.tacos.respository.TacoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
// specifies any model objects that should be kept in session
@SessionAttributes("order")
public class DesignTacoController {

	@ModelAttribute(name = "order")
	public Order order() {
		return new Order();
	}

	@ModelAttribute(name = "design")
	public Taco taco() {
		return new Taco();
	}

	private final IngredientRepository ingredientRepo;

	private TacoRepository designRepo;

	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository designRepo) {
		this.ingredientRepo = ingredientRepo;
		this.designRepo = designRepo;
	}

	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(i -> ingredients.add(i));
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}

		// model.addAttribute("design", new Taco());

		return "design";
	}

	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors,
			// Spring MVC should not attempt to bind request parameters to it
			@ModelAttribute Order order) {
		if (errors.hasErrors()) {

			List<FieldError> fieldErrors = errors.getFieldErrors();
			for (FieldError e : fieldErrors) {
				System.out.println(" -- " + e.getField());
			}
			return "design";
		}
		log.info("Processing design: " + design);
		Taco saved = designRepo.save(design);
		order.addDesign(saved);
		return "redirect:/orders/current";
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}

}