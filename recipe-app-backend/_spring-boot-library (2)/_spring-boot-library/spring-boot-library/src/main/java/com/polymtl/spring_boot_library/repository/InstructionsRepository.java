package com.polymtl.spring_boot_library.repository;

import com.polymtl.spring_boot_library.entity.Ingredients;
import com.polymtl.spring_boot_library.entity.Instructions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructionsRepository extends JpaRepository<Instructions, Long> {
    List<Instructions> findInstructionsByRecipeId(Long id);
}
