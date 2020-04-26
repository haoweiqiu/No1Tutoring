![image](https://user-images.githubusercontent.com/32343319/69683351-80262d80-1082-11ea-853b-932b0803c85b.png)

### Tutor Management: 
Students are able to manage the tutors by viewing all the tutors in the tutoring system. This is accomplished by a RESTFUL GET requests that render the list of tutors. From there, they can click a tutor and be brought to their profile, where they can view this tutor's information (courses and time slot) of the tutorials associated to them. This is done by executing one GET requests that use the tutorial start time, tutorial end time and tutor's name to retrieve their information from the Database.

### Request Tutorial: 
Tutorial request can be sent to tutors by selecting them from the list on the viewing tutors' page, then selecting the time slot this student want to take the tutorial and lastly select "request tutorial" button. This will direct an overlay where the student view all the information about the tutorial. Clicking confirm and then the students can make a tutorial request by a RESTFUL POST requests that use the tutorial session start time, tutorial end time, tutor's name and student's name.

### Feedback Management:
Students are able to manage to manage the tutor's feedback by viewing all the tutors' feedbacks in the tutoring system. This is accomplished by a RESTFUL GET requests that render the list of feedbacks associated with that specific tutor. From there, they can click feedback and they can view this tutor's feedbacks of the tutorials associated to them. 
### Coures Management:
Students are able to manage to manage all the courses by viewing all the courses in the tutoring system. This is accomplished by a RESTFUL GET requests that render the list of courses in the system. From there, they can click a course and they can view tall the tutors associated with the course.