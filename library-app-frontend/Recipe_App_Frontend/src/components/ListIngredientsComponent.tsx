import React, { useEffect, useState } from 'react';
import { listIngredients } from '../services/IngredientService';

interface Ingredient {
  id: number;
  recipeId: number;
  name: string;
  quantity: string;
}

const ListIngredientsComponent: React.FC = () => {
  const [ingredients, setIngredients] = useState<Record<number, Ingredient[]>>({});

  useEffect(() => {
    listIngredients()
      .then((response) => {
        const groupedIngredients = response.data.reduce((acc: Record<number, Ingredient[]>, ingredient: Ingredient) => {
          if (!acc[ingredient.recipeId]) {
            acc[ingredient.recipeId] = [];
          }
          acc[ingredient.recipeId].push(ingredient);
          return acc;
        }, {});

        setIngredients(groupedIngredients);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  return (
    <div className="container">
      <h2 className="text-center">List of Ingredients</h2>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Ingredient ID</th>
            <th>Ingredient Name</th>
            <th>Ingredient Quantity</th>
            <th>Recipe ID</th>
          </tr>
        </thead>
        <tbody>
          {Object.keys(ingredients).map((recipeId) => (
            <React.Fragment key={recipeId}>
              <tr>
                <td colSpan={4} style={{ backgroundColor: '#f2f2f2', fontWeight: 'bold' }}>
                  Recipe ID: {recipeId}
                </td>
              ```tsx
              </tr>
              {ingredients[parseInt(recipeId)].map((ingredient) => (
                <tr key={ingredient.id}>
                  <td>{ingredient.id}</td>
                  <td>{ingredient.name}</td>
                  <td>{ingredient.quantity}</td>
                  <td>{ingredient.recipeId}</td>
                </tr>
              ))}
            </React.Fragment>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListIngredientsComponent;