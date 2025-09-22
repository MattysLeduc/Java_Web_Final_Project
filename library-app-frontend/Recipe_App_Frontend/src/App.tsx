import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/NavBar';
import Footer from './components/Footer';
import CreateRecipes from './components/CreateRecipes';
import HomePage from './components/HomePage';
import AboutPage from './components/AboutPage';


const App: React.FC = () => {

  return (
    <Router>
      <div className="d-flex flex-column min-vh-100">
        <Navbar />
        <main className="flex-grow-1">
          <Routes>
            <Route path="/" element={<HomePage/>} />
            <Route path="/Recipes" element={<CreateRecipes />} />
            <Route path="/About" element={<AboutPage/>} />
          </Routes>
        </main>
        <Footer />
      </div>
    </Router>
  );
};

export default App;