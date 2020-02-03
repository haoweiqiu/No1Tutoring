import axios from "axios";
var config = require("../../config");

var frontendUrl = "http://" + config.dev.host + ":" + config.dev.port;
var backendUrl = "https://" + config.dev.backendHost;
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { "Access-Control-Allow-Origin": frontendUrl }
});

export default {
  name: "ProfilePage",

  data() {
    return {
      names: [],
      times: [],
      registration: [],
      registrations: [],
      studentFeedback: "",
      errorFeedback: "",
      rate: "",
      regTime: "",
      name: "",
      tmpRegTime: ""
    };
  },

  created: function() {
    AXIOS.get(`/tutorial_request/registrations/`, {
      params: {
        studentName: this.$globals.student_name
      }
    })
      .then(response => {
        // JSON responses are automatically parsed.
        this.registrations = response.data;
      })
      .catch(e => {
        this.errorRegistration = e;
      });
  },

  methods: {
    updateTmpTime: function(value) {
      this.tmpRegTime = value;
    },
    openFeedbackOverlay: function(value) {
      this.tmpRegTime = value;
      document.getElementById("feedbackOverlay").style.display = "block";
    },
    closeFeedbackOverlay: function() {
      document.getElementById("feedbackOverlay").style.display = "none";
    },

    createFeedback: function() {
      //error message for 0 length feedback
      if (this.studentFeedback.length === 0) {
        this.errorFeedback = "plz give a piece of feedback to ur tutor!";
        throw new Error("plz give a piece of feedback to ur tutor!");
      }

      //error message for rating is 0
      if (this.rating === 0) {
        this.errorRating = "plz rate ur tutor!";
        throw new Error("plz rate ur tutor!");
      }

      var regTime = this.tmpRegTime;
      var studentFeedback = this.studentFeedback;
      var rate = this.rate;
      var name = this.$globals.student_name;
      AXIOS.post(`/feedback/`, null, {
        params: { rate, regTime, studentFeedback, name }
      })
        .then(response => {
          // JSON responses are automatically parsed.
          this.response = "Successfully created a feedback!";
          document.getElementById("feedbackOverlay").style.display = "none";
        })
        .catch(e => {
          console.log(e.message);
          console.log("error in creating feedback:" + e);
          this.error = e;
        });

      // Refresh the registration list
      AXIOS.get(`/tutorial_request/registrations/`, {
        params: {
          studentName: this.$globals.student_name
        }
      })
        .then(response => {
          // JSON responses are automatically parsed.
          this.registrations = response.data;
        })
        .catch(e => {
          this.errorRegistration = e;
        });
    }
  }
};
