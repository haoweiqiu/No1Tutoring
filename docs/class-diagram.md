**I. Class Diagram**
<img width="953" alt="Screen Shot 2019-10-12 at 8 04 45 PM" src="https://user-images.githubusercontent.com/46538726/66709155-97f05f00-ed2b-11e9-848a-a6ab94f91360.png">

**II. Key decisions:** <br/>  
1. The enumeration class SchoolType is created to indicate specific school type(CEGEP, High School or University). <br/>  
2. The enumeration class roomType is created to indicate specific room type(OneToOneRoom or GroupRoom). <br/>  
3. Two associations between the Registration class and the Feedback class are created with different names. One registration may have a student feedback or a tutor feedback. <br/>  
4. The Registration class should connect the Student class, the Feedback class, the Bill class and the Session class. One registration may have one student only, may have two kinds of Feedback (student feedback or tutor feedback), may have one bill and may have only one session. <br/>  
5. The Student class should connect the School class and the Registration class. One student may have one school and may have zero or many registered class in the tutoring system. <br/>  
6. The Tutor class should connect the Course class and the Session class. One tutor may teach zero or many courses and may link to multiple sessions. <br/>  
7. The Subject class connects the School class and the Course class. One subject may be linked to one school only and may have multiple courses. <br/>  
8. The Session class connects the Tutor class, the Registration class, the Course class and the Room class. One session may have one tutor only, may link to one registration, may link to one course and may only use one room. <br/>  
9. The Bill class connects the Registration class. One bill may only associate with one registration. <br/>  
10. The Course class connects the Session class, the Tutor class and the Subject class. One course may associate with multiple sessions, may have multiple tutors and may only have one subject. <br/>  
