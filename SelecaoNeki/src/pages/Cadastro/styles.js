import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  position: absolute;
  width: 100%;
  height: auto;
  padding: calc((80vw - 1000px) / 2);
  align-items: center;
  flex-direction: column;
  justify-content: space-around;
  color: #333;

  img {
    display: flex;
    margin-top: 10px;
    align-items: center;
  }

  @media screen and (max-width: 960px) {
    width: 80%;
  }
`;

export const Div = styled.div`
  width: 70%;

  @media screen and (max-width: 960px) {
    width: 50%;
  }
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

export const Title = styled.h2`
  display: flex;
  margin-top: 10px;
  margin-bottom: 20px;
  color: #11acd3;
  font-size: x-large;
`;

export const Div1 = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
  margin-bottom: 15px;
  margin-top: 10px;

  @media screen and (max-width: 960px) {
    flex-direction: column;
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

export const Div3 = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 50px;
  margin-bottom: 15px;
  width: 100%;

  @media screen and (max-width: 960px) {
    flex-direction: column;
  }
`;

export const Div6 = styled.div`
  display: flex;
  width: 100%;
  justify-content: center;
`;

export const SendButton = styled.button`
  display: flex;
  justify-content: center;
  background-color: #11acd3;
  border: none;
  border-radius: 20px;
  margin-top: 40px;
  width: 180px;
  height: 40px;
  font-size: small;
  font-weight: 520;
  color: white;
  cursor: pointer;
  padding-top: 10px;
  &:hover {
    background-color: #115555;
  }
`;
