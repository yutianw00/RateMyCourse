<template>
<div>
  <div class="title">
    Welcome, Admin!
  </div>
  <div class="intro">
    Welcome to the admin system of the cmu-all project!
    <br/>
    In the admin system, you can view, add, delete and modify all data in the dataset.
    <br/>
    Different datasets are listed on the side bar on the left.
    <br/>
    To log out, click on the "down arrow" next to the avator on the upper-right, and click "log out".
    <br/><br/>
  </div>
  <div class="content">
    <div class="left">
      <div class="left-pic"></div>
    </div>
    <div class="right">
      <h1>Dataset Overview</h1>
      <div class="data-block">
        <div class="data-icon"></div>
        <div class="data-title">Users</div>
      </div>
      <div class="data-block">
        <div class="data-icon"></div>
        <div class="data-title">Courses</div>
      </div>
      <div class="data-block">
        <div class="data-icon"></div>
        <div class="data-title">Professors</div>
      </div>
      <div class="data-block">
        <div class="data-icon"></div>
        <div class="data-title">Course Evaluations</div>
      </div>
      <div class="data-block">
        <div class="data-icon"></div>
        <div class="data-title">Professor Evalutaions</div>
      </div>
    </div>
  </div>
</div>

</template>

<script>
export default {
  data () {
    return {
      'userCnt': 6,
      'userColumnCnt': 5,
      'courseCnt': 3,
      'courseColumnCnt': 5
    }
  }
}
</script>

<style>
html, body {
  height: 100%
}

.title {
  width: 100%;
  color:black;
  font-size: 250%;
  line-height: 250%;
  font-style: italic;
  text-decoration: underline;
}

.intro {
  width: 100%;
  color:blue;
  font-size: 150%;
  line-height: 150%;
}

.left {
  background: url("../assets/tepper-square.jpeg") no-repeat;
  background-size: contain;
  width: 40%;
  float: left;
  height: 700px;
}

.right {
  background-color: aquamarine;
  color: cornflowerblue;
  width: 60%;
  float: left;
  height: 100%;
  border-radius: 5%
}

.data-block {
  margin: 10px;
  /* width: 100%; */
  background-color:antiquewhite;
  height: 120px;
  border-radius: 8%
}

.data-icon {
  background: url("../assets/dataset-icon.png") no-repeat;
  background-size: contain;
  float: left;
  width: 120px;
  height: 120px;
  /* height: 700px; */
}

.data-title {
  float: left;
  width: 250px;
  height: 120px;
  font-size: 150%;
  line-height: 120px;
  font-style: bold;
}

</style>
