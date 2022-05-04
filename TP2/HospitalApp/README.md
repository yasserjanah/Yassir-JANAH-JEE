#### TP2: Cas de Patient, Medecin, Rendez-vous, Consultation

##### 1. Entities:

- **Patient**:
    - **id**: id du patient
    - **nom**: nom du patient
    - **dateNaissance**: date de naissance du patient
    - **adresse**: adresse du patient
    - **malade**: booléen qui indique si le patient est malade
    - **Collection de Rendez-Vous**: collection de rendez-vous du patient
<br>
<br>
<img src="screenshoots/Patient-entity.png">
<br>
<br>
  
- **Medecin**:
    - **id**: id du medecin
    - **nom**: nom du medecin
    - **email**: email du medecin
    - **specialite**: specialité du medecin
    - **Collection de Rendez-Vous**: collection de rendez-vous du medecin
<br>
<br>
<img src="screenshoots/Medecin-entity.png">
<br>
<br>
  
- **Rendez-Vous**:
    - **id**: id du rendez-vous
    - **date**: date du rendez-vous
    - **status**: status du rendez-vous
    - **patient**: patient du rendez-vous
    - **medecin**: medecin du rendez-vous
    - **consultation**: consultation du rendez-vous
<br>
<br>
<img src="screenshoots/RendezVous-entity.png">
<br>
<br>
  
- **Consultation**:
    - **id**: id de la consultation
    - **dateConsulation**: date de la consultation
    - **rapportConsulation**: rapport de la consultation
    - **rendezVous**: rendez-vous de la consultation
<br>
<br>
<img src="screenshoots/Consultation-entity.png">
<br>
<br>

##### 2. Repositories:
- **PatientRepository**:
    <br>
    <img src="screenshoots/Patient-repo.png">
    <br>
- **MedecinRepository**:
    <br>
    <img src="screenshoots/Medecin-repo.png">
    <br>
- **RendezVousRepository**:
    <br>
    <img src="screenshoots/RendezVous-repo.png">
    <br>
- **ConsultationRepository**:
    <br>
    <img src="screenshoots/Consultation-repo.png">
    <br>

##### 3. Services:
- **IHospitalService**:
    <br>
    <img src="screenshoots/IHospitalService.png">
    <br>
- **IHospitalServiceImpl**:
    <br>
    <img src="screenshoots/IHospitalServiceImpl.png">
    <br>

##### 4. Spring Application:
- **application.properties**:
    <br>
    <img src="screenshoots/application.properties.png">
    <br>
- **run application**:
    <br>
    <img src="screenshoots/run-application.png">
    <br>
- **insert some data**:
    <br>
    <img src="screenshoots/insert-data.png">
    <br>
- **Verify the existence of data**:
    <br>
    <img src="screenshoots/inserted-data-verification.png">
    <br>
- **Create a Web Controller**:
    <br>
    <img src="screenshoots/create-controller.png">
    <br>
- **consulting `http://localhost:8080/api/patients`**:
    <br>
    <img src="screenshoots/result.png">
    <br>
