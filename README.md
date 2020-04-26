# project-group-1 [![Build Status](https://travis-ci.com/McGill-ECSE321-Fall2019/project-group-1.svg?token=MNHYeoanUP1gwd2Xhaqy&branch=master)](https://travis-ci.com/McGill-ECSE321-Fall2019/project-group-1)[![Documentation Status](https://readthedocs.org/projects/no1-Tutoring/badge/?version=latest)](https://no1-tutoring.readthedocs.io/en/latest/?badge=latest)

This repository is a copy from the ECSE 321 Intro to Software Engineering Group Project. The original project repository was set to private access. <br  /> 
Hi everyone, welcome to our group 1 repo. Our group consists of 5 passionate and enthusiastic Software and Computer Engineering students. <br /><br /> 
This projects would demonstrate our comprehension on software system and development. The term-long projects is evenly distributed into 5 deliverables respectively:<br  /> 

Frontend Heroku:https://no1tutoring.herokuapp.com/#/<br />  
Backend Heroku for testing the frontend: https://dashboard.heroku.com/apps/tutoringservice-backend-666 (For deliverable 3, we made up some data which are retrieved from other view points.)<br />  
Backend Heroku for running backend tests: https://tutoringservice-backend-333.herokuapp.com<br />  

## Deliverable1-- requirement model, domain model, persistence layer, building system, continous integration.<br /> 

|Names   |Team roles and responsiblities   |Personal Contribution in hours   |
|---|---|---|
|Wenhao Geng|Project Manager: is responsible for the integration of the project, test suite of the persistence.|32 hrs|
|Yuhang Zhang   |Software engineer: is responsible for the database design, and the test suite of the persistence.   |30 hrs   |
|Zheyu Liu   |Software engineer:is reponsible for the domain model design, and use case diagram.<br />   |30 hrs | 
|Mai Zeng   |Software engineer:is responsible for the build system, and the test suite of the database.<br />   |30 hrs   | 
|Haowei Qiu   |Software engineer: is responsible for the implementation of the domain model.<br />   |30 hrs   | 




Additionally, each team member is responsible for one detailed use case description, and one team member is responsible for the group report for each meeting. 
  

## Deliverable2--Beckend Services, Behavior Modeling, and Testing</br>  

Name | Team roles |Personal Contribution in hours 
------------ | -------------| -------------
Wenhao Geng| Software Lead| 33 hrs
Mai Zeng|Software Engineer| 32 hrs
Zheyu Liu | Software Engineer | 32 hrs
Yuhang Zhang|Software Engineer| 29 hrs
Haowei Qiu|Software Engineer | 31 hrs

### Description of the tasks in deliverable 2
Backend database host: https://tutoringservice-backend-333.herokuapp.com</br> 
We implemented the backend and the evolution of the persistence layer. We also updated the project wiki to describe the restful services. </br> 
https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Group-Report-For-Deliverable-2</br>  
The software quality assurance plan and its report. 
https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Software-Quality-Assurance-Plan-and-Report</br>  
Unit tests of the backend for every class.</br>  
Integration tests of the backend service.(We used PostMan and Advanced REST client to test the restful API)
https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Integration-test-of-the-restful-controller</br>  
The build system, continuous integration and deliverary.   
The project report of the deliverable 2 is added. The issue in the deliverable 2 are updated.https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Restful-Service-Document</br>  
### Responsiblity details of diliverable 2:
#### Individual contributions to implement the controller class and dto classes: (Each team member is responsible for 1 || 2 features)</br>  
Name | Feature Responsibility | Dto Responsibility | Other Responsibilities
----|--------|-------|------
**Zheyu Liu** | Signing up, Logging | "School"; "Student" dtoes | Reponsible for constructing the convertTo()(for the student and school, other methods related to these two features. </br>  
**Wenhao Geng**  **Mai Zeng** | Sending tutorial request | "Room"; "Session"; "Bill" dtoes | Responsible for constructing TutorialRequestRestController which includes createTutorialSessionDto(), createRegistrationDto(), and createTutorialBillDto() as post mapping for Restful API call. </br>  
**Haowei Qiu** | Search courses, Search tutors | "Subject"; "Tutor"; "Course" dtoes | Responsible for constructing the search courses and search tutors feature in the searchActionRestController, as well as the implementation of TutorDto, SubjectDto and CourseDto. </br>  
**Yuhang Zhang** | Providing feedback, Seach feedback | "Registration"; "Feedback" dtoes | Responsible for constructing createStudentFeedback(); getTutorFeedback(); getAllStudentFeedbacks() and 2 convertToDto() functions. </br>  


#### For the unit test, each team member is assigned to one or two classes:</br>  
Name | Unit Tesing Responsibilities | RESTful Service Testing Responsibilities
-----|-----|----
**Zheyu Liu** | Testing the updated school service and student service | Testing the RESTful controller createSchool, create Student, getAllSchools, getSchoolByName with PostMan. </br>    
**Haowei Qiu** | Testing the updated subject service, tutor service and course service | Testing the RESTful controller createCourse and getCourseByName with Advanced REST client. </br>    
**Wenhao Geng** | Testing the updated registration service and room service | Testing the RESTful controller with PostMan. </br>    
**Yuhang Zhang** | Testing the updated Bill service and Feedback service | Testing the RESTful controller createFeedback, getAllFeedback with Advanced REST client. </br>    
**Mai Zeng** | Testing the update Session service | Testing the RESTful controller of createBill and createSession with Postman. </br>

#### For the dcoumentation:
**Zheyu Liu** Responsible for the ReadMe.md, software assuance and quality report, and the group report 2.<br>
**Wenhao Geng** Responsible for creating the API service call documentation. (Available in Wiki.)<br>
**Haowei Qiu** Responsible for updating Group Report (Available in Wiki) and README.md. <br>
**Yuhang Zhang** Responsible for updating the README.md. <br>
**Mai Zeng** Responsible for software assurance and quality report.

## Deliverable3-- Architecture modelling, implementation of frontend, integration of frontend and backend, build system and integration system(including the heroku for the frontend), and group management.  </br>  

Name | Team roles |Personal Contribution in hours 
------------ | -------------| -------------
Wenhao Geng| Software Lead| 40 hrs
Mai Zeng|Software Engineer| 35 hrs
Zheyu Liu | Software Engineer | 35 hrs
Yuhang Zhang|Software Engineer| 35 hrs
Haowei Qiu|Software Engineer | 35 hrs

Frontend Heroku:https://no1tutoring.herokuapp.com/#/<br />  
Backend Heroku for testing the frontend: https://dashboard.heroku.com/apps/tutoringservice-backend-666 (For deliverable 3, we made up some data which are retrieved from other view points.)<br />  
Backend Heroku for running backend tests: https://tutoringservice-backend-333.herokuapp.com<br />  
#### For the Frontend, each memeber is assigned with specific webpage implementation task:</br>  
Name | Frontend and relevant controller methods responsibilities 
-----|-----
**Zheyu Liu** | Implementation of the Sign up and Login Page. Update the restful controller method for the school and student.(Add getStudentPassword, and modified the createStudent from last deliverable)</br>    
**Haowei Qiu** | Implementation of the Homepage, Homepagecourse and Homepagetutor. </br>    
**Wenhao Geng** | Implementation of the tutor info page, merge all pages implemented and deploy frontend to Heroku. </br>    
**Yuhang Zhang** | Implementation of the student profile page. Update TutoriaRequlestRestController and FeedbackRestController. </br>    
**Mai Zeng** | Implementation of the tutor info page. Implementation of the student profile page. Modified create sessions in the babckend. Implement create registration for the frontend.</br>

#### For the Documentation:</br>  
Name | Documentation Responsibilities
-----|-----------
**Zheyu Liu** | In charge of finishing group report and create testing document. </br>    
**Haowei Qiu** | In charge of updating README for deliverable 3. </br>    
**Wenhao Geng** | In charge of modifying testing document. </br>    
**Mai Zeng** | In charge of Architecture modelling document. </br>
</br>  
Testing document for deliverable 3: https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Testing-document-for-deliverable-3 </br>  
Architecture Model:https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Architecture-Model  </br>  
Group report for deliverable: https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Group-Report-for-deliverable-3 </br>  

## Deliverable4</br>  
Name | Team roles |Personal Contribution in hours 
------------ | -------------| -------------
Wenhao Geng| Software Lead| 20 hrs
Mai Zeng|Software Engineer| 24 hrs
Zheyu Liu | Software Engineer | 18 hrs
Yuhang Zhang|Software Engineer| 18 hrs
Haowei Qiu|Software Engineer | 18 hrs

User documentation: https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/User-Documentation<br />  
Group Report:https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Group-Report-for-deliverable-4<br />  
Extra features: https://github.com/McGill-ECSE321-Fall2019/project-group-1/wiki/Extra-features<br /> 
Frontend Heroku:https://no1tutoring.herokuapp.com/#/<br />  
Backend Heroku for testing the frontend: https://dashboard.heroku.com/apps/tutoringservice-backend-666 (For deliverable 3, we made up some data which are retrieved from other view points.)<br />  
Backend Heroku for running backend tests: https://tutoringservice-backend-333.herokuapp.com<br />  

#### For the Android, each memeber is assigned with one function:</br>  
Name | Frontend and relevant controller methods responsibilities 
-----|-----
**Zheyu Liu** | Implement of the Login and update the related controller methods.</br>    
**Haowei Qiu** | Implement of the Tutorial request and update the related controller methods..</br>    
**Wenhao Geng** | Implement of the Search tutor and update the related controller methods.. </br>    
**Yuhang Zhang** | Implement of the Feedback and update the related controller methods.. </br>    
**Mai Zeng** | Set up the Android project and the integration of all pages and update the related controller methods.. </br>

#### For the Documentation:</br>  
Name | Documentation Responsibilities
-----|-----------
**Zheyu Liu** | In charge of Readme, group report. </br>    
**Haowei Qiu** | In charge of User Documentation. </br>    
**Wenhao Geng** | In charge of Group Report. </br>    
**Mai Zeng** | In charge of Readme. </br>

## Deliverable5</br>  
