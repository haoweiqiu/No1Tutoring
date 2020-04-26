| Use Case 1          | Author:           Haowei Qiu                                 |
| ------------------- | ------------------------------------------------------------ |
| Use Case Name       | Sign up in the system                                        |
| Traceability        | REQ1                                                         |
| Actor(s)            | Student                                                      |
| Summary Description | The system shall allow student to sign up an account.        |
| Priority            | High                                                         |
| Pre-Condition       | 1. The student has a valid id.                               |
| Post-Condition      | Success: The student could create a new account.<br />Fail: The student shall not create a new account. |
| Main Flow           | 1. The student clicks the "Sign up" button.<br />2. Tutoring system displays information that needs to be filled in the Sign up page. <br />3. The student fills in his/her name.<br />4. The student fills in his/her email.<br />5. The student choose his/her school.<br />6. The student fills in his/her password.<br />7. The student clicks the submit button.<br />8.  The student receives confirmation of successful sign up. |
| Alternative Flow    | 2a. The sign in page shall not be loaded.<br />1. The student clicks the "Sign up" button.<br />8a. The Student fails to sign up in the system. <br />1. The student clicks the "Sign up" buttion. <br />2. The student fills in the Sign up page.<br />3. The student clicks the submit button.|

| Use Case 2          | Author:Zheyu Liu                                             |
| ------------------- | ------------------------------------------------------------ |
| Use Case Name       | Search Course                                                |
| Traceability        | REQ3                                                         |
| Actor(s)            | Student                                                      |
| Summary Description | The system shall allow the student to search for a specific course |
| Priority            | High                                                         |
| Pre-Condition       | 1. The student has a valid user account in the system.       |
| Post-Condition      | Success: Student should be able to obtain a course detail information.<br />Fail: Student could not obtain a course detail information. |
| Main Flow           | 1. Student clicks search subjects button.<br />2. Tutoring System prefills the school of the student from the profile of the student.<br />3. Tutoring system displays a list of all subjects with available tutors.<br />4. Student selects a subject and clicks on this subject hyperlink.<br />5. Tutoring system displays a list of courses with available tutors.<br />6. Student selects a course and clicks on this course hyperlink. <br />7. The system displays the description of this course and available tutors for this course. |
| Alternative Flow    | 4a. Student finds that there is no required subject in the list.<br />1. Student clicks on the NEW SUBJECT button.<br />2. Student fills the name of this subject.<br />6a Student finds that there is no required course in the list.<br />1. Student clicks on the NEW COURSE button.<br />2. Student fills the name of this course. |

| Use Case 3          | Author: Mai Zeng                                             |
| ------------------- | ------------------------------------------------------------ |
| Use Case Name       | Seach tutor                                                  |
| Traceability        | REQ2                                                         |
| Actor(s)            | Student                                                      |
| Summary Description | The system shall allow student to view the tutor's profile.  |
| Priority            | High                                                         |
| Pre-Condition       | 1. The student has a valid student account in the system.<br />2. The tutor has a valid user account in the system. |
| Post-Condition      | Success: The student should be able to view the tutor's profile.<br />Fail: The student could not view the tutor's profile. |
| Main Flow           | 1. Student logs in the system using their valid account and password.<br />2. System redirects to the student's home page.<br />3. Student clicks the Tutor tab located on the left side of the web page.<br />4. System redirects to the Tutor page.<br />5. System loads a list of tutors. |
| Alternative Flow    | 1a. Student provides an invalid account or password. The system then displays a message, suggesting the user to provide a valid email and password.<br />3a. The system fails to load a list of subjects.<br />3b. Student cannot find the tutor. |

| Use Case 4     | Author: Wenhao Geng                                      |
| ------------------- | ------------------------------------------------------------ |
| Use Case Name       | Send tutorial request                                        |
| Traceability        | REQ6,7,8,9,10,11,12,13                                       |
| Actor(s)            | Student                                                      |
| Summary Description | The system shall allow the student to send his/her tutorial request and get a response about the tutorial request. |
| Priority            | High                                                         |
| Pre-Condition       | 1.The student has logged in to the system. <br />2.The student has searched for a course/subject or a specific tutor. <br />3.The student has selected a tutor to view his/her profile.  <br />4.The student has clicked “send tutorial request” which brings the student to tutorial request form. |
| Post-Condition      | Success: Confirmation and details of scheduled tutorial. <br />Fail: Student’s tutorial request is rejected. |
| Main Flow           | 1. The student enters the tutorial request form.<br />2. The student selects one-on-one tutorial or group tutorial. <br />3. Tutoring system sends tutorial requests to interested parties. <br />4. Tutoring system sends request response to the student. |
| Alternative Flow    | 2a. Tutoring system finds out that the student selected one-on-one tutorial.<br />1. Tutoring system shows tutor’s availability time table.         <br />2. The student selects a time slot.   <br />2b. Tutoring system finds out that the student selected group tutorial.         <br />1. Tutoring system shows exiting group tutorials and the option to request a new group tutorial.         <br />2. Tutoring system prompts tutor’s availability time table to request a new group tutorial if the student does not want to join existing group tutorials.         <br />3. The student selects a time slot.  <br />3.a Tutoring system finds out the student requested a group tutorial <br />3.a.a Tutoring system finds out the student requested a new group tutorial.         <br />1. Tutoring system sends an email to manager to ask for group session room assignment.         <br />2. Tutoring system sends an email to tutor to confirm his/her availability of the selected time slot. <br />3.a.b Tutoring system finds out the student selected an existing group tutorial session with empty space.         <br />1.Tutoring System sends a confirmation email of the tutorial to the student with information including tutor’s name selected course/subject, rate, tutorial type, time, and room number.  <br />3.b Tutoring system finds out the student requested an one-on-one tutorial. <br />3.b.a Tutoring system finds out there is no available one-on-one room.         <br />1. Tutoring system navigates the student back to homepage, suggesting only group session is available to join. <br />3.b.b Tutoring system finds out there is one-on-one room available.         <br />1. Tutoring system sends an email to tutor to confirm his/her availability of the selected time slot.<br />4.a The tutorial is rejected by the tutor.         <br />1. The system sends an e-mail with a link of the homepage and ask the student to reschedule his/her tutorial. <br />4.b The tutorial is accepted by the tutor.         <br />1. Tutoring System sends a confirmation email of the tutorial to the student with information including tutor’s name selected course/subject, rate, tutorial type, time, and room number. <br />4.c The new group tutorial request is declined by the manager as there is no available group tutorial room.         <br />1. The system sends an e-mail with a link of the homepage and asks the student to join the one-on-one tutorial or existing group tutorial. |




| Use Case 5          | Author: Yuhang Zhang                                         |
| ------------------- | ------------------------------------------------------------ |
| Use Case Name       | Provide feedback on tutor                                    |
| Traceability        | REQ14                                                        |
| Actor(s)            | Student                                                      |
| Summary Description | The system shall allow student to provide feedback on a specific tutor |
| Priority            | High                                                         |
| Pre-Condition       | 1. The student has a valid student account in the system.<br />2. The tutor has a valid tutor account in the system. |
| Post-Condition      | Success: The student could give the feedback to this tutor.<br />Fail: The student could not give the feedback to the tutor. |
| Main Flow           | 1.	The student clicks on the “homepage” button from the top right of the webpage<br/>2.	The system directs the user to his/her home page<br/>3.	The student clicks on the button “view past tutorial sections” from the bottom part of the student home page.<br/>4.	The system directs the user to “past-tutorials” web page where student’s past taken tutorials sections are listed.<br/>5.	Student selects a specific tutorial section and click on it.<br/>6.	The system directs the user to this specific tutorial section page <br/>7.	The user clicks on “give a feedback” button.<br/>8.	Tutoring system offers the student a blank text box and a submit button.<br/>9.	Student types texts in the text box and click “submit” button. <br/>10.	Tutoring system turns to a temporary webpage displaying “submit successfully” for 5 seconds.<br/>11.	Tutoring system turns the temporary webpage to the students’ home page. |
| Alternative Flow    | 6a. Student is not willing to give feedback to tutor at the moment.<br/>1. Student clicks the “exit” button.<br/>2. The system directs the current webpage to the “past-tutorials” web page.<br/>6b Student has provided a feedback to this tutor of this tutorial section. <br/>1.	The system would display sections’ time, tutor name, student name, feedback on the web page.<br/>2.	Student clicks the “exit” button.<br/>3.	The system directs the current webpage to the “past-tutorials” web page.<br/>8a. Student is not willing to give feedback to tutor at the moment.<br/>1. Student clicks the “exit” button.<br/>2. Tutoring system turns the current webpage to the “past-tutorials” web page.<br/>9a. Submission is not successfully.<br/>1. Tutoring system turns the current webpage to the students’ home page. |



