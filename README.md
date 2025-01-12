Forum Hub
This backend app provides the basic elements to develop a forum for creating topics and questions about courses previously registered.

App Functions:
- Register a user
- Log in a user
- Create a course
- Create a topic related to a course
- Answer a topic
- Modify a topic
- Delete a topic and its related answers
- Retrieve information about a topic in the database

Note:
- The file Insomnia__HTTP_Request.json must be imported into the Insomnia App to access the available HTTP requests for the app, or go to serverPath/swagger-ui/index.html.
- Before running the app, it is necessary install mysql and mysqlWorkBench to create a databese, then set the URL, username, password, and other database details in the application.properties file.
- To send requests other than login or sign-up from Insomnia, the user must first be registered and logged in (the register is in a loca database).

Project made by Juan Mario Ayala A.