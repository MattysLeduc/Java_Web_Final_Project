package com.polymtl.spring_boot_library.service;

import com.polymtl.spring_boot_library.dto.IngredientsDto;
import com.polymtl.spring_boot_library.dto.InstructionsDto;

import java.util.List;

public interface InstructionsService {

    InstructionsDto createInstruction(InstructionsDto instructionsDto);

    InstructionsDto getInstructionById(Long instructionId);

    List<InstructionsDto> getAllInstructions();

    InstructionsDto updateInstruction(Long instructionId, InstructionsDto instructionsDto);

    void deleteInstruction(Long instructionId);

    List<InstructionsDto> getAllInstructionsByRecipeId(Long recipeId);
}
