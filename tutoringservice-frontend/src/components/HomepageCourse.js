import axios from "axios";
import Router from "../router";

var config = require("../../config");
var frontendUrl = "http://" + config.dev.host + ":" + config.dev.port;
var backendUrl = "https://" + config.dev.backendHost;
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { "Access-Control-Allow-Origin": frontendUrl }
});

/**
 * Create Tutor data transfer object
 *
 * @param Tutor tutor
 * @param Session session
 * @param Subject subject
 * @param String name
 */
function CourseDto(tutor, session, subject, name) {
  this.tutor = tutor;
  this.session = session;
  this.subject = subject;
  this.name = name;
}
// function TutorDto(name, email, course) {
//   this.name = name;
//   this.email = email;
//   this.course = course;
// }
function TutorDto(name, email) {
  this.name = name;
  this.email = email;
}

export default {
  name: "homepagecourse",
  data() {
    return {
      searchKey: "",
      student_name: "",
      tutors: [],
      newTutor: "",
      errorTutor: "",
      response: [],
      tutorsFound: [],
      bgColor: "",
      textColor: ""
    };
  },
  created: function() {},
  methods: {
    createCourse: function(courseName) {
      // Create a new Course and add it to the list of courses
      var p = new CourseDto(courseName);
      this.courses.push(p);
      // Reset the name field for new courses
      this.newCourse = "";
    },
    searchTutorByCourse: function(courseName) {
      this.tutorsFound = [];
      var url = `/tutors_byCourse/` + courseName;
      AXIOS.get(url)
        .then(response => {
          // JSON responses are automatically parsed.
          this.tutorsFound = response.data;
          this.newTutor = "";
          this.errorTutor = "";
        })
        .catch(e => {
          var errorMsg = e.message;
          console.log(errorMsg);
          this.errorTutor = errorMsg;
        });
    },
    gotoTutorInfoPage: function(tutorName) {
      Router.push({
        path: "/tutor_info",
        name: "TutorInfoPage",
        params: {
          tutorName: tutorName,
          courseName: this.searchKey
        }
      });
    },
    setDarkmode: function() {
      this.bgColor = "rgb(53, 58, 62)";
      this.textColor = "white";
    },
    setLightmode: function() {
      this.bgColor = "rgb(248, 249, 251)";
      this.textColor = "black";
    }
  }
};
