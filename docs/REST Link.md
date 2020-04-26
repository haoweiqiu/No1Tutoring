Backend database host: https://tutoringservice-backend-333.herokuapp.com

### Sign up:

**Create a school**: "/schools/{name}", "/schools/{name}/" <br/>  
POST https://tutoringservice-backend-333.herokuapp.com/schools/Concordia<br/>    
<br/>    


**Get all schools**: "/schools", "/schools/"<br/>

GET https://tutoringservice-backend-333.herokuapp.com/schools<br/>    
<br/>    

**Get a school by name**: "/schools/{name}", "/schools/{name}"<br/>

GET https://tutoringservice-backend-333.herokuapp.com/schools/ubc<br/>    
<br/>    

**Create a student**"/students/{name}/{schoolName}", "/students/{name}/{schoolName}"<br/>   

POST https://tutoringservice-backend-333.herokuapp.com/Alex/ubc<br/>    
<br/>    
### Search:

**Get all tutors that teach searched course**: "/tutors_byCourse/{name}", "/tutors_byCourse/{name}/" <br/>  
GET https://tutoringservice-backend-333.herokuapp.com/tutors_byCourse/COMP 202 <br/> 
<br/>     

**Get a tutor by name**: "/tutors/{name}", "/tutors/{name}/" <br/>    
GET https://tutoringservice-backend-333.herokuapp.com/tutors/Erik<br/>   
<br/>   

### Send tutorial request:

**Create a session**: "/tutorial_request/tutorial_sessions", "/tutorial_request/tutorial_sessions/"<br/>   
POST https://tutoringservice-backend-333.herokuapp.com/tutorial_request/tutorial_sessions?startTime=12:38& finishTime=13:38&courseName=COMP 206&tutorName=Erik<br/>   
<br/>     

**Create a registration** "/tutorial_request/registration", "/tutorial_request/registration/"<br/>   
POST https://tutoringservice-backend-333.herokuapp.com/tutorial_request/registration/?startTime=11:23&finishTime=12:23&tutorName=Erik&studentName=Alex<br/> 
<br/>    

**Create a bill**"/tutorial_request/bills", "/tutorial_request/bills/",  <br/>   
POST http://localhost:8080/tutorial_request/bills?amount=99.9&registrationNr=184 <br/>  
<br/>    

### Feedback:

**Student creates feedback for a tutor**: "/feedback", <br/>    
POST https://tutoringservice-backend-333.herokuapp.com/feedback?comment=heisanicetutor!&reg_time=123&studentid=3&rate=5<br/>    
<br/>      
**Show all tutorsfeedbacks of student**: "/tutorFeedbacks", <br/>    
GET https://tutoringservice-backend-333.herokuapp.com/tutorFeedbacks?studentName=mai<br/>    
<br/>    
**Show all studentsfeedback of a tutor**: "/all_student_feedbacks", <br/>    
GET https://tutoringservice-backend-333.herokuapp.com/all_student_feedbacks?tutor_name=Erik Lamela<br/>    
<br/>    