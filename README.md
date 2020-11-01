# Rick and Morty API

## Table of contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For developer](#for_developer)
* [Authors](#authors)

## <a name="purpose"></a>Project purpose
This project is a simple REST API with information aboute  Rick-and-Morty's characters.

<hr>

### API: 
* /character/random - info about one randome character
* /character/by-name-contains?name={query} - info about all the characters with name contains specified query.

### Data loading: 
App automatically loads data from [public API](https://rickandmortyapi.com/documentation/) to configured data base. 
Data loads when app starts and reloads every day at 3:00 AM (server timezone) using crone job. 
Repository layer has implementation based on Spring Data and PostgreSQL DataBase.

## <a name="structure"></a>Used technologies
* Java 11
* Maven 4.0.0
* Spring Boot 
* maven-checkstyle-plugin
* PostgreSQL 12
* Swagger
<hr> 

## <a name="for_developer"></a>For developer
#### To run this project you need to install:
* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Tomcat](https://tomcat.apache.org/download-90.cgi)
* [PostgreSQL 12](https://www.postgresql.org/download/)

#### After installation, you should do the following:
* Add this project to your IDE as Maven project.
* Configure Spring Boot.
* Run the project.
* Swagger will be available at /swagger-ui.html

<hr>

## <a name="authors"></a>Authors
* [Leonid Sivko](https://github.com/Rommelua)
