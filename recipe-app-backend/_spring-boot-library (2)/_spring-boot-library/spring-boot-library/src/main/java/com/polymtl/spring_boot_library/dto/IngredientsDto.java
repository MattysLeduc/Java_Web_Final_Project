package com.polymtl.spring_boot_library.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientsDto {
    private Long id;
    private String name;
    private String quantity;
    private Long recipeId;
}
