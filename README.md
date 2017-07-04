Spring Framework Guestbook
--------------------------

To compile and run this example, first install maven:

`$ apt-get install maven`

cd into the main directory and run

`$ mvn spring-boot:run`

The application will boot up and make itself available on port 8080.

The application can use an in-memory H2 database, or a MySQL database. 
Config for both is in `application.properties.` The default config
will destroy and recreate the database each time the application
runs. This can also be changed in `application.properties` by tweaking
the `spring.jpa.hibernate.ddl-auto` setting; for example, to make the
data persists between runs, change `create` to `validate`.