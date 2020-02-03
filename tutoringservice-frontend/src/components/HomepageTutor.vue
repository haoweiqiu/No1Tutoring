<template>
  <div id="homepagetutor">
    <h2 id="header">Welcome! {{this.$globals.student_name}}</h2>
    <br />
    <form>
      <br />
      <br />
      <h3>I would like to view:</h3>
      <br />
      <input type="text" v-model="searchKey" placeholder="Tutor Name" class="placeHolder" />
      <br />
      <br />
    </form>

    <button @click="searchTutor(searchKey)" class="button">Search Tutor</button>
    <router-link to="/homepage" class="button">Back</router-link>
    <hr />

    <div class="tutorList">
      <button v-if="tutorFound" class="buttonNew buttonInList" @click="gotoTutorInfoPage(tutorFound)">Tutor: {{ tutorFound }}</button>
    </div>
    <p>
      <span v-if="errorTutor" style="color:red">Error: {{errorTutor}}</span>
    </p>
  </div>
</template>

<script src="./HomepageTutor.js">
</script>

<style>
#homepagetutor {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  color: #0c1a29;
  background-image: linear-gradient(to bottom, rgb(174, 238, 243), white);
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

/* .buttonOld {
  width: 1300px;
  height: 100px;
  background-color: rgb(209, 207, 207);
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
.buttonOld:hover {
  border: 2px;
  border-color: rgba(0, 0, 255, 0.781);
} */
</style>