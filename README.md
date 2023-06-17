# Insurance Services REST Application

The Insurance Services REST Application is a web-based application that provides various insurance services to users. It allows users to perform operations related to insurance policies, claims, and customer management.

## Features

- Policy Management: Create, retrieve, update, and delete insurance policies.
- Claim Processing: Submit insurance claims and track their status.
- Customer Management: Manage customer information, including their policies and claims.
- Authentication and Authorization: Secure endpoints using authentication and authorization mechanisms.
- Logging and Error Handling: Log application activities and handle errors gracefully.
- API Documentation: Provide detailed documentation for the RESTful APIs exposed by the application.

## Installation

Follow these steps to set up and run the Insurance Services REST Application:

1. Clone the repository:

   ```
   git clone https://github.com/zencodenoob/insuranceService.git
   ```

2. Install dependencies:

   ```
   cd insurance-services
   mvn install
   ```

3. Configure the application:

   - Update the database configuration in `application.properties` file.
   - Configure authentication and authorization settings as per your requirements.

4. Run the application:

   ```
   mvn spring-boot:run
   ```

5. Access the application:

   Open a web browser and visit `http://localhost:8080` to access the Insurance Services application.

## API Documentation

The API documentation provides details about the available endpoints, request/response formats, and authentication requirements. Refer to the [API Documentation](./docs/api-documentation.md) for more information.


---

Thank you for using the Insurance Services REST Application. We hope it serves your insurance needs efficiently and effectively.
