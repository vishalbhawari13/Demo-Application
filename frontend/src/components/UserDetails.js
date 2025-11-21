import React, { useEffect, useState } from "react";
import { getUserById } from "../services/userService";
import { useParams, Link } from "react-router-dom";

function UserDetails() {
  const { id } = useParams();
  const [user, setUser] = useState(null);

  useEffect(() => {
    getUserById(id).then((res) => setUser(res.data));
  }, [id]);

  if (!user) return <p>Loading...</p>;

  return (
    <div>
      <h2>User Details</h2>
      <p>Name: {user.name}</p>
      <p>Email: {user.email}</p>
      <p>Age: {user.age}</p>
      <Link to="/users">Back to Users</Link>
    </div>
  );
}

export default UserDetails;
