# Spring-thymeleaf-todo

A simple TODO application using Spring and Thymeleaf, The application use the Runtime Database H2 (change it as you like, using application.properties file).

![Spring Thymeleaf TODO Demo](DEMO.gif)

## To run the project locally:
- Clone the repository
```
git clone https://github.com/oweis/spring-thymeleaf-todo
```
- Install dependencies  
```
 mvn clean install
```
- By default, spring boot run on 8080, if this port not available, change the port by adding this to applications.properties:
 ```
  server.port=[AN_AVAILABLE_PORT]
```
- Run the project
```
 mvn spring-boot:run
```
- Open localhost:8080 (or localhost:[SPECIFIED_PORT]) ET VOILA!





