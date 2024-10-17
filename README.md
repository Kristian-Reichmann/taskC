# CSCI318: TaskC - Event Registration Platform
This is a microservice prototype of an event registration platform.
The framework used is Spring Boot depends on Spring Web, Spring Data JPA, and H2 libraries

## Build
Download the Group_16_Task_C_source_code.zip folder and extract the contents

Change directory to the extracted folder and open the listed services below in a separate window in IntelliJ:
- Event Organiser
- General User; and
- Venue Owner

Make sure IntelliJ is using the `Java 21 SDK` and ensure that each service's
`src/main/java/resources/application.properties` file uses a different `server.port`. Otherwise there will be a
conflict and the services will not run.


## Run the service
In each window run the main file. The main file in each service is located on the following path

`src/main/java/{service}/{service}Application.java`

Run the current file using either `shift+F10` in IntelliJ or by clicking run.

## Run the H2 Console
If you wish to view the H2 database, add

`spring.h2.console.enabled=true`
`spring.datasource.url=jdbc:h2:mem:testdb`

to the `applicatin.properties` file and in a browser go to `http://localhost:{server.port}/h2-console` and in the
`JDBC URL` field use `jdbc:h2:mem:testdb`
