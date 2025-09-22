import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../images/logo.jpg';
import './NavBar.css';

const Navbar: React.FC = () => {
  const handleNavLinkClick = () => {
    // This will manually collapse the navbar when an item is clicked
    const navbarCollapse = document.getElementById('navbarNav');
    if (navbarCollapse && navbarCollapse.classList.contains('show')) {
      navbarCollapse.classList.remove('show');
    }
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/"><img src={logo} alt="Recipe App Logo" /></Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav">
            <li className="nav-item">
              <Link className="nav-link" to="/" onClick={handleNavLinkClick}>Home</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/Recipes" onClick={handleNavLinkClick}>All Recipes</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/About" onClick={handleNavLinkClick}>About</Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
