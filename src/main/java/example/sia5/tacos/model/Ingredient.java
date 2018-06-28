package example.sia5.tacos.model;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
// force attr - sets to null final properties
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Entity
// ensures that we will still have a required arguments constructor
@RequiredArgsConstructor
public class Ingredient {
  
  private final String id;
  private final String name;
  private final Type type;
  
  public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }

}
