
 
                                                 # Marsh Interview - USA
 
  ## API Solution provides the ability to:__
 
 <ol>
     <li>Authentication (Secure API using JWT token)</li>
     <li>Some basic rest API implementation (JWT token needed from first request)</li>
     <li>API communication (WIth some public API on the web) using Feign client.</li>
     <li>Tried handling some exception handling with a couple of different approaches (Mostly for demonstration)</li> 
     <li>Added some of the test cases from controller service and repository level (Only for one whole layer).</li>
     <li>Connected with the h2 database to store the user information.</li>
 </ol>
 All the end points are totally secure in this demo (Other than two /authenticate ). I have implemented JWT security.
 
                                    Method               Request                   Credentials
                                      GET              /test                       [not secure]
                                      PUT              /authenticate               [not secure]
                                      GET              /employee/{employeeId}      [SECURE] 					                  
 
 ###### __Technology Stack:__
 
 1. Spring Boot : https://start.spring.io/
 	
 2. Feign: Declarative REST Client: Feign creates a dynamic implementation of an interface decorated with JAX-RS or Spring MVC annotations.
 	https://cloud.spring.io/spring-cloud-netflix/ 
 3. h2 DB in memory:
 	spring.h2.console.enabled=true
    spring.datasource.platform=h2
    spring.datasource.url=jdbc:h2:mem:authDB
 
 4. Gradle: https://gradle.org/
 5. Mokito/Junit: http://site.mockito.org/ 
 6. Postman: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en 
 
 ###### __Setup instructions:__
 
 1. Java 1.8
 2. IntelliJ  https://www.jetbrains.com/idea/download/#section=windows
 3. Github: Download project from the following git repository
 https://github.com/rohitdec01/marshAssignment.git
 
 a) Download as a ZIP file   OR 
 b) Clone the git project from git-bash or command prompt (You must have git setup)
  
 ###### __Test the project:__
 
 Test cases are present on the following directory. I have written some test cases for controller class and service  class using mokito.
 
 /marshAssignment/src/test/java/com/example/marshAssignment/
 
 To run the test  Go to project folder and trigger following command on the command prompt ( or gitbash). 
 
 ./gradlew test
 
 ###### __To run the application:__
 
 Setup Lombok in IntelliJ  https://projectlombok.org/setup/intellij
 
 Add Curl to your classpath -- C:\Users\rohit\AppData\Local\Programs\Git\mingw64\bin
 
 ./gradlew bootRun
 
 ###### __Check the http Request:__
 
 ## Secure API
 The end point of this application is fully secure. There are 3 users in this application. Any user can be picked to get the JWT token.
 1. test/test 
 2. test1/test1
 3. test3/test3
 
 ======================================================================
 ```
 [POST] http://localhost:9000/authenticate
 JSON Input:  {
              	"userName": "test",
              	"password": "test"
              }
 ```             
 OR use following curl command on the git shell             
 ```            
 curl -X POST \
  http://localhost:9000/authenticate \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 665c1c76-3c60-ccfd-6596-a729150fb48a' \
  -d '{
	"userName": "test",
	"password": "test"
}'    
```
======================================================================
```
http://localhost:9000/employee/10
Header:
Authorization         Bearer [Token will be based on first request(above)]
```
OR use following curl command on the git shell  
```
curl -X GET \
  http://localhost:9000/employee/10 \
  -H 'authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjAzNTAzMjExLCJpYXQiOjE2MDM0NjcyMTF9.yFLzmLm5mNRQDAc95Yl92wfwYTvMEWqzX5D_zYDqL1M' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 8ebd8101-9695-0a62-3006-1fa5b5fc829f'
```   
  ======================================================================       
 
 
 
