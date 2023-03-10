# SPRINGBOOT API IN ATLAS MONGO DB RELATIONSHIPS
## Requirements
- github link -> https://github.com/scbushan05/spring-boot-mongodb
- jdk - version 19
- Intellij
- Database -> Mongodb (Atlas... i.e. online)


- initializer url -> https://start.spring.io/

## mvn commands
- mvn clean
- mvn clean compile
- mvn test

## Tomcat
- Tomcat port: 8080

## Solving plugin errors:
- Now lets say I had 10 such plugins which didn't get resolve and among them the first was 'org.apache.maven.plugins:maven-site-plugin' I went to '.m2/repository/org/apache/maven/plugins/' and deleted the directory 'maven-site-plugin' and did a maven reimport again. Guess what, particular missing plugin got dowloaded. And I just followed similar steps for other missing plugins and all got resolved.
- link -> https://stackoverflow.com/questions/20496239/maven-plugins-can-not-be-found-in-intellij

## NB : 
- While opening the project in IDEA such as Intellij IDEA, open the last 'demo' file


## Killing a process in cmd:
- First determine process id occupied by that port i.e. port 8080 by running:<br>

      netstat -ano | findstr :8080
- Then kill the process

      netstat -ano | findstr :8080

## Layers 
- API layer - Controller (Contains GET, POST, PUT, DELETE)
- Service Layer - Business logic
- Data Access Layer - 

## API Layer
![SpringBootLayers](images/SpringBootLayers.PNG)

## API DOC
### Employee
1) POST -> Create Employee:
- - endpoint -> http://localhost:8080/api/v1/employees/create-employee
- - - body : 

          {
            "name": "Simon",
            "gender": "Male",
            "dob": "23-11-2006",
            "country": "Kenya"
          }

- response :

        {
          "id": 3,
          "name": "Simon",
          "gender": "Male",
          "dob": "23-11-2006",
          "country": "Kenya"
        }


2) GET -> Get all Employees:
- - endpoint -> http://localhost:8080/api/v1/employees/employees-list
- - - body :
    
          [
           {
             "id": 1,
             "name": "Simon",
             "gender": "Male",
             "dob": "23-11-2006",
             "country": "Kenya"
           },
           {
             "id": 2,
             "name": "Martin",
             "gender": "Male",
             "dob": "23-11-1999",
             "country": "Kenya"
           }
          ]

3) GET -> Get Employee by id:
- - endpoint -> http://localhost:8080/api/v1/employees/get-employee/1
- - - response :

          {
            "id": 1,
            "name": "Simon",
            "gender": "Male",
            "dob": "23-11-2006",
            "country": "Kenya"
          }
4) PUT -> Update Employee:
- endpoint -> http://localhost:8080/api/v1/employees/update-employee/1
- - - body :

          {
            "name": "Simon",
            "gender": "Male",
            "dob": "23-11-2006",
            "country": "Kenya"
          }

- response :

        {
          "id": 3,
          "name": "Simon",
          "gender": "Male",
          "dob": "23-11-2006",
          "country": "Kenya"
        }

5)DELETE -> Delete Employee:
- endpoint -> http://localhost:8080/api/v1/employees/delete-employee/1
- response:

            Employee deleted with id 1



### Address
1) POST -> Create address:
- - endpoint -> http://localhost:8080/api/v1/address/create-address
- - - body :

          {
            "name": "Nairobi"
          }

- response :

        {
          "id": 1,
          "name": "Nairobi"
        }


2) GET -> Get all address:
- - endpoint -> http://localhost:8080/api/v1/address/address-list
- - - body :

          [
           {
             "id": 1,
             "name": "Nairobi"
           },
           {
             "id": 2,
             "name": "Mombasa"
           }
          ]

3) GET -> Get address by id:
- - endpoint -> http://localhost:8080/api/v1/address/get-address/1
- - - response :

          {
            "id": 1,
            "name": "Nairobi"
          }
4) PUT -> Update address:
- endpoint -> http://localhost:8080/api/v1/address/update-address/1
- - - body :

          {
            "name": "Nairobi 1"
          }

- response :

        {
          "id": 1,
          "name": "Nairobi 1"
        }

5)DELETE -> Delete address:
- endpoint -> http://localhost:8080/api/v1/address/delete-address/1
- response:

            address deleted with id 1

## Relationships
- links: 
    - https://bootify.io/mongodb/document-reference-in-spring-boot-mongodb.html
    - https://spring.io/blog/2021/11/29/spring-data-mongodb-relation-modelling

# CREATING PERSON RELATIONSHIPS: Using Nested obects
1. POST -> create person
endpoint -> http://localhost:8080/api/v1/person/create-person
body request :

        {
            "firstName": "Martin",
            "secondName": "Wainaina",
            "dateOfBirth":"23-11-1999",
            "address": {
                "addressLineOne": "001",
                "addressLineTwo": "002",
                "city": "Nairobi",
                "country": "Kenya"
            },
            "profession": "Software Engineer",
            "salary": 100000,
            "hobbies" : [ 
                {
                "name" : "Badminton"
                }, 
                {
                "name" : "TV"
                }
            ]
        }
- eg
  ![Create Nested Person](images/1CreateNestedPerson.PNG)
- response :

        {
            "firstName": "Martin",
            "secondName": "Wainaina",
            "dateOfBirth":"23-11-1999",
            "address": {
                "addressLineOne": "001",
                "addressLineTwo": "002",
                "city": "Nairobi",
                "country": "Kenya"
            },
            "profession": "Software Engineer",
            "salary": 100000,
            "hobbies" : [ 
                {
                "name" : "Badminton"
                }, 
                {
                "name" : "TV"
                }
            ]
        }
- e.g. 
- ![Create Nested Person Response](images/1CreateNestedPersonResponse.PNG)
