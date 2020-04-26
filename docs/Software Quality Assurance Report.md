# Introduction and Overview
Quality assurance test is defined as an activity to ensure that an organization is providing the best possible product or service to customers. The test plan includes the test for all unit tests for the backend services and the integration test for the restful controller. For the unit tests, we will use the JUnit testing framework, and then we will test the coverage of the code. We aim to achieve 80% of the code in this project.

## Unit Testing 
For the unit testing, we set up a test suite for every service in the backend. Then we run the test suite and analysis the coverage of the code. We have 9 classes in total, and for each class we need to test the class with creating an object which has all valid input, and for each input, we used the equivalence partitioning to test the cases that the input is not valid or null. For each test method in the service test class we used the delete method to delete the object that we create in the database, in this way we test how the delete method work. <br/>  
### 1.Student <br/>  
testCreatePerson() <br/> 
testCreateStudentNull() <br/> 
testCreateStudentSchoolNull() <br/> 

For the test coverage of the studentService, the coverage achieved by the studentMockTest is 91.6%. <br/> 
### 2.School <br/>  
testCreateSchool() <br/> 
testCreateSchoolNameNull() <br/> 

For the test coverage of the schoolService, the coverage achieved by the schoolMockTest is 83.6%. <br/> 
### 3.Tutor<br/> 
testCreateTutor()<br/> 
testCreateTutorNameNull()<br/> 

For the test coverage of the tutorService, the coverage achieved by the subjectMockTest is 90.4%. <br/> 

### 4.Registration<br/> 
testCreateRegistration()<br/> 
testCreateRegistrationNameNull()<br/> 
For the test coverage of the registrationService, the coverage achieved by the subjectMockTest is 90.1%. <br/> 
### 5.Session<br/> 
testCreateSession()<br/> 
For the test coverage of the SessionService, the coverage achieved by the roomMockTest 100%.<br/> 

### 6.Subject<br/> 
testCreateSubject()<br/> 
testCreateSubjectNameNull()<br/> 
For the test coverage of the SubjectService, the coverage achieved by the roomMockTest 90.9%.<br/> 

### 7.Room<br/> 
testCreateRoom()<br/> 
testCreateRoomIdNull()<br/> 
For the test coverage of the roomService, the coverage achieved by the roomMockTest 78.6%.

### 8.Bill<br/> 
testCreateBill()<br/> 
testCreateBillAmountNeg()<br/> 
testCreateBillRegistrationNull()<br/> 
testDeleteBill()<br/> 
testDeleteBillByAmount() <br/> 
For the test coverage of the roomService, the coverage achieved by the roomMockTest 100%.<br/> 

### 9.Feedback<br/>
testCreateFeedback()<br/>
testCreateStudentNull()<br/>
testCreateFeedbackNull()<br/>
For the test coverage of the FeedbackService, the coverage achieved by the roomMockTest 100%.<br/> 

## Integration Test<br/> 
For the integration test, the test plan we made is to use PostMan to test every single controller and see the respond results, in this way we can assure that we coverage every method just as the unit test.<br/> 

### 1. Sign up <br/> 
GET http://localhost:8080/schools<br/> 
GET http://localhost:8080/schools/McGill<br/> 
POST http://localhost:8080/schools/Concordia<br/> 
POST http://localhost:8080/students/Alex/McGill<br/> 

### 2. Get all tutors that teach searched course: <br/> 
GET https://tutoringservice-backend-333.herokuapp.com/tutors_byCourse/COMP 202 

### 3. Get a tutor by name:<br/> 
GET http://localhost:8080/tutors/Erik<br/>   
### 4. Send tutorial request:<br/> 
Create a session: POST http://localhost:8080/tutorial_sessions?startTime=12:38&courseName=COMP 206&tutorName=Erik<br/>   
    
Create a registration:POST https://tutoringservice-backend-333.herokuapp.com/tutorial_request/registration/?startTime=11:23&finishTime=12:23&tutorName=Erik&studentName=Alex<br/> 
<br/>
Create a bill:POST http://localhost:8080/tutorial_request/bills?amount=99.9&registrationNr=184<br/>
### 5. Student creates feedback for a tutor:<br/> 
Student creates feedback for a tutor:POST http://localhost:8080/feedback?comment=heisanicetutor!&reg_time=123&studentid=3&rate=5<br/>    

Show all tutorsfeedbacks of student:GET http://localhost:8080/tutorFeedbacks?studentName=mai<br/>
<br/>
Show all studentsfeedback of a tutor:GET http://localhost:8080/all_student_feedbacks?tutor_name=Erik Lamela<br/>   

Note: Although the controller works in the Postman by giving valid url input, we did not test the controller in JUnit test, so the coverage is 0% for the data transfer object. For increasing the coverage of the code in the JUnit test in the future, more JUnit test for testing the controller is needed.<br/> 

## Summary for the Software coverage and assurance
![1661572501115_ pic](https://user-images.githubusercontent.com/46538726/67922401-0aad6700-fb81-11e9-9700-45b63cc19190.jpg)<br/> 
For the summary of the coverage, the services package and the testing package has a higher coverage compared with the data transfer object and the model package. The main reason for that is because all restful controller methods are tested by the Postman. As a consequence, the controller methods and data transfer object denotes 0 percent coverage. On the other hand, the coverage of the code in the model package, service package have coverage 98% and 90.1% respectively. (Note that Roomtype class and SchoolType class are both enumeration classes, which denotes relatively low coverage.) The test package also have a coverage of 83.7%, which is higher than our expectation as well. We believe that if the restful controller was tested in the JUnit test framework as well, the goal of achieving 80% could be achieved. In conclusion, the goal of higher than the 80% coverage is generally achieved in most packages, although the dto and controller packages have relatively low coverage.
