# Code for project "FirstSecurityApp"
```
This repository contains the code for the project "FirstSecurityApp," 
which uses Spring Security to provide user authentication and authorization. 
The project implements basic functionality for user login, registration, and displaying user data.
```
## Project Structure

### Folder src/main/java/ua/ypon/springcourse/FirstSecurityApp
```
This folder contains all the Java classes of the project.

config/SecurityConfig.java: Spring Security configuration for authorization and request filtering.
controllers/AuthController.java: Controller to handle login and registration pages.
controllers/HelloController.java: Controller to display greetings and user information.
models/Person.java: User model with fields for name, password, and other data.
repositories/PeopleRepository.java: Interface for accessing user data from the database.
security/PersonDetails.java: Implementation of the UserDetails interface to represent authenticated user data.
services/PeopleService.java: Service for working with user data.
services/PersonDetailsService.java: Service to find users by their username.
services/RegistrationService.java: Service for user registration.
```
### Folder src/main/resources
```
This folder contains project resources such as HTML templates and configurations.

static/: Static resources, such as CSS, JavaScript, etc.
templates/auth/: HTML templates for login and registration pages.
templates/hello.html: HTML template for displaying the greeting page and user information.
```
### File pom.xml

The Maven project file specifying dependencies and project configurations.

## Environment Requirements
```
Java 8+
Maven
```
## Installation Instructions

Clone the repository using git clone https://github.com/your-username/FirstSecurityApp.git
Open the project in your favorite code editor (IntelliJ IDEA, Eclipse, etc.).
Build and run the project using Maven or your preferred Java build and run tool.

## License

This project is licensed under the MIT License. For details, see the LICENSE file.

## Contribution
```
If you have any suggestions for improving this project, 
please create a new pull request or open a new issue.
```
### Enjoy using the app!
