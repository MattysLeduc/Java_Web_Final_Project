package com.polymtl.spring_boot_library.mapper;

import com.polymtl.spring_boot_library.dto.IngredientsDto;
import com.polymtl.spring_boot_library.dto.RecipeDto;
import com.polymtl.spring_boot_library.entity.Ingredients;
import com.polymtl.spring_boot_library.entity.Recipe;

public class IngredientsMapper {

    public static IngredientsDto mapToIngredientDto(Ingredients ingredient) {
        return new IngredientsDto(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getQuantity(),
                ingredient.getRecipeId()
        );
    }

    // Maps an IngredientsDto to an Ingredients entity
    public static Ingredients mapToIngredient(IngredientsDto ingredientDto) {
        return new Ingredients(
                ingredientDto.getId(),
                ingredientDto.getName(),
                ingredientDto.getQuantity(),
                ingredientDto.getRecipeId()
        );
    }
}
