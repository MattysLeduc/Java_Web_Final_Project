import React from 'react';
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
import './carousel.css';

const ImageCarousel: React.FC = () => {
  const images = [chococake, cupcake, cheeseCake, lemonPie, bananaBread, applePie, chickenAlfred, spaghetti];

  return (
    <div id="recipeCarousel" className="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
      <div className="carousel-inner">
        {images.map((image, index) => (
          <div className={`carousel-item ${index === 0 ? 'active' : ''}`} key={index}>
            <img src={image} alt={`Slide ${index + 1}`} className="d-block" />
          </div>
        ))}
      </div>
      <button
        className="carousel-control-prev"
        type="button"
        data-bs-target="#recipeCarousel"
        data-bs-slide="prev"
      >
        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Previous</span>
      </button>
      <button
        className="carousel-control-next"
        type="button"
        data-bs-target="#recipeCarousel"
        data-bs-slide="next"
      >
        <span className="carousel-control-next-icon" aria-hidden="true"></span>
        <span className="visually-hidden">Next</span>
      </button>
    </div>
  );
};

export default ImageCarousel;
