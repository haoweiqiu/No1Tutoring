<template>
  <div id="homepagecourse" v-bind:style="{ backgroundColor : bgColor }">
    <h2 id="header" v-bind:style="{ color : textColor }">Welcome! {{this.$globals.student_name}}</h2>
    <br />
    <br />
    <br />
      
    <button @click="setDarkmode" class="button">Dark mode</button>
    <button @click="setLightmode" class="button">Light mode</button>
    <br />
    <form>
      <br />
      <br />
      <h3 v-bind:style="{ color : textColor }">I would like to take:</h3>
      <br />
      <input type="text" v-model="searchKey" placeholder="Course Name" class="placeHolder" />
      <br />
      <br />
    </form>
    <button @click="searchTutorByCourse(searchKey)" class="button">Search Course</button>
    <router-link to="/homepage" class="button">Back</router-link>
    <hr />

    <div class="tutorList" align="center">
      <tr v-for="tutor in tutorsFound">
        <button class="buttonNew buttonInList" @click="gotoTutorInfoPage(tutor.name)">Offered by: {{ tutor.name }}</button>
        <!--<tr v-for="tutor in course.tutors">-->
        <!--<button class="buttonNew buttonInList">Offered by: {{ tutor.name }}</button>-->
        <!--</tr>-->
      </tr>
    </div>
    <p>
      <span v-if="errorTutor" style="color:red">Error: {{errorTutor}}</span>
    </p>
  </div>
</template>

<script src="./HomepageCourse.js">
</script>

<style>
#homepagecourse {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color: "textColor";
  background-image: linear-gradient(to bottom, "bgColor", white);
}

#header {
  text-align: left;
}

.button {
  background-color: #87a6e9;
  border: none;
  color: white;
  padding: 12px 23px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.placeHolder {
  border: 0;
  outline: 0;
  background: transparent;
  text-align: center;
  border-bottom: 1px solid rgb(110, 108, 108);
  width: 400px;
}

.tutorList {
  background-color: #eee;
  border: 1px dotted black;
  height: 500px;
  overflow-y: scroll;
  align-content: center;
}

.tutorList::-webkit-scrollbar {
  display: none;
}

.tutorList::-webkit-scrollbar-button {
  display: block;
  width: 17px;
  height: 17px;
}

.tutorList {
  -ms-overflow-style: none;
}

.buttonNew {
  width: 1340px;
  height: 120px;
  border: none;
  color: black;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 20px;
  margin: 4px 2px;
  cursor: pointer;
}

.buttonInList {
  background-color: rgba(216, 215, 215, 0.856);
  color: black;
  border: none;
}

.buttonInList:hover {
  border: 3px solid rgb(17, 124, 224);
  background-color: white;
}

/* .buttonInList {
  width: 1330px;
  height: 100px;
  background-color: #9fc4ee;
  border: none;
  color: black;
  padding: 12px 23px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
} */
</style>