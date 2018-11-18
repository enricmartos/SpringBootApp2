# Topic manager

## Description

This application is a topic management system which allows you to see, edit and delete all the entries. You can add new topics and attach images to them.

## Personal goals

- Keep getting familiar with Spring Boot framework and learn how to perform basic CRUD operations
- Implement and manage file uploads such as images

## Core technologies

*Front-end*
- JSP (JavaServer Pages)
- Bootstrap

*Back-end*
- Spring Boot
- Hibernate (as a JPA framework)

*Database*
- MySQL

*Server*
- Apache Tomcat (default embedded server provided by Spring Boot)

*Dependency management tool*
- Maven

*IDE*
- Spring Tool Suite

# Build setup

- Clone this repo to your local machine. If you use Spring Tool Suite as IDE, open this project there:

```
# Import the project to STS

File -> Import -> Git -> Projects from Git -> Existing local repository -> Add ${Directory where you have cloned the repo} -> Import existing Eclipse projects
```

- MySQL and MySQL Workbench must be already installed in your machine. Otherwise, you will have to install them. Please notice that the default parameters (port, username and password) to enable the MySQL connection are defined on application.properties file. So, feel free to edit them in order to match one of your MySQL connections.

- Edit the default value of the property called _file.uploadsPath_ specified on application.properties file as well. This property must contain the path where the file uploads will be stored.

```
# Create the db

CREATE SCHEMA `coursedb` ;
```

- Run the project as Spring Boot App

- Open your browser and test the application on *localhost:8080*

## References

I have accomplished the aforementioned goals thanks to the following courses:

- [Spring Boot + Spring MVC + JPA](https://www.youtube.com/watch?v=II8V0_ilRbU&list=PLdJYl6XU45uLIHaPBQEj-cEMynAl0oeiz&index=1)
- [How to upload the File by using Spring Boot Rest API?](https://www.youtube.com/watch?v=zIcvHO_j00Q)
