<template>
  <div id="homepage">
    <h2 id="header">Welcome! {{ this.$globals.student_name }}</h2>
    <br />
    <form>
      <br />
      <br />
      <h3>I would like to:</h3>
      <br />
      <router-link to="/homepagecourse" class="button">Search a Course</router-link>
      <!--<button class="button" router-link to="/homepagecourse">Search a Tutor</button>-->
      <br />
      <br />
      <br />
      <router-link to="/homepagetutor" class="button">Search a Tutor</router-link>
      <!--<button class="button">Search a Course</button>-->
      <br />
      <br />
      <br />
      <router-link to="/ProfilePage" class="button">Give Feedback</router-link>
    </form>
  </div>
</template>

<style>
#homepage {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color: #2c3e50;
  background: #f2ece8;
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

#homepage {
  background-image: linear-gradient(to bottom, rgb(174, 238, 243), white);
}
</style>
