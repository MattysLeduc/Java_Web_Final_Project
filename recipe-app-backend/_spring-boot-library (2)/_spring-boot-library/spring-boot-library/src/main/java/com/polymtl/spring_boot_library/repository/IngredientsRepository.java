package com.polymtl.spring_boot_library.repository;

import com.polymtl.spring_boot_library.entity.Ingredients;
import com.polymtl.spring_boot_library.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

    List<Ingredients> findIngredientsByRecipeId(Long id);
}
