package ch.tbz.recipe.planner.mapper;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Recipe;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import ch.tbz.recipe.planner.entities.RecipeEntity;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

/**
 * Testet den RecipeEntityMapper mit SoftAssertions.
 */
class RecipeEntityMapperTest {

    private RecipeEntityMapper mapper;

    @BeforeEach
    void setup() {
        mapper = Mappers.getMapper(RecipeEntityMapper.class);
    }

    @Test
    void entityToDomain_mapsAllFieldsCorrectly() {
        // Arrange
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setName("Tomate");
        ingredientEntity.setAmount(2);

        RecipeEntity entity = new RecipeEntity();
        entity.setId(UUID.randomUUID());
        entity.setName("Pasta");
        entity.setDescription("Lecker");
        entity.setImageUrl("pasta.jpg");
        entity.setIngredients(List.of(ingredientEntity));

        // Act
        Recipe domain = mapper.entityToDomain(entity);

        // Assert
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(domain.getName()).isEqualTo("Pasta");
        softly.assertThat(domain.getDescription()).isEqualTo("Lecker");
        softly.assertThat(domain.getImageUrl()).isEqualTo("pasta.jpg");
        softly.assertThat(domain.getIngredients()).hasSize(1);
        softly.assertThat(domain.getIngredients().get(0).getName()).isEqualTo("Tomate");
        softly.assertThat(domain.getIngredients().get(0).getAmount()).isEqualTo(2);
        softly.assertAll();
    }

    @Test
    void domainToEntity_mapsAllFieldsCorrectly() {
        // Arrange
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Zwiebel");
        ingredient.setAmount(1);

        Recipe recipe = new Recipe();
        recipe.setName("Suppe");
        recipe.setDescription("Heiß und würzig");
        recipe.setImageUrl("suppe.jpg");
        recipe.setIngredients(List.of(ingredient));

        // Act
        RecipeEntity entity = mapper.domainToEntity(recipe);

        // Assert
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(entity.getName()).isEqualTo("Suppe");
        softly.assertThat(entity.getDescription()).isEqualTo("Heiß und würzig");
        softly.assertThat(entity.getImageUrl()).isEqualTo("suppe.jpg");
        softly.assertThat(entity.getIngredients()).hasSize(1);
        softly.assertThat(entity.getIngredients().get(0).getName()).isEqualTo("Zwiebel");
        softly.assertThat(entity.getIngredients().get(0).getAmount()).isEqualTo(1);
        softly.assertAll();
    }
}
