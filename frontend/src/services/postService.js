import axios from "axios";

const BASE_URL = "http://localhost:8080/posts";

export const createPost = (userId, post) =>
  axios.post(`${BASE_URL}/users/${userId}`, post);

export const getAllPosts = (page, size, sortBy) =>
  axios.get(`${BASE_URL}?page=${page}&size=${size}&sortBy=${sortBy}`);

export const getPostById = (id) =>
  axios.get(`${BASE_URL}/${id}`);
