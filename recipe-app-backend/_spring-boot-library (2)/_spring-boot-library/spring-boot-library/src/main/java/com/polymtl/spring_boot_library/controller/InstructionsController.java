package com.polymtl.spring_boot_library.controller;

import com.polymtl.spring_boot_library.dto.InstructionsDto;
import com.polymtl.spring_boot_library.entity.Instructions;
import com.polymtl.spring_boot_library.service.InstructionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/instructions")
public class InstructionsController {

    private InstructionsService instructionsService;

    @PostMapping
    public ResponseEntity<InstructionsDto> create(@RequestBody InstructionsDto instructionsDto) {
        InstructionsDto savedinstructions = instructionsService.createInstruction(instructionsDto);
        return new ResponseEntity<>(savedinstructions, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<InstructionsDto> getInstructionById(@PathVariable("id") Long instructionId) {
        InstructionsDto instructionsDto = instructionsService.getInstructionById(instructionId);
        return ResponseEntity.ok(instructionsDto);
    }

    @GetMapping
    public ResponseEntity<List<InstructionsDto>> getAllInstructions() {
        List<InstructionsDto> instructionsDtos = instructionsService.getAllInstructions();
        return ResponseEntity.ok(instructionsDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<InstructionsDto> updateInstruction(@PathVariable("id") Long instructionId, @RequestBody InstructionsDto updateInstruction) {
        InstructionsDto instructionsDto = instructionsService.updateInstruction(instructionId, updateInstruction);
        return ResponseEntity.ok(instructionsDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInstruction(@PathVariable("id") Long instructionId) {
        instructionsService.deleteInstruction(instructionId);
        return ResponseEntity.ok("Instruction deleted successfully");
    }
}
