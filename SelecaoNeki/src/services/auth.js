export const TOKEN_KEY = "@airbnb-Token";
export const USER_CODE = "@eu-code";
export const isAuthenticated = () => localStorage.getItem(TOKEN_KEY) !== null;
export const getToken = () => localStorage.getItem(TOKEN_KEY);
export const login = (token) => {
  localStorage.setItem(TOKEN_KEY, token);
};
export const getcode = (codigoUsuario) =>
  localStorage.setItem(USER_CODE, codigoUsuario);
export const code = () => localStorage.getItem(USER_CODE) !== null;
export const logout = () => {
  localStorage.removeItem(TOKEN_KEY);
};
