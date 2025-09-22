package com.polymtl.spring_boot_library.dto;

import com.polymtl.spring_boot_library.entity.Recipe;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstructionsDto {
    private Long instructionId;
    private int recipeId;
    private int stepNumber;
    private String instructionText;
}
