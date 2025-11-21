import React, { useEffect, useState } from "react";
import { getUserById, updateUser } from "../services/userService";
import { useParams, useNavigate } from "react-router-dom";

function UpdateUser() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [user, setUser] = useState({ name: "", email: "", age: "" });

  useEffect(() => {
    getUserById(id).then((res) => setUser(res.data));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    updateUser(id, user).then(() => {
      alert("User updated!");
      navigate("/users");
    });
  };

  return (
    <div>
      <h2>Update User</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={user.name}
          onChange={(e) => setUser({ ...user, name: e.target.value })}
        />
        <input
          type="email"
          value={user.email}
          onChange={(e) => setUser({ ...user, email: e.target.value })}
        />
        <input
          type="number"
          value={user.age}
          onChange={(e) => setUser({ ...user, age: e.target.value })}
        />
        <button type="submit">Update User</button>
      </form>
    </div>
  );
}

export default UpdateUser;
