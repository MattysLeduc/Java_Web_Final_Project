package com.polymtl.spring_boot_library.controller;

import com.polymtl.spring_boot_library.dto.RecipeDto;
import com.polymtl.spring_boot_library.entity.Recipe;
import com.polymtl.spring_boot_library.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;

    // Build Add Recipe REST API
    @PostMapping
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {
        RecipeDto savedRecipe = recipeService.createRecipe(recipeDto);
        return new ResponseEntity<>(savedRecipe, HttpStatus.CREATED);
    }

    // Build Get Recipe REST API
    @GetMapping("{id}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable("id") Long recipeId) {
        RecipeDto recipeDto = recipeService.getRecipeById(recipeId);
        return ResponseEntity.ok(recipeDto);
    }

    // Build Get All Recipe REST API
    @GetMapping
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        List<RecipeDto> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    // Build Update Recipe REST API
    @PutMapping("{id}")
    public ResponseEntity<RecipeDto> updateRecipe(@PathVariable("id") Long recipeId,@RequestBody RecipeDto updateRecipe) {
        RecipeDto recipeDto = recipeService.updateRecipe(recipeId, updateRecipe);
        return ResponseEntity.ok(recipeDto);
    }

    // Build Delete Recipe REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable("id") Long recipeId) {
        recipeService.deleteRecipe(recipeId);
        return ResponseEntity.ok("Recipe deleted successfully");
    }
}
