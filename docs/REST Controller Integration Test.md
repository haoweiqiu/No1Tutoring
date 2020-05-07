The integration test includes not only the implementation of the requirements described, but also consider the api for the manager and tutor's view point.
## Integration test of the restful controller for the our own functions.
### Sign up

**Create a school**: "/schools/{name}", "/schools/{name}/" <br/>  
<img width="406" alt="Screen Shot 2019-10-27 at 5 17 49 PM" src="https://user-images.githubusercontent.com/46538726/67642009-d7977900-f8dd-11e9-90b1-e999802e30b8.png">


**Get all schools**: "/schools", "/schools/"<br/>

<img width="374" alt="Screen Shot 2019-10-27 at 5 20 22 PM" src="https://user-images.githubusercontent.com/46538726/67642053-64dacd80-f8de-11e9-9c20-b41086a169bf.png"><br/>  
**Get a school by name**: "/schools/{name}", "/schools/{name}"<br/>
<img width="377" alt="Screen Shot 2019-10-27 at 5 18 21 PM" src="https://user-images.githubusercontent.com/46538726/67642010-d7977900-f8dd-11e9-9efb-0d8873c7fc77.png"><br/>  
**Create a student** (need to pass in an existing school name): "/students/{name}/{schoolName}", "/students/{name}/{schoolName}"<br/>

<img width="392" alt="Screen Shot 2019-10-27 at 5 22 03 PM" src="https://user-images.githubusercontent.com/46538726/67642054-64dacd80-f8de-11e9-8b19-42a0a2ae9546.png"><br/>  
### Search

**Get all tutors that teach searched course**: "/tutors_byCourse/{name}", "/tutors_byCourse/{name}/"<br/>
Manually added two tutors Amanda and Kenza to both teach COMP 202: <br/>
![Screen Shot 2019-10-30 at 10 59 51 PM](https://user-images.githubusercontent.com/23584135/67915782-2eb17e00-fb6a-11e9-8c3e-61092db84371.png)   


![Screen Shot 2019-10-30 at 11 01 05 PM](https://user-images.githubusercontent.com/23584135/67915833-54d71e00-fb6a-11e9-966e-0f7ce0681a1d.png)
 <br/>

**Get a tutor by name**: "/tutors/{name}", "/tutors/{name}/" (This should change to get tutors whose names contain the query keyword. Ex: name - Mi should return not only the tutor whose name is Mi, but also such as Michael, Michelle...)<br/>
![image](https://user-images.githubusercontent.com/42322196/67816055-1e70a480-fa7f-11e9-80aa-6b8cc78ccecb.png) <br/>

### Send tutorial request

**Create a session**: "tutorial_request/tutorial_sessions", "tutorial_request/tutorial_sessions/", @RequestParam(name = "startTime"), @RequestParam(name = "finishTime"), @RequestParam(name = "tutorName"), @RequestParam(name = "courseName"). <br/>
![image](https://github.com/McGill-ECSE321-Fall2019/project-group-1/blob/master/Sprint1/Detailed%20User%20Case/createSessionUrl.png)</br>
<img src="https://github.com/McGill-ECSE321-Fall2019/project-group-1/blob/master/Sprint1/Detailed%20User%20Case/createSessionResult.png" width="200">

**Create a registration**(The session has to be created first): "tutorial_request/registration", "tutorial_request/registration/", @RequestParam("startTime"), @RequestParam("finishTime"), @RequestParam("tutorName"), @RequestParam("studentName") 
![Screen Shot 2019-10-31 at 12 19 55 AM](https://user-images.githubusercontent.com/23584135/67918841-658c9180-fb74-11e9-9786-73ab07896dac.png)<br/> 

**Create a bill**(The registration has to be created first): "tutorial_request/bills", "tutorial_request/bills/", @RequestParam(name="amount"), @RequestParam(name="registrationNr") 
![Screen Shot 2019-10-31 at 12 41 25 AM](https://user-images.githubusercontent.com/23584135/67919558-388dae00-fb77-11e9-85b8-1386285df6e2.png)<br/>

### Feedback

**Student creates feedback for a tutor**: "/feedback", @RequestParam(name = "comment"), @RequestParam(name = "reg_time"), @RequestParam(name = "studentid"), @RequestParam(name = "rate")
<img width="913" alt="createStudentFeedback()" src="https://user-images.githubusercontent.com/30118361/67913059-3836e800-fb62-11e9-9c3e-8e2fed1c0352.png">
**Show all tutorsfeedbacks of student**: "/tutorFeedbacks", @RequestParam("studentName")
<img width="881" alt="getTutorFeedback()" src="https://user-images.githubusercontent.com/30118361/67913089-47b63100-fb62-11e9-9c07-808cf7a39a58.png">
**Show all studentsfeedback of a tutor**: "/all_student_feedbacks", @RequestParam("tutor_name")
<img width="907" alt="getAllStudentFeedbacks()" src="https://user-images.githubusercontent.com/30118361/67913084-44bb4080-fb62-11e9-99ce-aecd8563dfef.png">

## Integration test for the other teams
**Get all schools(for tutor's view point)**: "/schools", "/schools/"<br/>
<img width="374" alt="Screen Shot 2019-10-27 at 5 20 22 PM" src="https://user-images.githubusercontent.com/46538726/67642053-64dacd80-f8de-11e9-9c20-b41086a169bf.png"><br/>  

**Get a tutor by name(for manager's view point)**: "/tutors/{name}", "/tutors/{name}/" (This should change to get tutors whose names contain the query keyword. Ex: name - Mi should return not only the tutor whose name is Mi, but also such as Michael, Michelle...)<br/>
![image](https://user-images.githubusercontent.com/42322196/67816055-1e70a480-fa7f-11e9-80aa-6b8cc78ccecb.png) <br/>

**Show all tutorsfeedbacks of student(for tutor's view point)**: "/tutorFeedbacks", @RequestParam("studentName")
<img width="881" alt="getTutorFeedback()" src="https://user-images.githubusercontent.com/30118361/67913089-47b63100-fb62-11e9-9c07-808cf7a39a58.png">