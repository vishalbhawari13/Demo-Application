import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import AddUser from "./components/AddUser";
import UserList from "./components/UserList";
import UserDetails from "./components/UserDetails";
import UpdateUser from "./components/UpdateUser";
import AddPost from "./components/AddPost";
import PostList from "./components/PostList";
import PostDetails from "./components/PostDetails";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* Default route redirects to User List */}
        <Route path="/" element={<Navigate to="/users" />} />

        {/* User routes */}
        <Route path="/add-user" element={<AddUser />} />
        <Route path="/users" element={<UserList />} />
        <Route path="/user/:id" element={<UserDetails />} />
        <Route path="/update-user/:id" element={<UpdateUser />} />

        {/* Post routes */}
        <Route path="/add-post" element={<AddPost />} />
        <Route path="/posts" element={<PostList />} />
        <Route path="/post/:id" element={<PostDetails />} />

        {/* Catch-all route */}
        <Route path="*" element={<h2>Page Not Found</h2>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
