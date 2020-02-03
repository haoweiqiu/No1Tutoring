import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://' + config.dev.backendHost
var AXIOS = axios.create({
    baseURL: backendUrl,
    headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    name: 'tutor_info',
    data() {
        return {
            studentName: "",
            availabilities: ["2018-11-07|18:00", "2018-11-08|21:00", "2018-11-09|20:00", "2018-11-09|21:00", "2019-11-23|19:00", "2019-12-22|10:00", "2019-12-30|11:00", "2019-12-30|12:00"],
            group_availabilities: ["2019-12-08|16:00", "2019-12-09|10:00"],
            selectedAvail: [],
            name: "",
            course: "",
            hour_rate: 30,
            rating: '',
            feedback: [], 
            errorFeedback: '',
            response: '',
            errorTutorialRequest: '',
            createTutorialRequest: "false",
            bgColor : "rgb(248, 249, 251)",
            textColor: "black"
        }
    },
    created: function () {
        this.studentName = this.$globals.student_name;
        this.name = this.$route.params.tutorName;
        this.course = this.$route.params.courseName;
        AXIOS.get(`/all_student_feedbacks/`,{
            params: {
              tutor_name: this.name
            }
        })
        .then(response => {
            // JSON responses are automatically parsed.
            this.feedback = response.data;
            var ratings = response.data.map(x => x.rating);
            this.rating = (ratings.reduce((a,b) => a + b) / ratings.length).toFixed(2);
        })
        .catch(e => {
            this.errorFeedback = e;
        });
    },
    methods: {
        setDarkmode: function(){
          this.bgColor = "rgb(53, 58, 62)";
          this.textColor = "white";
        },
        setLightmode: function(){
          this.bgColor = "rgb(248, 249, 251)";
          this.textColor = "black";
        },
        openNav: function () {
            document.getElementById("myNav").style.display = "block";
        },
        closeNav: function () {
            document.getElementById("myNav").style.display = "none";
            this.errorTutorialRequest = '';
        },
        openNewNav: function () {
          document.getElementById("newNav").style.display = "block";
        },
        closeNewNav: function () {
          document.getElementById("newNav").style.display = "none";
          this.response = '';
        },
        openFeedbackOverlay: function () {
            document.getElementById("feedbackOverlay").style.display = "block";
        },
        closeFeedbackOverlay: function () {
            document.getElementById("feedbackOverlay").style.display = "none";
        },
        createTutorialSession : function () {
            // When request tutorial is clicked, create a session and then a registration in the database.
            if(this.selectedAvail.length == 0){
                this.errorTutorialRequest ="must select!";
                throw new Error("must select!");
            }
            this.selectedAvail.sort(function(a, b){return parseInt(a.substring(11,13)) - parseInt(b.substring(11,13))});
            var lastSelected = this.selectedAvail[this.selectedAvail.length - 1];
            var startTime = this.selectedAvail[0];
            var f = parseInt(lastSelected.substring(11,13)) + 1;
            var finishTime = lastSelected.substring(0,11) + f + lastSelected.substring(13);
            var courseName = this.course;
            var tutorName = this.name;
            var studentName = this.studentName;
            AXIOS.post(`tutorial_request/tutorial_sessions`, {headers: {
                "Content-Type": "application/json"}}, {params: {startTime, finishTime, courseName, tutorName}})
            .then(response=> {
                this.response = 'Successfully created tutorial session!';
                document.getElementById("myNav").style.display = "none";
                document.getElementById("newNav").style.display = "block";
               
                // Create registration
                AXIOS.post(`tutorial_request/registration`, {headers: {
                    "Content-Type": "application/json"}}, {params: {startTime, finishTime, tutorName, studentName}})
                .then(res=> {
                    this.response = 'Successfully created registration!';
                    this.createTutorialRequest = "false";
                  }
                )
                .catch(e => {
                  console.log(e.message);
                  console.log("error in creating registration:" + e);
                  this.error = e;
                })
                }
            )
            .catch(e => {
                console.log(e.message);
                console.log("error in request tutorial:" + e);
                this.error = e;
            })
        }
    }

}
