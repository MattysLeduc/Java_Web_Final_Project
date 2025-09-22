import React, { useEffect, useState } from 'react';
import { listRecipes } from '../services/RecipeService';
import './ListRecipeComponent.css';

interface Recipe {
  id: number;
  name: string;
  description: string;
  image: string;
}

const ListRecipeComponent: React.FC = () => {
  const [recipes, setRecipes] = useState<Recipe[]>([]);

  useEffect(() => {
    listRecipes()
      .then((response) => {
        setRecipes(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="container-fluid">
      <h2 className="text-center">List of Recipes</h2>
      <div className="row row-cols-1 row-cols-md-3 g-4">
        {recipes.map((recipe) => (
          <div className="col mb-4" key={recipe.id}>
            <div className="recipe-box">
              <img
                src={`http://localhost:8080/api/recipes/${recipe.image}`}
                alt={recipe.name}
                className="recipe-image"
              />
              <div className="recipe-details">
                <h5 className="recipe-name">{recipe.name}</h5>
                <p className="recipe-description">{recipe.description}</p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ListRecipeComponent;