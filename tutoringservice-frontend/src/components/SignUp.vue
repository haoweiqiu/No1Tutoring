
<template>
  <div id="SignUp" v-bind:style="{ backgroundColor : bgColor }">
    <h2 id="header" v-bind:style="{ color : textColor }">Welcome to Tutoring Service System!</h2>
    <br />
    <form>
      <br />
      <br />
      <h3 v-bind:style="{ color : textColor }">Enter username, password and school name to sign up:</h3>
      <br />
      <input type="text" v-model="name" placeholder="Name" class="placeHolder" />
      <br />
      <br />
      <br />
      <input type="password" v-model="passwordString" placeholder="Password" class="placeHolder" />
      <br />
      <br />
      <br />
      <input type="text" v-model="schoolName" placeholder="School name" class="placeHolder" />
      <br />
      <br />
      <button @click="createStudent" class="button">Sign Up</button>
      <br />
      <router-link to="/" class="button">Login</router-link>
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <button @click="setDarkmode" class="button">Dark mode</button>
      <button @click="setLightmode" class="button">Light mode</button>
      

      
    </form>
    <hr />
    
  </div>
</template>

<script src="./SignUp.js">
</script>

<style>
#SignUp {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color: "textColor";
  background-image: linear-gradient(to bottom, "bgColor", white);
}
#header {
  text-align: middle;
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
.courseList {
  background-color: #eee;
  border: 1px dotted black;
  height: 500px;
  overflow-y: scroll;
}
.courseList::-webkit-scrollbar {
  display: none;
}
.courseList::-webkit-scrollbar-button {
  display: block;
  width: 17px;
  height: 17px;
}
.courseList {
  -ms-overflow-style: none;
}
.buttonInList {
  width: 1300px;
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
}
</style>