import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import axios from "axios";
import api from "../../services/api";
import { login, getcode } from "../../services/auth";
import { Form, Container, View } from "./styles";
import { DivMostrarSenha } from "./styles";

// const mostrarOcultarSenha = () =>{
//   var senha=document.getElementById("exampleInputEmail1");
//   // senha.type = (senha.type == "password") ? "text" : "password";
//   if(senha.type=="password"){
//   senha.type="text";
//   }else{
//   senha.type="password";
//   }
// };

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
          "http://127.0.0.1:8050/usuario/login",
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
        <Form onSubmit={this.handleSignIn}>
          <h1>LOGIN</h1>
          {this.state.error && <p>{this.state.error}</p>}
          <form>
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">
                Email
              </label>
              <input
                required
                type="text"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Email"
                onChange={(e) => this.setState({ email: e.target.value })}
              />
            </div>
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">
                Senha
              </label>
              <input
                required
                type="password"
                class="form-control"
                id="exampleInputEmail1"
                aria-describedby="emailHelp"
                placeholder="Senha"
                onChange={(e) => this.setState({ senha: e.target.value })}
              />

              <DivMostrarSenha>
                <label for="mostrarSenha" class="form-label">
                  Mostrar Senha
                </label>

                <input
                  type="checkbox"
                  class="form-control"
                  id="mostrarSenha"
                  // aria-describedby="emailHelp"
                  // placeholder="Senha"
                  onClick={"mostrarOcultarSenha()"}
                />
              </DivMostrarSenha>
            </div>
          </form>
          <button type="submit">Entrar</button>
          <Link to="/recuperarsenha">
            <h6>Esqueceu sua senha?</h6>
          </Link>
          <hr />
          <Link to="/signup">Criar seu perfil</Link>
        </Form>
      </Container>
    );
  }
}

export default withRouter(SignIn);
