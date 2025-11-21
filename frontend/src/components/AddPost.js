import React, { useState } from "react";
import { createPost } from "../services/postService";
import { useNavigate } from "react-router-dom";

function AddPost() {
  const [post, setPost] = useState({ title: "", content: "" });
  const [userId, setUserId] = useState("");
  const navigate = useNavigate();

  const submitForm = (e) => {
    e.preventDefault();
    createPost(userId, post).then(() => {
      alert("Post created!");
      navigate("/posts");
    });
  };

  return (
    <div>
      <h2>Create Post</h2>
      <form onSubmit={submitForm}>
        <input
          type="number"
          placeholder="User ID"
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
        />
        <input
          type="text"
          placeholder="Title"
          value={post.title}
          onChange={(e) => setPost({ ...post, title: e.target.value })}
        />
        <textarea
          placeholder="Content"
          value={post.content}
          onChange={(e) => setPost({ ...post, content: e.target.value })}
        />
        <button type="submit">Add Post</button>
      </form>
    </div>
  );
}

export default AddPost;
