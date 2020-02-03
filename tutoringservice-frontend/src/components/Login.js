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
  name: "login",
  data() {
    return {
      name: "",
      passwordString: "",
      real: "",
      bgColor: "",
      textColor: ""
    };
  },
  created: function() {},
  methods: {
    checkPassword: function() {
      //get the password of the student
      AXIOS.get(`/students/` + this.name).then(response => {
        this.real = response.data;
        if (String(this.real) === String(this.passwordString)) {
          this.$globals.student_name = this.name;
          //change the router to the homepage
          Router.push({
            path: "/homepage",
            name: "homepage"
          });
        } else {
          //else do nothing, the user should continue trying to input password
          console.log("false");
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
