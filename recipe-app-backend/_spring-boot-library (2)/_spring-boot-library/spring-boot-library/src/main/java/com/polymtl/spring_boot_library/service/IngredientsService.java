package com.polymtl.spring_boot_library.service;

import com.polymtl.spring_boot_library.dto.IngredientsDto;

import java.util.List;

public interface IngredientsService {

    IngredientsDto createIngredient(IngredientsDto ingredientsDto);

    IngredientsDto getIngredientById(Long ingredientId);

    List<IngredientsDto> getAllIngredients();

    IngredientsDto updateIngredient(Long ingredientId, IngredientsDto ingredientsDto);

    void deleteIngredient(Long ingredientId);

    List<IngredientsDto> getAllIngredientsByRecipeId(Long recipeId);
}
