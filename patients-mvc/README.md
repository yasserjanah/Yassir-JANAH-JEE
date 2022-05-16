#### TP3: Patients Management using Spring MVC & Thymeleaf

##### 1. Entities:

- **Patient**:
  - **id**: `Long`
  - **nom**: `String`
  - **dateNaissance**: `Date`
  - **malade**: `boolean`
  - **score**: `int`
<br>
<img src="screenshots/Patient.png">
<br>

##### 2. Repositories:
- **PatientRepository**:
    <br>
    <img src="screenshots/PatientRepository.png">
    <br>

##### 3. Controllers:
- **PatientController**:
    <br>
    <img src="screenshots/PatientController.png">
    <img src="screenshots/PatientController-2.png">
    <br>

##### 4. Templates:
- **baseTemplate.html**:
    <br>
    <img src="screenshots/baseTemplate.png">
    <br>
- **patients.html**:
    <br>
    <img src="screenshots/patients.png">
    <br>
- **other templates**:
    <br>
    <img src="screenshots/other.png">
    <br>

### 5. Spring Security:

- Using **UserDetails** Strategy:
  #### 5.1 Entities:
    - **AppUser**:
        - **userId**: String (primary key)
        - **username**: String
        - **password**: String
        - **active**: Boolean
        - **roles**: List of <i>**Role**</i>
    <br>
    <img src="screenshots/AppUser.png">
    <br>
      
    - **AppRole**:
        - **roleId**: Long (primary key)
        - **roleName**: String
        - **description**: String
    <br>
    <img src="screenshots/AppRole.png">
    <br>
      
  #### 5.2 Repositories:
    - **AppUserRepository**:
      <br>
      <img src="screenshots/AppUserRepository.png">
      <br>
  
    - **AppRoleRepository**:
      <br>
      <img src="screenshots/AppRoleRepository.png">
      <br>
  
  #### 5.3 Services:
    - **ISecurityService**:
      <br>
      <img src="screenshots/ISecurityService.png">
      <br>
  
    - **SecurityServiceImpl**:
      <br>
      <img src="screenshots/SecurityServiceImpl.png">
      <br>
  
  #### 5.4 UserDetailsService:
    - **UserDetailsServiceImpl**:
      <br>
      <img src="screenshots/UserDetailsServiceImpl.png">
      <br>
  
  #### 5.5 SecurityConfig:
 - **Security Configuration**:
      <br>
      <img src="screenshots/Security-config.png">
      <br>

##### 6. Spring Application:
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

##### 7. Screenshots:
<img src="screenshots/Screenshot-1.png">
<img src="screenshots/Screenshot-2.png">