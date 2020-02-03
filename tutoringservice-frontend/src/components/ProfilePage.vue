<template>
  <div>
    <form>
      <br />
      <h3>View your past registrations:</h3>
      <br />
      <ul id="1">
        <tr v-for="reg in registrations">
          <td>Tutorial time: {{ reg.regTime }}</td>
          <td>
            <div id="app">
              <!-- use the modal component, pass in the prop -->
              <button v-if="reg.isFeedbackGiven != true" id="button" v-on:click="openFeedbackOverlay(reg.regTime)" >Feedback</button>
              <p v-if="reg.isFeedbackGiven == true" style="color: green; margin-left: 20px" >Feedback submitted.</p>
            </div>
          </td>
        </tr>
      </ul>
      <router-link to="/homepage" class="button">Back</router-link>
      <div id="feedbackOverlay" class="overlay">
        <!-- Button to close the overlay -->
        <a href="javascript:void(0)" class="closebtn" v-on:click="closeFeedbackOverlay">&times;</a>

        <!-- Overlay content -->
        <div class="overlay-content">
          <b-row align-h="center">
            <button>{{tmpRegTime}}</button>
          </b-row>
          <br />
            <b-row align-h="center">
              <input type="int" v-model="rate" placeholder="Rating" class="placeholder"/>
            </b-row>
            <br />
            <b-row align-h="center">
              <input type="text" v-model="studentFeedback" placeholder="Feedback" class="placeholder"/>
            </b-row>
            <br />
            <b-row align-h="center">
              <button v-on:click="createFeedback" class="button" >submit your feedback</button>
            </b-row>
        </div>
      </div>
    </form>
  </div>
</template>

<script src="./ProfilePage.js">
</script>

<style>
#ProfilePage {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color: #2c3e50;
  background: #f2ece8;
}
#header {
  text-align: center;
}
.button {
  background-color: #87a6e9;
  border: none;
  color: rgb(255, 255, 255);
  padding: 12px 23px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.placeholder {
  border: 0;
  outline: 0;
  background: white;
  text-align: center;
  border-bottom: 1px solid rgb(110, 108, 108);
  width: 400px;
}
.overlay {
  position: fixed;
  display: none;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 2;
  cursor: pointer;
}

.overlay-content {
  position: relative;
  top: 25%; /* 25% from the top */
  width: 100%; /* 100% width */
  text-align: center; /* Centered text/links */
  margin-top: 30px; /* 30px top margin to avoid conflict with the close button on smaller screens */
}

/* The Overlay (background) */
.overlay {
  /* Height & width depends on how you want to reveal the overlay (see JS below) */
  height: 50vh;
  width: 50vw;
  position: absolute; /* Stay in place */
  top: 25vh;
  left: 25vw;
  z-index: 1; /* Sit on top */
  background-color: rgba(240, 240, 240, 0.9); /* Black w/opacity */
  overflow-x: hidden; /* Disable horizontal scroll */
  transition: 0.5s; /* 0.5 second transition effect to slide in or slide down the overlay (height or width, depending on reveal) */
  display: none;
}

/* Position the content inside the overlay */
.overlay-content {
  position: relative;
  top: 25%; /* 25% from the top */
  width: 100%; /* 100% width */
  text-align: center; /* Centered text/links */
  margin-top: 30px; /* 30px top margin to avoid conflict with the close button on smaller screens */
}

/* The navigation links inside the overlay */
.overlay a {
  padding: 8px;
  text-decoration: none;
  font-size: 36px;
  color: white;
  display: block; /* Display block instead of inline */
  transition: 0.3s; /* Transition effects on hover (color) */
}

/* When you mouse over the navigation links, change their color */
.overlay a:hover,
.overlay a:focus {
  color: white;
}

/* Position the close button (top right corner) */
.overlay .closebtn {
  position: absolute;
  top: 20px;
  right: 45px;
  font-size: 60px;
}

/* When the height of the screen is less than 450 pixels, change the font-size of the links and position the close button again, so they don't overlap */
@media screen and (max-height: 450px) {
  .overlay a {
    font-size: 20px;
  }
  .overlay .closebtn {
    font-size: 40px;
    top: 15px;
    right: 35px;
  }
}
</style>
