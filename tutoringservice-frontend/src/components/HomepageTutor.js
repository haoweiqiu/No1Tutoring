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
 * @param String email
 * @param Session name
 */
function TutorDto(email, name) {
  this.name = name;
  this.email = email;
}
export default {
  name: "homepagetutor",
  data() {
    return {
      searchKey: "",
      tutors: [],
      newTutor: "",
      errorTutor: "",
      response: [],
      tutorFound: "",
      bgColor: "",
      textColor: ""
    };
  },
  created: function() {
    // Test data
    // const p1 = new TutorDto("Caroline", "caroline@mail.mcgill.ca");
    // const p2 = new TutorDto("Poline", "poline@mail.mcgill.ca");
    // const p3 = new TutorDto("Alex", "alex@mail.mcgill.ca");
    // Sample initial content
    // this.tutors = [p1, p2, p3];
    this.tutors = [];
  },
  methods: {
    createTutor: function(tutorName) {
      // Create a new Tutor and add it to the list of Tutors
      var p = new TutorDto(tutorName);
      this.tutors.push(p);
      // Reset the name field for new Tutors
      this.newTutor = "";
      // AXIOS.get(`/tutors/` + "Jason")
      //   .then(response => {
      //     // JSON responses are automatically parsed.
      //     this.tutors = response.data;
      //   })
      //   .catch(e => {
      //     this.errorTutor = e;
      //   });
    },
    searchTutor: function(tutorName) {
      this.tutorFound = "";
      var url = "/tutors/" + tutorName;
      AXIOS.get(url)
        .then(response => {
          // Since our search tutor by name only does by exact match, thus the reponse will be only one tutor
          this.tutorFound = response.data.name;
          this.newTutor = "";
          this.errorTutor = "";
        })
        .catch(e => {
          var errorMsg = e.message;
          console.log(errorMsg);
          this.errorTutor = "Tutor does not exist";
        });
    },
    gotoTutorInfoPage: function(tutorName) {
      Router.push({
        path: "/tutor_info",
        name: "TutorInfoPage",
        params: {
          tutorName: tutorName,
          courseName: "ECSE 223"
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
