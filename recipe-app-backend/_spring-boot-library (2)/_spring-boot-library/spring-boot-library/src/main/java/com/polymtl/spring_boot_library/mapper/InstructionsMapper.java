package com.polymtl.spring_boot_library.mapper;

import com.polymtl.spring_boot_library.dto.IngredientsDto;
import com.polymtl.spring_boot_library.dto.InstructionsDto;
import com.polymtl.spring_boot_library.entity.Ingredients;
import com.polymtl.spring_boot_library.entity.Instructions;

public class InstructionsMapper {
    public static InstructionsDto mapToInstructionsDto(Instructions instructions) {
        return new InstructionsDto(
                instructions.getInstructionId(),
                instructions.getRecipeId(),
                instructions.getStepNumber(),
                instructions.getInstructionText()// Assuming `recipe` is a relationship in the Instructions entity
        );
    }

    // Maps an InstructionsDto to an Instructions entity
    public static Instructions mapToInstructions(InstructionsDto instructionsDto) {
        return new Instructions(
                instructionsDto.getInstructionId(),
                instructionsDto.getRecipeId(),
                instructionsDto.getStepNumber(),
                instructionsDto.getInstructionText() // Assuming Recipe constructor takes an ID
        );
    }
}
