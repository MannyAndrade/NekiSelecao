import styled from "styled-components";
import { NavLink as Link } from "react-router-dom";
import { FaBars } from "react-icons/fa";

export const Nav = styled.nav`
  background: #fff;
  height: auto;
  display: flex;
  justify-content: space-between;
  padding: 0.8rem calc((90vw - 1000px) / 2);
  z-index: 1;
  border-bottom: 1px solid #ccc;
  align-items: center;
`;

export const NavLink = styled(Link)`
  color: #2e5499;
  display: flex;
  align-items: center;
  text-decoration: none;
  padding: 0 1rem;
  height: 100%;
  cursor: pointer;
  font-weight: 600;
  flex-grow: 1;

  /* &.active {
        color: #15cdfc;
    } */
`;

export const Bars = styled(FaBars)`
  display: none;
  color: #2e5499;

  @media screen and (max-width: 768px) {
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(-100%, 75%);
    font-size: 1.8rem;
    cursor: pointer;
  }
`;

export const NavMenu = styled.div`
  display: flex;
  align-items: center;
  flex-grow: 1;

  @media screen and (max-width: 768px) {
    display: none;
  }
`;

export const NavBtn = styled.nav`
  display: flex;
  align-items: center;
  margin-right: 24px;
  flex-grow: 8;
  justify-content: flex-end;

  @media screen and (max-width: 768px) {
    display: none;
  }
`;

export const NavBtnLink = styled(Link)`
  border-radius: 30px;
  background: #2e5499;
  padding: 10px 50px;
  color: #fff;
  border: none;
  outline: none;
  cursor: pointer;
  transition: all 0.2s ease-in-out;
  text-decoration: none;

  /* margin-left: 24px; */

  &:hover {
    transition: all 0.2s ease-in-out;
    background: #587fc7;
  }
`;
