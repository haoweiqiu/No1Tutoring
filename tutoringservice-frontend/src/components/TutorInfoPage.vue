<template>
  <div v-bind:style="{ backgroundColor : bgColor, color : textColor }">
    <div style="margin-left: 20px">
      <tr align="left">
        <b-row>
          <b-col>Name: {{name}}</b-col>
        </b-row>
      </tr>
      <tr align="left">
        <b-row>
          <b-col>
            Course:
            <select>
              <option value="course">{{course}}</option>
            </select>
          </b-col>
        </b-row>
      </tr>
      <tr align="left">
        <b-row>
          <b-col>Rating: {{rating}}</b-col>
        </b-row>
      </tr>
      <tr align="left">
        <b-row>
          <b-col>Hour rate:{{hour_rate}}$</b-col>
        </b-row>
      </tr>
      <tr align="left">
        <b-row>
          <b-col>
            <button type="button" v-on:click="openFeedbackOverlay">Feedback</button>
          </b-col>
        </b-row>
      </tr>
    </div>

    <div v-bind:style="{ color : textColor }">
      <ul class="grid">
        <h4>One-on-one Availabilities</h4>
        <li v-for="availability in availabilities">
          <input type="checkbox" :value="availability" v-model="selectedAvail" />
          <label>{{availability}}</label>
        </li>

        <h4 style="margin-top: 20px">Group Availabilities</h4>
        <li v-for="availability in group_availabilities">
          <input type="checkbox" :value="availability" v-model="selectedAvail" />
          <label>{{availability}}</label>
        </li>

        <p style="margin-top: 30px">
          Want to request more group tutorials?
          <a
            href="mailto:marwan.kanaan@mcgill.ca"
            target="_top"
          >Email The Manager</a>
        </p>
      </ul>
      <button type="button" v-on:click="openNav">Request Tutorial</button>
    </div>

    <router-link to="/homepage" class="button">Back to Homepage</router-link>
    <button v-on:click="setDarkmode" class="button">Dark mode</button>
    <button v-on:click="setLightmode" class="button">Light mode</button>

    <!-- Tutorial request confirmation overlay -->
    <div id="myNav" class="overlay">
      <!-- Button to close the overlay navigation -->
      <a href="javascript:void(0)" class="closebtn" v-on:click="closeNav">&times;</a>

      <!-- Overlay content -->
      <div class="overlay-content">
        <b-row align-h="center">
          <b-col cols="4">Tutor:</b-col>
          <b-col cols="4">{{name}}</b-col>
        </b-row>
        <b-row>
          <b-col>
            <p></p>
          </b-col>
        </b-row>
        <b-row align-h="center">
          <b-col cols="4">Time:</b-col>
          <b-col cols="4">
            <ul v-for="selected in selectedAvail">{{selected}}</ul>
          </b-col>
        </b-row>
        <b-row align-h="center">
          <b-col cols="4">Fee:</b-col>
          <b-col cols="4">{{hour_rate * selectedAvail.length}}$</b-col>
        </b-row>
        <b-row>
          <b-col>
            <p></p>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <button type="button" v-on:click="createTutorialSession()">Confirm</button>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-badge variant="danger">{{errorTutorialRequest}}</b-badge>
          </b-col>
        </b-row>
      </div>
    </div>

    <div id="newNav" class="overlay">
      <!-- Button to close the overlay navigation -->
      <a href="javascript:void(0)" class="closebtn" v-on:click="closeNewNav">&times;</a>
      <!-- Overlay content -->
      <div class="overlay-content">
        <b-row align-h="center">
          <b-col cols="4">Tutor:</b-col>
          <b-col cols="4">{{name}}</b-col>
        </b-row>
        <b-row>
          <b-col>
            <p></p>
          </b-col>
        </b-row>
        <b-row align-h="center">
          <b-col cols="4">Time:</b-col>
          <b-col cols="4">
            <ul v-for="selected in selectedAvail">{{selected}}</ul>
          </b-col>
        </b-row>
        <b-row align-h="center">
          <b-col cols="4">Fee:</b-col>
          <b-col cols="4">{{hour_rate * selectedAvail.length}}$</b-col>
        </b-row>
        <b-row>
          <b-col>
            <p></p>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-badge variant="success">{{response}}</b-badge>
          </b-col>
        </b-row>
      </div>
    </div>

    <!-- Feedback overlay -->
    <div id="feedbackOverlay" class="overlay">
      <!-- Button to close the overlay -->
      <a href="javascript:void(0)" class="closebtn" v-on:click="closeFeedbackOverlay">&times;</a>

      <!-- Overlay content -->
      <div class="overlay-content">
        <ul>
          <li id="perFeedback" v-for="f in feedback">{{f.comment}}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script src="./TutorInfoPage.js">
</script>

<style>
#tutorInfoPage {
  height: 100%;
}

.grid {
  list-style: none;
  margin: 0 auto;
  padding: 20px;
  text-align: left;
  width: 100%;
}
.grid li {
  display: inline-block;
  position: relative;
  width: 50%;
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

#perFeedback {
  text-align: left;
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
