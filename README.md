
# Insurance Management System

This application is a REST API for an Online Insuarance Management System.Using this web service a employe can register and client and see all policies and see all the claims done by client.All these CRUD operations require validation on each step.


## Tech Stack
 
* Java
* SpringBoot
* MySql
* JPA 
* SwaggerUi 
* LOMBOK




## Installation

Before running the API server, you have to update the database configuration inside the application.properties file.
Update the port number, username and password as per your local database configuration

```bash
     server.port=6060

    spring.datasource.url=jdbc:mysql://localhost:3306/InsuaranceMangment;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=Root
    
```
    
## For Swagger

For opening the api from browser

```bash
  http://localhost:8080/swagger-ui.html
```
