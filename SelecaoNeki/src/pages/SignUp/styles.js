import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-around;
  height: 80vh;
  padding: calc((80vw - 1000px) / 2);
`;

export const Form = styled.form`
  width: 320px;
  background: #fff;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 1px solid #ccc;
  border-radius: 20px;
  h1 {
    margin: 10px 0 20px;
    color: #11acd3;
  }

  p {
    color: #ff3333;
    margin-bottom: 15px;
    border: 1px solid #ff3333;
    padding: 10px;
    width: 100%;
    text-align: center;
  }

  input {
    flex: 1;
    height: auto;
    margin-bottom: 15px;
    padding: 10px 20px;
    color: #777;
    font-size: 15px;
    width: 100%;
    &::placeholder {
      color: #999;
    }
  }
  button {
    color: #fff;
    font-size: 16px;
    background: #11acd3;
    height: 55px;
    border: 0;
    border-radius: 40px;
    width: 200px;
    cursor: pointer;

    &:hover {
      background: #587ab9;
    }
  }
  hr {
    margin: 20px 0;
    border: none;
    border-bottom: 1px solid #cdcdcd;
    width: 100%;
  }
  a {
    font-size: 16;
    font-weight: bold;
    color: #111;
    text-decoration: none;
  }

  @media screen and (max-width: 960px) {
    border: none;
  }
`;

export const View = styled.form`
  @media screen and (max-width: 960px) {
    display: none;
  }
`;

export const Div = styled.div`
  margin-top: 15px;
  display: flex;
  flex-direction: column;

  h6 {
    color: #11acd3;
    margin-bottom: 5px;
  }
`;
