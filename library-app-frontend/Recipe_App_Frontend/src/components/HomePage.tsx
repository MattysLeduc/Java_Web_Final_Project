import React from 'react';
import { Link } from 'react-router-dom';
import ImageCarousel from './Carousel'; // Import your carousel component
import 'bootstrap/dist/css/bootstrap.min.css';

const HomePage: React.FC = () => {
  return (
    <div className="container">
      {/* Title and Introduction */}
      <div className="text-center mt-5">
        <h1>Welcome to the Recipe App</h1>
        <p>
          Explore a variety of delicious recipes. From cakes to savory dishes, discover your next meal inspiration.
        </p>
      </div>

      {/* Carousel */}
      <div className="mt-4">
        <ImageCarousel />
      </div>

      {/* Button to jump to Recipes */}
      <div className="text-center mt-5">
        <Link to="/recipes">
          <button className="btn btn-lg" style={{backgroundColor: 'black', color:'white', borderBlockColor: 'black', marginBottom: '20px'}}>Jump to Recipes</button>
        </Link>
      </div>
    </div>
  );
};

export default HomePage;
