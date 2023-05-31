# Book Store
This book store project is an example of an MVC application to work as a functioning book store, with both roles for a regular user and admin. Using Spring Boot and Java with hibernate as the ORM using a repository pattern to separate data access from business logic.

## Features
- User Authentication using OAuth2 with managed roles.
- Admin page for editing the contents
- Responsive ui using bootstrap


## Prerequisites
- Java 17 or above
- MySQL installed and configured


## Installation 
1. Clone the repository
    ```bash
   git clone https://github.com/chrissjj/BookStoreMVC.git
   ```
2. Open the project in your preferred IDE.
3. Update the database connection details in `application.properties`.
4. Run the application.


## Configuration
Update `application.properties`:
- `spring.datasource.url=` your connection string.
- `spring.datasource.username=` your username.
- `spring.datasource.password=` your password.

## Project structure
- `model`: Defines all domain models for the application.
- `repository`: Contains the data access layer where we utilize `JpaRepository`.
- `service`: Contains the business logic that interacts with the repositories.
- `controller`: Defines the controllers for the different public end points.
- `static`: Contains all static content that needs to be served.
- `templates`: Defines all views referenced in controllers to complete the MVC application.
