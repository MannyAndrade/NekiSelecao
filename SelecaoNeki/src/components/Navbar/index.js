import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";
import logo from "../../assets/images/logo-neki-oficial-1596x452 (1).png";
import { getToken } from "../../services/auth";

import { FaBars, FaUserAlt } from "react-icons/fa";

import storage from "../../storage";

import { isAuthenticated } from "../../services/auth";

// const keys = storage.deleteKeys();

// function logado() {
//   {keys ? (<Link to='/signin' className='nav-links'>
//   <button className='btn'  onClick={'/signin'}>Acessar</button>
// </Link>) : ( <Link to='/sobre' className='nav-links'>
//           <button className='btn'  onClick={'/sobre'}>Sobre</button>
//         </Link>)
// }
// }

function Navbar(props) {
  // const [isModalVisible, setIsModalVisible] = useState(false);
  const [click, setClick] = useState(false);

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  // const keys = storage.deleteKeys();
  console.log("token:" + props.autenticado);

  function logado() {
    if (!props.autenticado) {
      return (
        <Link to="/signin" className="nav-links">
          <button className="btn-acessar">Acessar</button>
        </Link>
      );
    } else {
      return (
        <Link to="/perfil" className="nav-links">
          <div className="icone">
            <FaUserAlt />
          </div>
        </Link>
      );
    }
  }

  return (
    <>
      <nav className="navbar">
        <div className="logo">
          <Link to="/" className="navbar-logo" onClick={closeMobileMenu}>
            <img width="200" height="50" src={logo} alt="" />
          </Link>
        </div>
      </nav>
    </>
  );
}

export default Navbar;
