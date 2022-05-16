## Students Management using Spring Framework

##### 1. Create a new Spring Boot project

- Use the following command to create a new Spring Boot project<br>
    ```
    $ mvn archetype:generate -DgroupId=ma.janah -DartifactId=students-management -Dversion=1.0-SNAPSHOT -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
    ```
- Using Graphical Interface:<br>
<img src="screenshoots/init-project.png">

##### 2. Entities:

- **Student**:
    - **id**: String (primary key)
    - **firstName**: String
    - **lastName**: String
    - **email**: String
    - **dateOfBirth**: DATE
    - **gender**: <i>**GenderType**</i>
    - **enRegle**: Boolean

<img src="screenshoots/Student.png" alt="Student Entity">

- **GenderType**:
<img src="screenshoots/GenderType.png" alt="GenderType Enum">

##### 3. Repositories:
- **StudentRepository**:
<img src="screenshoots/StudentRepository.png" alt="Student Repository">

##### 4. Services:
- **IStudentService**:
    <br>
    <img src="screenshoots/IStudentService.png">
    <br>
- **StudentServiceImpl**:
    <br>
    <img src="screenshoots/StudentServiceImpl.png">
    <br>

##### 5. Controllers:
- **StudentController**:
    <br>
    <img src="screenshoots/StudentController.png">
    <img src="screenshoots/StudentController-suite-1.png">
    <img src="screenshoots/StudentController-suite-2.png">
    <br>

##### 6. Templates:
- **baseTemplate.html**:
    <br>
    <img src="screenshoots/baseTemplate.png">
    <br>
- **index.html**:
    <br>
    <img src="screenshoots/index.png">
    <br>
- **delete student using HTTP DELETE**:
    <br>
    <img src="screenshoots/DELETE.png">
    <br>
- **other templates**:
    <br>
    <img src="screenshoots/templates.png">
    <br>

##### 6. Spring Security:
- Using **UserDetails** Strategy:
    ##### 6.1 Entities:
    - **AppUser**:
        - **userId**: String (primary key)
        - **username**: String
        - **password**: String
        - **active**: Boolean
        - **roles**: List<AppRole>
    <br>
    <img src="screenshoots/AppUser.png">
    - **AppRole**:
        - **roleId**: Long (primary key)
        - **roleName**: String
        - **description**: String
    <br>
    <img src="screenshoots/AppRole.png">
    <br>
    ##### 6.2 Repositories:
    - **AppUserRepository**:
          <br>
          <img src="screenshoots/AppUserRepository.png">
          <br>
    - **AppRoleRepository**:
          <br>
          <img src="screenshoots/AppRoleRepository.png">
          <br>
    ##### 6.3 Services:
    - **ISecurityService**:
          <br>
          <img src="screenshoots/ISecurityService.png">
          <br>
    - **SecurityServiceImpl**:
          <br>
          <img src="screenshoots/SecurityServiceImpl.png">
          <br>
    ##### 6.4 UserDetailsService:
    - **UserDetailsServiceImpl**:
          <br>
          <img src="screenshoots/UserDetailsServiceImpl.png">
          <br>
    ##### 6.5 SecurityConfig:
    - **Enabling Method Security**:
        <br>
        <img src="screenshoots/method-security.png">
        <br>
    - **Secure Each Route**:
      `@PreAuthorize("hasAuthority('ADMIN')")`
      <br>
      <img src="screenshoots/secure_each_route.png">
      <br>
    - **Security Configuration**:
      <br>
      <img src="screenshoots/Security-config.png">
      <br>

##### 7. Spring Application:
- **application.properties**:
    <br>
    <img src="screenshoots/application.properties.png">
    <br>
- **create start function to add some data**:
    <br>
    <img src="screenshoots/beans.png">
    <br>
- **database**:
    <br>
    <img src="screenshoots/database.png">
    <br>

##### 8. Other Functionalities:
- custom **Exception Handler**:
    <br>
    <img src="screenshoots/ExceptionHandler.png">
    <br>
- custom **login page**:
    <br>
    <img src="screenshoots/login.png">
    <br>
    <img src="screenshoots/login-2.png">
    <br>
- custom **logout**:
    <br>
    <img src="screenshoots/logout.png">
    <br>
- update **security config**
    <br>
    <img src="screenshoots/login_logout_config.png">
    <br>

##### 9. Screenshots:
<img src="screenshoots/Screenshot-1.png" alt="Home">
<br>
<img src="screenshoots/Screenshoot-2.png" alt="Search">
<br>
<img src="screenshoots/Screenshoot-3.png" alt="Add new student">
<br>
<img src="screenshoots/Screenshoot-4.png" alt="Edit student">
<br>