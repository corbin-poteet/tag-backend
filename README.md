# Tag CRUD System Backend

A simple CRUD back end web application created for challenge #1 of Thrive Pet Healthcare's interview project. Includes full CRUD functionality for tags.

### Tech stack:
- Java
- Maven
- Spring Boot
- REST API
- JPA/Hibernate
- MySQL

## Instructions

1. Clone the repository
2. Open the project in your IDE
3. Create a blank default MySQL schema named `tag` in your MySQL local instance. 
   - Update the `application.yaml` file with your MySQL connection details if they're not the same as the default values, which are:
       - Hostname: `127.0.0.1` or `localhost`
       - Port: `3306`
       - Username: `root`
       - Password: ``
4. Run the project
5. Use Postman or any other API testing tool to test the endpoints

## Notes
- I've included a Postman collection in the root directory of the project for easy endpoint testing.
- The base URL is `http://localhost:8080/api/v1/tags`
- I tried my hardest to get automatic MySQL schema creation to work, but I couldn't get it to work. So you'll have to create a blank schema named `tag` in your MySQL local instance manually.
- The database is MySQL. The connection details are in the `application.yaml` file.
- The database table is created automatically when the application is run, deleting previous table data. You can change this behavior in the `application.yaml` file by changing the `spring.jpa.hibernate.ddl-auto` from `create` to `validate`, but you should probably run it with `create` once to create the table.
- The endpoints are:
    - GET: `/` - Get all tags
    - GET: `/{group}/{element}` - Get a tag by group and element
    - POST: `/` - Create a new tag
    - PUT: `/{group}/{element}` - Update a tag by group and element
    - DELETE: `/{group}/{element}` - Delete a tag by group and element 
    - DELETE: `/` - Delete all tags