package com.polymtl.spring_boot_library.service.impl;

import com.polymtl.spring_boot_library.dto.InstructionsDto;
import com.polymtl.spring_boot_library.entity.Instructions;
import com.polymtl.spring_boot_library.exception.ResourceNotFoundException;
import com.polymtl.spring_boot_library.mapper.InstructionsMapper;
import com.polymtl.spring_boot_library.repository.InstructionsRepository;
import com.polymtl.spring_boot_library.service.InstructionsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstructionsServiceImpl implements InstructionsService {

    private InstructionsRepository instructionsRepository;

    @Override
    public InstructionsDto createInstruction(InstructionsDto instructionsDto) {
        Instructions instructions = InstructionsMapper.mapToInstructions(instructionsDto);
        Instructions savedInstructions = instructionsRepository.save(instructions);
        return InstructionsMapper.mapToInstructionsDto(savedInstructions);
    }

    @Override
    public InstructionsDto getInstructionById(Long instructionId) {
        Instructions instructions = instructionsRepository.findById(instructionId)
                .orElseThrow(() -> new ResourceNotFoundException("Instruction not found with id: " + instructionId));
        return InstructionsMapper.mapToInstructionsDto(instructions);
    }

    @Override
    public List<InstructionsDto> getAllInstructions() {
        List<Instructions> instructions = instructionsRepository.findAll();
        return instructions.stream()
                .map(InstructionsMapper::mapToInstructionsDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InstructionsDto> getAllInstructionsByRecipeId(Long recipeId) {
        List<Instructions> instructions = instructionsRepository.findInstructionsByRecipeId(recipeId);
        return instructions.stream()
                .map(InstructionsMapper::mapToInstructionsDto)
                .collect(Collectors.toList());
    }

    @Override
    public InstructionsDto updateInstruction(Long instructionId, InstructionsDto instructionsDto) {
        Instructions instructions = instructionsRepository.findById(instructionId)
                .orElseThrow(() -> new ResourceNotFoundException("Instruction not found with id: " + instructionId));

        instructions.setRecipeId(instructionsDto.getRecipeId());
        instructions.setStepNumber(instructionsDto.getStepNumber());
        instructions.setInstructionText(instructionsDto.getInstructionText());

        Instructions updateInstructionsObj = instructionsRepository.save(instructions);

        return InstructionsMapper.mapToInstructionsDto(updateInstructionsObj);
    }

    @Override
    public void deleteInstruction(Long instructionId) {
        Instructions instructions = instructionsRepository.findById(instructionId)
                .orElseThrow(() -> new ResourceNotFoundException("Instruction not found with id: " + instructionId));
        instructionsRepository.deleteById(instructionId);
    }

}
