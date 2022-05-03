# TP1: dependency injection

- different methods for injecting dependencies.
- static injection.
- dynamic injection.
- using the Spring Framework:
  - XML Version
  - Annotation Version
---

#### 1. create IDAO interface
<img src="screenshoots/create-IDAO-interface.png" alt="create IDAO interface">

#### 2. create IDAO implementation
<img src="screenshoots/create-IDAO-implementation.png" alt="create IDAO implementation">

#### 3. create IMetier interface
<img src="screenshoots/create-IMetier-interface.png" alt="create IMetier interface">

#### 4. create IMetier implementation
<img src="screenshoots/create-IMetier-Implementation.png" alt="create IMetier implementation">

#### 5. Dependency Injection

##### 5.1 Static Injection:
  - instantiate every class manually.
  <img src="screenshoots/static-di.png">

##### 5.2 Dynamic Injection:
  - create a config file.
  <img src="screenshoots/config-file.png" alt="config file">
  - create a class that will be used to inject the dependencies.
  <img src="screenshoots/dynamic-di.png">

##### 5.3 Using the Spring Framework:
  ##### 5.3.1 XML Version:
  - create `applicationContext.xml` file.
    <img src="screenshoots/applicationContext.png">

  - create a class that will be used to inject the dependencies.
    <img src="screenshoots/spring-xml-version.png">

##### 5.3.2 Annotation Version:
  - create new Dao implementation decorated `@Component`.
  <img src="screenshoots/new-dao-impl-with-component.png">

  - create new Metier implementation decorated `@Component`.
  <img src="screenshoots/metier-class-component.png">

  - create class that will be used to inject the dependencies.
  <img src="screenshoots/pres-annotations.png">