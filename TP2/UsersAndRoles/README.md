#### TP2: Cas de Users et Roles

##### 1. Entities:

- **User**:
  - **id**: `int`
  - **username**: `string`
  - **password**: `string`
  - **roles**: `List<Role>`
<br>
<img src="screenshots/User.png">
<br>
- **Role**:
  - **id**: `int`
  - **roleName**: `String`
  - **description**: `String`
  - **users**: `List<User>`
<br>
<img src="screenshots/Role.png">
<br>


##### 2. Repositories:
- **UserRepository**:
    <br>
    <img src="screenshots/UserRepository.png">
    <br>
- **RoleRepository**:
    <br>
    <img src="screenshots/RoleRepository.png">
    <br>

##### 3. Services:
- **IUserService**:
    <br>
    <img src="screenshots/IUserService.png">
    <br>
- **UserServiceImpl**:
    <br>
    <img src="screenshots/UserServiceImpl-1.png">
    <img src="screenshots/UserServiceImpl-2.png">
    <img src="screenshots/UserServiceImpl-3.png">
    <br>

##### 4. Controllers:
- **UserController**:
    <br>
    <img src="screenshots/UserController.png">
    <br>

##### 5. Spring Application:
- **application.properties**:
    <br>
    <img src="screenshots/application.properties.png">
    <br>

- **insert some data**:
    <br>
    <img src="screenshots/InsertData.png">
    <br>
- **Verify the existence of data**:
    <br>
    <img src="screenshots/database.png">
    <br>
- **consulting `http://localhost:8080/users`**:
    <br>
    <img src="screenshots/users.png">
    <br>
- **consulting `http://localhost:8080/users/admin`**:
    <br>
    <img src="screenshots/admin.png">
    <br>
- authenticate `http://localhost:8080/users/authenticate`:
    <br>
    <img src="screenshots/authenticate.png">
    <br>
