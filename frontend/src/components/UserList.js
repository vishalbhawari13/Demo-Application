import React, { useEffect, useState } from "react";
import { getAllUsers, deleteUser } from "../services/userService";
import { Link } from "react-router-dom";

function UserList() {
  const [users, setUsers] = useState([]);

  const fetchUsers = () => {
    getAllUsers().then((res) => setUsers(res.data));
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  const handleDelete = (id) => {
    if (window.confirm("Are you sure you want to delete this user?")) {
      deleteUser(id).then(() => fetchUsers());
    }
  };

  return (
    <div>
      <h2>User List</h2>
      {users.map((u) => (
        <div key={u.id}>
          {u.name} - {u.email} - Age: {u.age}
          <Link to={`/user/${u.id}`}> Details </Link>
          <Link to={`/update-user/${u.id}`}> Edit </Link>
          <button onClick={() => handleDelete(u.id)}>Delete</button>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default UserList;
