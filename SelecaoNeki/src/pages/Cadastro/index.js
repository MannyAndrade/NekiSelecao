import React from "react";
import { Link } from "react-router-dom";
import { Formik, Field, Form, FastField } from "formik";
import axios from "axios";
import api from "../../services/api";

import {
  Container,
  Div,
  Title,
  Div1,
  Div2,
  Div3,
  Div6,
  DivForm,
  SendButton,
} from "./styles";

import logo from "../../assets/images/Neki-itLogo.png";

function Cadastro() {
  function onSubmit(values, actions) {
    console.log("SUBMIT", values);
    axios.post("http://localhost:8080/usuario/salvar", values);
    // this.props.history.push("/");
  }

  function onBlurCep(ev, setFieldValue) {
    const { value } = ev.target;

    const cep = value?.replace(/[^0-9]/g, "");

    if (cep?.length !== 8) {
      return;
    }

    fetch(`https://viacep.com.br/ws/${cep}/json/`)
      .then((res) => res.json())
      .then((data) => {
        setFieldValue("logradouro", data.logradouro);
        setFieldValue("bairro", data.bairro);
        setFieldValue("cidade", data.localidade);
        setFieldValue("uf", data.uf);
      });
  }

  return (
    <Container>
      <img width="100" height="100" src={logo} alt="Logo Neki-IT" margin="20" />
      <Div>
        <Formik
          onSubmit={onSubmit}
          validateOnMount
          initialValues={{
            cep: "",
            logradouro: "",
            numero: "",
            complemento: "",
            bairro: "",
            cidade: "",
            uf: "",
          }}
          render={({ isValid, setFieldValue }) => (
            <Form>
              {/* <img width="100" height="100" src={logo} alt="Logo da Prefeitura de Teresópolis" /> */}
              <Title>Dados Cadastrais</Title>

              <Div1>
                <DivForm>
                  <label>Nome Completo *</label>
                  <FastField
                    required
                    name="nome"
                    type="text"
                    placeholder="Informe seu nome completo"
                    classeName="teste"
                  />
                </DivForm>

                <DivForm>
                  <label>Data de nascimento *</label>
                  <FastField
                    name="dataNascimento"
                    required
                    id="outlined-date"
                    type="date"
                    variant="outlined"
                  />
                </DivForm>

                <DivForm>
                  <label>CPF *</label>
                  <FastField
                    required
                    name="cpf"
                    type="integer"
                    placeholder="123.456.789-12"
                  />
                </DivForm>
              </Div1>
              <Div2>
                <h3>Skills</h3>
              </Div2>
              <Div2>
                <DivForm>
                  <label>Linguagens 1 *</label>
                  <FastField
                    required
                    name="linguagem1"
                    type="text"
                    placeholder="Java, JS, PHP..."
                  />
                </DivForm>

                <DivForm>
                  <label>Linguagens 2</label>
                  <FastField
                    name="linguagem2"
                    type="text"
                    placeholder="Java, JS, PHP..."
                  />
                </DivForm>

                <DivForm>
                  <label>Linguagens 3</label>
                  <FastField
                    name="linguagem3"
                    type="text"
                    placeholder="Java, JS, PHP..."
                  />
                </DivForm>
              </Div2>

              <Div2>
                <DivForm>
                  <label>Nível de Inglês *</label>
                  <FastField
                    required
                    name="ingles"
                    type="text"
                    placeholder="Básico / Intermediário / Avançado"
                  />
                </DivForm>
              </Div2>

              <Div3>
                <DivForm>
                  <label>Cep *</label>
                  <FastField
                    required
                    name="cep"
                    type="text"
                    onBlur={(ev) => onBlurCep(ev, setFieldValue)}
                    placeholder="Informe seu CEP"
                  />
                </DivForm>

                <DivForm>
                  <label>Endereço *</label>
                  <Field
                    required
                    name="logradouro"
                    type="text"
                    placeholder="Rua/Av."
                  />
                </DivForm>

                <DivForm>
                  <label>Número *</label>
                  <Field
                    required
                    name="numero"
                    type="text"
                    placeholder="Número"
                  />
                </DivForm>
              </Div3>

              <Div2>
                <DivForm>
                  <label>Cidade *</label>
                  <Field
                    required
                    name="cidade"
                    type="text"
                    placeholder="Cidade"
                  />
                </DivForm>

                <DivForm>
                  <label>UF *</label>
                  <Field required name="uf" type="text" placeholder="Estado" />
                </DivForm>

                <DivForm>
                  <label>País *</label>
                  <Field required name="pais" type="text" placeholder="País" />
                </DivForm>
              </Div2>

              <Div3>
                <DivForm>
                  <label>Telefone *</label>
                  <Field
                    required
                    name="telefone1"
                    type="text"
                    placeholder="(**)*****-****"
                  />
                </DivForm>

                <DivForm>
                  <label>Telefone</label>
                  <Field
                    name="telefone2"
                    type="text"
                    placeholder="(**)*****-****"
                  />
                </DivForm>

                <DivForm>
                  <label>WhatsApp</label>
                  <Field
                    name="whatsapp"
                    type="text"
                    placeholder="(**)*****-****"
                  />
                </DivForm>
              </Div3>

              <Div2>
                <DivForm>
                  <label>E-mail *</label>
                  <Field
                    required
                    name="email"
                    type="email"
                    placeholder="Informe seu e-mail"
                    style={{ width: "350%" }}
                  />
                </DivForm>

                <DivForm>
                  <label>Senha *</label>
                  <Field
                    required
                    name="senha"
                    type="password"
                    placeholder="Senha"
                  />
                </DivForm>
              </Div2>

              <Div6>
                <SendButton type="submit" onClick={Cadastro}>
                  Iniciar
                </SendButton>
              </Div6>
            </Form>
          )}
        />
      </Div>
    </Container>
  );
}

export default Cadastro;
