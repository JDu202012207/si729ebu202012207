# Mental State Exam Assessment

Este proyecto es una aplicación de Spring Boot que permite a los examinadores crear exámenes de estado mental.
## Desarrollado por:
- Juan Diego Cueto Dominguez
- U202012207
- SI729 - Desarrollo de Aplicaciones Open Source
- Sección SW53
- Profesor: Elio Jefferrson Navarrete Vilca

## Requisitos

- Java 22
- Maven
- Spring Boot 3.X
- MySQL

## Instalación

Para instalar el proyecto, sigue estos pasos:

1. Clona el repositorio: `git clone https://github.com/JDu202012207/mental-state-exam-assessment.git`
2. Navega al directorio del proyecto: `cd mental-state-exam-assessment`
3. Compila el proyecto: `mvn clean install`

## Uso

Para ejecutar el proyecto, usa el siguiente comando: `mvn spring-boot:run`

La aplicación expone un endpoint POST en `/api/v1/mental-state-exams` que permite a los examinadores crear exámenes de estado mental.


## Endpoints
### Examiners
- **POST /api/v1/examiners**: Crea un nuevo examiner.
    - **Request Body**:
      ```json
      {
        "firstName": "John",
        "lastName": "Doe",
        "nationalProviderIdentifier": "550e8400-e29b-41d4-a716-446655440000"
      }
      ```
    - **Response Body**:
      ```json
      {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "nationalProviderIdentifier": "550e8400-e29b-41d4-a716-446655440000"
      }
      ```

### Mental State Exams
- **POST /api/v1/mental-state-exams**: Crea un nuevo mental state exam.
    - **Request Body**:
      ```json
      {
        "patientId": 1,
        "examinerNationalProviderIdentifier": "550e8400-e29b-41d4-a716-446655440000",
        "examDate": "2024-01-11",
        "orientationScore": 6,
        "registrationScore": 2,
        "attentionAndCalculationScore": 4,
        "recallScore": 3,
        "languageScore": 8
      }
      ```
    - **Response Body**:
      ```json
      {
        "id": 1,
        "patientId": 1,
        "examinerNationalProviderIdentifier": "550e8400-e29b-41d4-a716-446655440000",
        "examDate": "2024-01-11",
        "orientationScore": 6,
        "registrationScore": 2,
        "attentionAndCalculationScore": 4,
        "recallScore": 3,
        "languageScore": 8
      }
      ```

## Documentación
La documentación completa del API está disponible en OpenAPI. Para visualizarla, puedes acceder a:
[Documentación OpenAPI](http://localhost:8080/swagger-ui/index.html#/)

## Consideraciones
- Se utilizó el patrón de diseño Anti-Corruption Layer (ACL) para integrar los bounded contexts `personnel` y `assessment`.
- Se aplicaron principios y patrones de diseño de software orientado a objetos y DDD.
- Se utilizó el patrón de diseño Value Object para representar el National Provider Identifier (NPI).
- Se utilizaron records para almacenamiento de valores inmutables.
- Se incluyó auditoría automática para las entidades `Examiner` y `MentalStateExam`.

---
