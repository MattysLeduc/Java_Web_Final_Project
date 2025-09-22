package com.polymtl.spring_boot_library.controller;


import com.polymtl.spring_boot_library.dto.IngredientsDto;
import com.polymtl.spring_boot_library.service.IngredientsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/ingredients")
public class IngredientsController {


    private IngredientsService ingredientsService;

    // Build Add Ingredient REST API
    @PostMapping
    public ResponseEntity<IngredientsDto> createIngredients(@RequestBody IngredientsDto ingredientsDto) {

        IngredientsDto savedIngredient = ingredientsService.createIngredient(ingredientsDto);
        return new ResponseEntity<>(savedIngredient, HttpStatus.CREATED);
    }

    // Build Get Ingredient REST API
    @GetMapping("{id}")
    public ResponseEntity<IngredientsDto> getIngredientsById(@PathVariable("id") Long ingredientId) {
        IngredientsDto ingredientsDto = ingredientsService.getIngredientById(ingredientId);
        return ResponseEntity.ok(ingredientsDto);
    }

    @GetMapping("/{recipeId}/ingredients")
    public ResponseEntity<List<IngredientsDto>> getIngredientsByRecipeId(@PathVariable Long recipeId) {
        List<IngredientsDto> ingredients = ingredientsService.getAllIngredientsByRecipeId(recipeId);
        return ResponseEntity.ok(ingredients);
    }

        // Build Get All Recipe REST API
        @GetMapping
        public ResponseEntity<List<IngredientsDto>> getALLIngredients () {
            List<IngredientsDto> ingredients = ingredientsService.getAllIngredients();
            return ResponseEntity.ok(ingredients);
        }

        // Build Update Ingredient REST API
        @PutMapping("{id}")
        public ResponseEntity<IngredientsDto> updateIngredient (@PathVariable("id") Long
        ingredientId, @RequestBody IngredientsDto updateIngredient){
            IngredientsDto ingredientsDto = ingredientsService.updateIngredient(ingredientId, updateIngredient);
            return ResponseEntity.ok(ingredientsDto);
        }

        // Build Delete Ingredient REST API
        @DeleteMapping("{id}")
        public ResponseEntity<String> deleteIngredient (@PathVariable("id") Long ingredientId){
            ingredientsService.deleteIngredient(ingredientId);
            return ResponseEntity.ok("Ingredient deleted successfully");
        }

    }

