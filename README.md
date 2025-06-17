Spring-Web-Security-and-RollBased-access 🛡️

This project is a role-based Employee Manager Web Application developed using **Spring Boot**, **Spring Security**, and **Thymeleaf**. It allows users to register, log in with a custom form, and access different pages based on their assigned roles.

## 🌟 Features

- ✅ User registration with password encryption (BCrypt)
- ✅ Custom login page as the first entry point (`/show_login_page`)
- ✅ Role-based access control:
  - `ROLE_USER` → basic access
  - `ROLE_LEADER` → access to leadership content
  - `ROLE_MANAGEMENT` → admin-level access
- ✅ Spring Security integration with:
  - `UserDetailsService` and custom `User` entity
  - Session-based authentication
- ✅ Thymeleaf integration for dynamic front-end views
- ✅ Unauthorized access handling with custom `/access-denied` page
- ✅ Home page redirection after login
- ✅ Permit-all URLs for public pages like login and registration

---

## 🔧 Technologies Used

| Tool / Tech      | Description                     |
|------------------|---------------------------------|
| Java 17+         | Programming Language             |
| Spring Boot      | Backend Framework                |
| Spring Security  | Security Layer                   |
| Thymeleaf        | Templating Engine for HTML views |
| Maven            | Dependency Management            |
| H2 / MySQL       | Database                         |
| HTML & CSS       | Front-end styling                |
| Git & GitHub     | Version Control                  |

---

## 📁 Project Structure
src/
├── main/
│ ├── java/com/dev/springsecurity/
│ │ ├── config/ # Security config
│ │ ├── controller/ # Web controllers
│ │ ├── model/ # Entity classes (User)
│ │ ├── repository/ # Spring Data JPA Repositories
│ │ ├── service/ # CustomUserDetailsService
│ │ └── EmployeeManagerApplication.java
│ └── resources/
│ ├── templates/ # Thymeleaf HTML views
│ ├── static/css/ # CSS files
│ └── application.properties


---

## 🧠 Roles and Access Flow

```text
User Roles:
  └── ROLE_USER → /user/**
  └── ROLE_LEADER → /leader/**
  └── ROLE_MANAGEMENT → /admin/**

Access Configuration in SecurityFilterChain:
- /register, /show_login_page → permitAll()
- /user/** → hasAuthority("ROLE_USER")
- /leader/** → hasAuthority("ROLE_LEADER")
- /admin/** → hasAuthority("ROLE_MANAGEMENT")
🙋‍♂️ Author Devendra patil
