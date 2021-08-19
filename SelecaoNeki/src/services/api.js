import axios from "axios";
import { getToken } from "./auth";

const api = axios.create({
  // baseURL: 'https://livrariahabitualapi.herokuapp.com'
  // baseURL: 'https://git.heroku.com/pmt-api.git'
  // baseURL: 'http://169.57.150.61:8011/'
  baseURL: "http://localhost:8080/",
});
api.interceptors.request.use(async (config) => {
  const token = getToken();
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;
