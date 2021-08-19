import React, { useState } from "react";
import { Link } from "react-router-dom";
import { Form, Container } from "./styles";


const SignUp = () => {
  

  return (
    <Container>
      <Form>
        <h1>CRIE SEU PERFIL</h1>
        
          <Link to="/cadastro">
            <button type="button">Cadastrar</button>
          </Link>
       
       
        <hr />
        <Link to="/signin">Faça seu Login</Link>
      </Form>
    </Container>
  );
};
export default SignUp;

