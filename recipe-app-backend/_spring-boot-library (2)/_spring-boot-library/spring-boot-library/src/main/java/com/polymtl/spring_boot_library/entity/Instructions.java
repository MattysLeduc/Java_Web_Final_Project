package com.polymtl.spring_boot_library.entity;

import com.polymtl.spring_boot_library.dto.RecipeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "instructions")
public class Instructions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instruction_id")
    private Long instructionId;


    @Column(name = "recipe_id",nullable = false)
    private int recipeId;

    @Column(name = "step_number", nullable = false)
    private int stepNumber;

    @Column(name = "instruction_text", columnDefinition = "TEXT", nullable = false)
    private String instructionText;
}
