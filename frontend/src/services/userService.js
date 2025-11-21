import axios from "axios";

const BASE_URL = "http://localhost:8080/Demo";

export const addUser = (user) => axios.post(`${BASE_URL}/add`, user);

export const getAllUsers = () => axios.get(`${BASE_URL}/findAll`);

export const getUserById = (id) => axios.get(`${BASE_URL}/find/${id}`);

export const updateUser = (id, user) =>
  axios.put(`${BASE_URL}/update/${id}`, user);

export const deleteUser = (id) =>
  axios.delete(`${BASE_URL}/delete/${id}`);
