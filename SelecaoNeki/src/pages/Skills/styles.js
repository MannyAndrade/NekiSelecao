import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-around;
  height: 80vh;
  padding: calc((80vw - 1000px) / 2);
`;


export const DivPerfil = styled.div`
  border: 1px solid #000;
  height: 300px;
  width: 500px;
  margin-right: 300px;
  margin-top: -60px;
  border-radius: 40px;
  border-color: #aaa;
  background-color: #ddd;
  padding: 50px;
`;

export const DivForm = styled.div`
  display: flex;
  flex-direction: column;

  input {
    height: 40px;
    width: 155%;
    padding: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
`;

export const Div2 = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
  margin-top: 10px;

  @media screen and (max-width: 960px) {
    flex-direction: column;
  }
`;

export const Botao = styled.button`
  background-color: unset;
  width: 160px;
  height: 40px;
  margin-top: 30px;
  text-decoration: none;
  padding: 05px 15px;
  margin-right: 400px;
  border-radius: 30px;
  outline: none;
  border: 1px solid darkblue;
  font-size: 12px;
  cursor: pointer;
  background-color: white;
  color: darkblue;
  transition: all 0.4s ease-out;
  &:hover {
    background-color: lightgray;
  }
`;
