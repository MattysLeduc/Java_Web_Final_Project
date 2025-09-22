package com.polymtl.spring_boot_library.service;

import com.polymtl.spring_boot_library.dto.IngredientsDto;
import com.polymtl.spring_boot_library.dto.RecipeDto;
import com.polymtl.spring_boot_library.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RecipeService {

    RecipeDto createRecipe(RecipeDto recipeDto);

    RecipeDto getRecipeById(Long recipeId);

    List<RecipeDto> getAllRecipes();

    RecipeDto updateRecipe(Long recipeId, RecipeDto recipeDto);

    void deleteRecipe(Long recipeId);


}
