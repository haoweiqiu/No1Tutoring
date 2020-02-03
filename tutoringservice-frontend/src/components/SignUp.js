import axios from "axios";
import Router from "../router";
var config = require("../../config");

var frontendUrl = "http://" + config.dev.host + ":" + config.dev.port;
var backendUrl = "https://" + config.dev.backendHost;

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { "Access-Control-Allow-Origin": frontendUrl }
});

export default {
  name: "signUp",
  //declare the attribute that is used later
  data() {
    return {
      name: "",
      passwordString: "",
      schoolName: "",
      bgColor: "",
      textColor: ""
    };
  },
  created: function () { },
  methods: {
    createStudent: function () {
      AXIOS.post(`/schools/` + this.schoolName)
        .then(
        //use the restful controoler method to create a new student
        AXIOS.post(
          `/students/` +
          this.name +
          `/` +
          this.schoolName +
          `/` +
          this.passwordString
        )
          .then(response => {
            this.$globals.student_name = this.name;

            Router.push({
              path: "/homepage",
              name: "homepage",
              params: { student_name: this.name }
            });
          })
          .catch(e => {
            var errorMsg = e.message;
            console.log(errorMsg);
            this.errorPerson = errorMsg;
          })
        )
        .catch(e => {
          var errorMsg = e.message;
          console.log(errorMsg);
          this.errorPerson = errorMsg;
        });
    },
    setDarkmode: function () {
      this.bgColor = "rgb(53, 58, 62)";
      this.textColor = "white";
    },
    setLightmode: function () {
      this.bgColor = "rgb(248, 249, 251)";
      this.textColor = "black";
    }
  }
};
