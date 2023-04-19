## Dance Class Database
Dance Class Database is a web application that allows users to register,     
vote for their favorite dance classes and instructors, and comment on classes.     
Only the administrator has the ability to add new content to the site.

## Technologies
The project is based on Spring Boot 3 and Java 17.      
The data access layer uses **JPA, Hibernate,** and **Spring Data,** and **Liquibase** is used for database migrations.

Two profiles were created: development and production, which differ in the database engine used and the location of uploaded files.

The application's UI was created using **Thymeleaf, HTML,** some **JavaScript,** and **CSS**. Thanks to the use of **Flexbox**, the page is responsive and adapts to all screen sizes.

The entire application is connected using **Spring MVC**, and it is secured using **Spring Security**. The configuration is based on **Spring Boot**.
