# Eureka Service Discovery Example
This is an example demonstrating the use of [eureka](https://github.com/Netflix/eureka) for service discovery and load balancing.

It has three components: eureka-server, springwebapp and javaprogram.  
**eureka-server**: service registry  
**springwebapp**: the restful webservice  
**javaprogram**: the program that queries the eureka-server for the location of the webservice and makes a http request to it  

## First start eureka-server

```
cd eureka-server
mvn spring-boot:run
```
eureka should be started on port 8761 check http://localhost:8761/

## Second start the web service

```
cd springwebapp
mvn spring-boot:run
```
or if you have a tomcat server setup
```
cd springwebapp
mvn tomcat7:undeploy
mvn tomcat7:deploy
```
Check http://localhost:8080/contact/jsonlist if there is no data use post to add some data.

Use the POST method to add some json data:  
curl -X POST -H "Content-Type: application/json" -d '{"firstName":"myname", "lastName":"surname", "email":"myname@surname.com"}' http://localhost:8080/contact 

## Third start the java program

```
cd JavaProgram
mvn clean package
java -jar target/JavaProgram.jar
```

Runs com.mycompany.App, should output the contactId, firstName and lastName
