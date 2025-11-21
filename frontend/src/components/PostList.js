import React, { useEffect, useState } from "react";
import { getAllPosts } from "../services/postService";
import { Link } from "react-router-dom";

function PostList() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    getAllPosts(0, 10, "id").then((res) => setPosts(res.data.content));
  }, []);

  return (
    <div>
      <h2>Posts</h2>
      {posts.map((p) => (
        <div key={p.id}>
          <h3>{p.title}</h3>
          <p>{p.content}</p>
          <small>User ID: {p.author?.id}</small>
          <Link to={`/post/${p.id}`}> View Details </Link>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default PostList;
