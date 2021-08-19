import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import axios from "axios";
import { login, getcode } from "../../services/auth";
import { Container } from "./styles";
import { DivPerfil, Botao } from "./styles";
import { logout } from "../../storage";


class SignIn extends Component {
  state = {
    email: "",
    senha: "",
    error: "",
  };

  handleSignIn = async (e) => {
    e.preventDefault();
    const { email, senha } = this.state;
    if (!email || !senha) {
      this.setState({ error: "Preencha e-mail e senha para continuar!" });
    } else {
      try {
        const response = await axios.post(
          "http://localhost:8080/usuario/login",
          { email, senha }
        );
        // console.log('Data.token: ' + JSON.stringify(response.data))
        console.log("Auth: " + response.data.token);
        login(response.data.token);
        getcode(response.data.codigoUsuario);

        this.props.history.push("/inicio");
      } catch (err) {
        this.setState({
          error:
            "Houve um problema com o login, verifique suas credenciais. T.T",
        });
      }
    }
    setTimeout(() => {
      window.location.reload();
    });
  };

  render() {
    return (
      <Container>
       
        <DivPerfil>
          <h1>Habilidades</h1>
          
        </DivPerfil>

        <Link to="/">
          <Botao type="submit" onClick={logout}>
            Sair
          </Botao>
        </Link>
      </Container>
    );
  }
}

export default withRouter(SignIn);
