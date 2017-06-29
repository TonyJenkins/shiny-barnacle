Spring Framework Guestbook
--------------------------

To compile and run this example, first install maven:

`$ apt-get install maven`

cd into the main directory and run

`$ mvn spring-boot:run`

The application will boot up and make itself available on port 8080.

The application uses an in-memory H2 database, so all entries are lost once the application
exits.