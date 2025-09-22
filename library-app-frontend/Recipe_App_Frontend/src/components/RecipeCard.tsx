import React, { useState } from 'react';
import chococake from '../images/chocolate-cake.jpg';
import cupcake from '../images/Vanilla-Cupcake.jpg';
import cheeseCake from '../images/Strawberry-cheesecake.jpg';
import lemonPie from '../images/Lemon-Pie.jpg';
import bananaBread from '../images/banana-bread.jpg';
import applePie from '../images/Apple-Pie.jpg';
import chickenAlfred from '../images/Chicken-Alfredo.jpg';
import spaghetti from '../images/Spaghetti-Bolognese.jpg';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import './RecipeCard.css'


const recipeImages: { [key: string]: string } = {
  'Chocolate Cake': chococake,
  'Vanilla Cupcake': cupcake,
  'Strawberry Cheesecake': cheeseCake,
  'Lemon Meringue Pie': lemonPie,
  'Banana Bread': bananaBread,
  'Apple Pie': applePie,
  'Chicken Alfredo': chickenAlfred,
  'Spaghetti Bolognese': spaghetti,
};

// Define the types for the recipe prop
interface Recipe {
  name: string;
  description: string;
  image: string;
}

// Define the types for the ingredients and instructions props
interface RecipeCardProps {
  recipe: Recipe;
  ingredients: { name: string; quantity: string }[];
  instructions: { stepNumber: number; instructionText: string }[];
}

const RecipeCard: React.FC<RecipeCardProps> = ({ recipe, ingredients, instructions }) => {
  const [isModalOpen, setIsModalOpen] = useState<boolean>(false);
  const [showIngredients, setShowIngredients] = useState<boolean>(true);

  const toggleModal = (): void => setIsModalOpen(!isModalOpen);
  const toggleSection = (): void => setShowIngredients(!showIngredients);

  // Get the image for the recipe using the recipe name
  const imageURL = recipeImages[recipe.name];

  return (
    <div className="card h-100" style={{marginBottom: '20px'}}>
  <div className="d-flex">
    <img 
      src={imageURL} 
      className="card-img-top" 
      alt={recipe.name} 
      style={{
        maxWidth: '150px',  // Adjust the max width to make the image smaller
        height: 'auto',     // Maintain aspect ratio
        marginRight: '20px', // Adds spacing between the image and text
      }} 
    />
    <div>
      <div className="card-body">
        <h5 className="card-title">{recipe.name}</h5>
        <p className="card-text">{recipe.description}</p>

        {/* View Recipe Button */}
        <button className="btn " style={{backgroundColor: 'black', color: 'white', borderBlockColor: 'black'}} onClick={toggleModal}>
          View Recipe
        </button>
      </div>
    </div>
  </div>

  {/* Modal */}
  {isModalOpen && (
    <>
    <div
      className="modal-backdrop show"
      style={{
        backgroundColor: 'rgba(0, 0, 0, 0.7)',
        zIndex: 1040,
        position: 'fixed',
        top: 0,
        left: 0,
        width: '100%',
        height: '100%',
      }}
    ></div>
    <div className="modal show" tabIndex={-1} style={{ display: 'block', top: '20%' }}>
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">{recipe.name}</h5>
            <button type="button" className="close" onClick={toggleModal}>
              <span>&times;</span>
            </button>
          </div>
          <div className="modal-body">
            {/* Toggle between Ingredients and Instructions */}
            <h6>Details</h6>
            <p>{recipe.description}</p>

            <div>
              {showIngredients ? (
                <>
                  <h6>Ingredients</h6>
                  <ul>
                    {ingredients.map((ingredient, index) => (
                      <li key={index}>
                        {ingredient.name}: {ingredient.quantity}
                      </li>
                    ))}
                  </ul>
                </>
              ) : (
                <>
                  <h6>Instructions</h6>
                  <ol>
                    {instructions
                      .sort((a, b) => a.stepNumber - b.stepNumber)
                      .map((instruction) => (
                        <li key={instruction.stepNumber}>
                          {instruction.instructionText}
                        </li>
                      ))}
                  </ol>
                </>
              )}
            </div>
          </div>
          <div className="modal-footer">
            <button className="btn btn-secondary" onClick={toggleSection}>
              {showIngredients ? 'Show Instructions' : 'Show Ingredients'}
            </button>
            <button className="btn btn-primary" onClick={toggleModal}>
              Close
            </button>
          </div>
        </div>
      </div>
    </div>
    </>
  )}
</div>

  );
};

export default RecipeCard;
