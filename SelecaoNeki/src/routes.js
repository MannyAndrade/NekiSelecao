import React from "react";
import Navbar from "./components/Navbar";
import { BrowserRouter, Switch, Route, Redirect } from "react-router-dom";
import GlobalStyle from "./styles/globalStyles";
import SignUp from "./pages/SignUp/index";
import SignIn from "./pages/SignIn/index";
import Cadastro from "./pages/Cadastro/index";
import Skills from "./pages/Skills/index";
import { isAuthenticated, getToken } from "./services/auth";

const PrivateRoute = ({ component: Component, ...rest }) => (
  <Route
    {...rest}
    render={(props) =>
      isAuthenticated() ? (
        <Component {...props} />
      ) : (
        <Component {...props} />

        // <Redirect
        //   to={{ pathname: "/signin", state: { from: props.location } }}
        // />
      )
    }
  />
);

function Routes({ component: Component, ...rest }) {
  console.log("rota: " + isAuthenticated());
  console.log("token na rota: " + getToken());

  return (
    <BrowserRouter>
      <GlobalStyle />
      {/* <Sidebar /> */}
      <Navbar autenticado={isAuthenticated()} />

      <Switch>
        <Route path="/" exact component={SignIn} />
        <Route path="/signup" component={SignUp} />
        <Route path="/cadastro" component={Cadastro} />
        <PrivateRoute path="/skills" exact component={Skills} />
        <Route path="*" component={() => <h1>Page not found</h1>} />
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;
