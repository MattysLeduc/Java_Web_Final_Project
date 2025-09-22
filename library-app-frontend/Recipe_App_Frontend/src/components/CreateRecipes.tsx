import React, { useEffect, useState } from 'react';
import { listRecipes } from '../services/RecipeService'; 
import { listIngredients } from '../services/IngredientService'; 
import { listInstructions } from '../services/InstructionService'; 
import RecipeCard from './RecipeCard';

interface Recipe {
  id: number;
  name: string;
  description: string;
  image: string;
}

const CreateRecipes: React.FC = () => {
  const [recipes, setRecipes] = useState<Recipe[]>([]);
  const [ingredients, setIngredients] = useState<any[]>([]);
  const [instructions, setInstructions] = useState<any[]>([]);

  useEffect(() => {
    Promise.all([listRecipes(), listIngredients(), listInstructions()])
      .then(([recipeResponse, ingredientResponse, instructionResponse]) => {
        setRecipes(recipeResponse.data);
        setIngredients(ingredientResponse.data);
        setInstructions(instructionResponse.data);
      })
      .catch((error) => console.error(error));
  }, []);

  return (
    <div className="container">
      <h2 className="text-center" style={{marginBottom: '15px', marginTop: '15px'}}>List of Recipes</h2>
      <div className="recipes-container">
        {recipes.map((recipe) => (
          <div key={recipe.id} className="recipe-card">
            <RecipeCard 
              recipe={recipe}
              ingredients={ingredients.filter(ingredient => ingredient.recipeId === recipe.id)}
              instructions={instructions.filter(instruction => instruction.recipeId === recipe.id)} 
            />
          </div>
        ))}
      </div>
    </div>
  );
};

export default CreateRecipes;
