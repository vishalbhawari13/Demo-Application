import React, { useState } from "react";
import { addUser } from "../services/userService";
import { useNavigate } from "react-router-dom";

function AddUser() {
  const [user, setUser] = useState({ name: "", email: "", age: "" });
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const submitForm = (e) => {
    e.preventDefault();
    addUser(user)
      .then(() => {
        alert("User added successfully!");
        navigate("/users"); // go to user list
      })
      .catch((err) => {
        setError(err.response?.data?.message || "Something went wrong!");
      });
  };

  return (
    <div>
      <h2>Add User</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <form onSubmit={submitForm}>
        <input
          type="text"
          placeholder="Name"
          value={user.name}
          onChange={(e) => setUser({ ...user, name: e.target.value })}
        />
        <input
          type="email"
          placeholder="Email"
          value={user.email}
          onChange={(e) => setUser({ ...user, email: e.target.value })}
        />
        <input
          type="number"
          placeholder="Age"
          value={user.age}
          onChange={(e) => setUser({ ...user, age: e.target.value })}
        />
        <button type="submit">Add User</button>
      </form>
    </div>
  );
}

export default AddUser;
