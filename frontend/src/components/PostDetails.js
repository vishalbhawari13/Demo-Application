import React, { useEffect, useState } from "react";
import { getPostById } from "../services/postService";
import { useParams, Link } from "react-router-dom";

function PostDetails() {
  const { id } = useParams();
  const [post, setPost] = useState(null);

  useEffect(() => {
    getPostById(id).then((res) => setPost(res.data));
  }, [id]);

  if (!post) return <p>Loading...</p>;

  return (
    <div>
      <h2>{post.title}</h2>
      <p>{post.content}</p>
      <p>Author ID: {post.author?.id}</p>
      <Link to="/posts">Back to Posts</Link>
    </div>
  );
}

export default PostDetails;
