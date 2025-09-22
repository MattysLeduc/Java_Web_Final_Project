package com.polymtl.spring_boot_library.service.impl;

import com.polymtl.spring_boot_library.dto.RecipeDto;
import com.polymtl.spring_boot_library.entity.Recipe;
import com.polymtl.spring_boot_library.exception.ResourceNotFoundException;
import com.polymtl.spring_boot_library.mapper.RecipeMapper;
import com.polymtl.spring_boot_library.repository.RecipeRepository;
import com.polymtl.spring_boot_library.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    @Override
    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = RecipeMapper.mapToRecipe(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return RecipeMapper.mapToRecipeDto(savedRecipe);
    }

    @Override
    public RecipeDto getRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + recipeId));
        return RecipeMapper.mapToRecipeDto(recipe);
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map((recipe -> RecipeMapper.mapToRecipeDto(recipe))).collect(Collectors.toList());
    }

    @Override
    public RecipeDto updateRecipe(Long recipeId, RecipeDto updatedRecipe) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + recipeId));

        recipe.setName(updatedRecipe.getName());
        recipe.setDescription(updatedRecipe.getDescription());
        recipe.setImage(updatedRecipe.getImage());

        Recipe updateRecipeObj = recipeRepository.save(recipe);

        return RecipeMapper.mapToRecipeDto(updateRecipeObj);
    }

    @Override
    public void deleteRecipe(Long recipeId) {

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + recipeId));

        recipeRepository.deleteById(recipeId);
    }
}
