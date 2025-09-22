package com.polymtl.spring_boot_library.mapper;

import com.polymtl.spring_boot_library.dto.RecipeDto;
import com.polymtl.spring_boot_library.entity.Recipe;

public class RecipeMapper {

    public static RecipeDto mapToRecipeDto(Recipe recipe) {
        return new RecipeDto(
                recipe.getId(),
                recipe.getName(),
                recipe.getDescription(),
                recipe.getImage()
        );
    }

    public static Recipe mapToRecipe(RecipeDto recipeDto) {
        return new Recipe(
                recipeDto.getId(),
                recipeDto.getName(),
                recipeDto.getDescription(),
                recipeDto.getImage()
        );
    }
}
