# Demo Application

This is a full-stack web application built with **Spring Boot** (backend) and **React.js** (frontend).  
The project allows managing **Users** and **Posts** with CRUD operations.

---

## Project Structure

### Backend
- **Technology**: Java, Spring Boot, Spring Data JPA, MySQL
- **Port**: 8080
- **APIs**:
  - Users: `http://localhost:8080/Demo`
  - Posts: `http://localhost:8080/posts`
- **Features**:
  - Add, update, delete, and view users
  - Add, update, delete, and view posts
  - Data validation using DTOs and JSR-380 annotations
  - Optional caching with Redis (if configured)

### Frontend
- **Technology**: React.js, Axios, React Router
- **Port**: 3000
- **Components**:
  - `AddUser.js`, `UserList.js`, `UserDetails.js`, `UpdateUser.js`
  - `AddPost.js`, `PostList.js`, `PostDetails.js`
- **Services**:
  - `userService.js`: handles API calls for Users
  - `postService.js`: handles API calls for Posts

---

## Getting Started

### Backend

1. Navigate to the backend folder:

```bash
cd backend
```

2. Run the Spring Boot application:

```bash
mvn spring-boot:run
```

3. Backend will start at:

```
http://localhost:8080
```

4. You can test the APIs in [Postman](https://www.postman.com/) before using the frontend.

---

### Frontend

1. Navigate to the frontend folder:

```bash
cd frontend
```

2. Install dependencies:

```bash
npm install
```

3. Start the React development server:

```bash
npm start
```

4. Open your browser at:

```
http://localhost:3000
```

> **Note**: Make sure the backend is running before using the frontend.

---

## Available Scripts (Frontend)

- `npm start`: Run the app in development mode  
- `npm test`: Launches the test runner  
- `npm run build`: Build for production  
- `npm run eject`: Eject from Create React App (one-way operation)

---

## API Endpoints (Backend)

### Users

| Action      | Endpoint                  | Method |
|------------|---------------------------|--------|
| Add User    | `/Demo/add`               | POST   |
| Get All     | `/Demo/findAll`           | GET    |
| Get By Id   | `/Demo/find/{id}`         | GET    |
| Update User | `/Demo/update/{id}`       | PUT    |
| Delete User | `/Demo/delete/{id}`       | DELETE |

### Posts

| Action        | Endpoint                       | Method |
|---------------|--------------------------------|--------|
| Add Post      | `/posts/users/{userId}`         | POST   |
| Get All       | `/posts?page=&size=&sortBy=`    | GET    |
| Get By Id     | `/posts/{id}`                   | GET    |

---

## Testing Example Data

### Add User

```json
{
  "name": "Dhiren",
  "email": "dhiren123@gmail.com",
  "age": 25
}
```

### Add Post

```json
{
  "title": "My First Post",
  "content": "This is the content of my first post."
}
```

> You can test these in Postman or through the React frontend forms.

---

## Learn More

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [React.js Documentation](https://reactjs.org/)
- [Axios Documentation](https://axios-http.com/)
- [Create React App Documentation](https://facebook.github.io/create-react-app/docs/getting-started)

---

## Notes

- Ensure **frontend and backend ports do not conflict**.  
- Backend must be running at **http://localhost:8080** for the frontend to communicate correctly.  
- If using MySQL, make sure the database and credentials are properly configured in `application.properties`.  
- Redis caching is optional but can be enabled if configured in `RedisConfig.java`.

