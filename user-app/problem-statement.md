## User App Rest Apis

### Build Apis for the following

- POST : Create new User
- GET : Get all user
- GET : Get user by id
- PUT : Update User
- DELETE : Delete User

**Consider Map<Integer, User> as our datasource**

### User Entity

```java

import java.time.LocalDate;

class User {
    private int userId;
    private String username;
    private String email;
    private LocalDate dob;
}

```

### User DTO

```java

import java.time.LocalDate;

record User(
    private int userId,
    private String username,
    private String email,
    private LocalDate dob
){}

```

## Swagger UI URL

http://localhost:8000/swagger-ui.html