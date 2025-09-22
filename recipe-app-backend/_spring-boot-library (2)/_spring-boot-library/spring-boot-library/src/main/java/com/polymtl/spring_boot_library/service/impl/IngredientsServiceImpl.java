package com.polymtl.spring_boot_library.service.impl;

import com.polymtl.spring_boot_library.dto.IngredientsDto;
import com.polymtl.spring_boot_library.dto.RecipeDto;
import com.polymtl.spring_boot_library.entity.Ingredients;
import com.polymtl.spring_boot_library.entity.Recipe;
import com.polymtl.spring_boot_library.exception.ResourceNotFoundException;
import com.polymtl.spring_boot_library.mapper.IngredientsMapper;
import com.polymtl.spring_boot_library.mapper.RecipeMapper;
import com.polymtl.spring_boot_library.repository.IngredientsRepository;
import com.polymtl.spring_boot_library.service.IngredientsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IngredientsServiceImpl implements IngredientsService {

    private IngredientsRepository ingredientsRepository;

    // Create a new ingredient
    @Override
    public IngredientsDto createIngredient(IngredientsDto ingredientsDto) {
        Ingredients ingredient = IngredientsMapper.mapToIngredient(ingredientsDto);
        Ingredients savedIngredient = ingredientsRepository.save(ingredient);
        return IngredientsMapper.mapToIngredientDto(savedIngredient);
    }

    // Get an ingredient by its ID
    @Override
    public IngredientsDto getIngredientById(Long ingredientId) {
        Ingredients ingredient = ingredientsRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with id: " + ingredientId));
        return IngredientsMapper.mapToIngredientDto(ingredient);
    }

    // Get all ingredients
    @Override
    public List<IngredientsDto> getAllIngredients() {
        List<Ingredients> ingredients = ingredientsRepository.findAll();
        return ingredients.stream()
                .map(IngredientsMapper::mapToIngredientDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<IngredientsDto> getAllIngredientsByRecipeId(Long recipeId) {
        List<Ingredients> ingredients = ingredientsRepository.findIngredientsByRecipeId(recipeId);
        return ingredients.stream()
                .map(IngredientsMapper::mapToIngredientDto)
                .collect(Collectors.toList());
    }

    // Update an existing ingredient
    @Override
    public IngredientsDto updateIngredient(Long ingredientId, IngredientsDto ingredientsDto) {
        Ingredients ingredient = ingredientsRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with id: " + ingredientId));

        ingredient.setName(ingredientsDto.getName());
        ingredient.setQuantity(ingredientsDto.getQuantity());

        Ingredients updatedIngredient = ingredientsRepository.save(ingredient);
        return IngredientsMapper.mapToIngredientDto(updatedIngredient);
    }

    // Delete an ingredient
    @Override
    public void deleteIngredient(Long ingredientId) {
        Ingredients ingredient = ingredientsRepository.findById(ingredientId)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with id: " + ingredientId));
        ingredientsRepository.deleteById(ingredientId);
    }
}
