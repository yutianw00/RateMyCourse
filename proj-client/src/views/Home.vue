<template>
<div class="container">
  <el-carousel :interval="4000" type="card" height="400px" style="margin-top: 2%">
    <el-carousel-item v-for="(content, item) in picList" :key="item">
        <img :src="content.url"/>
    </el-carousel-item>
  </el-carousel>
  <h1>Welcome to <span style="color: blue; font-style: italic; text-decoration: underline;">Ratings</span>!</h1>
  <br/>
  <p class="main-text">See comments and ratings other students made about <a href="/Courses">Courses</a>
  or <a href="/Profs">Professors!</a></p>
  <br/>
  <p class="main-text">To make your own comments/ratings, please <a href="/Login">Log in</a> or
  <a href="/Signup">Sign up</a>.</p>
  <br/>

</div>

</template>

<script>
export default {
  data () {
    return {
      picList: [
        {url: require('@/assets/pic2.jpeg')},
        {url: require('@/assets/pic5.jpeg')},
        {url: require('@/assets/pic4.jpeg')},
        {url: require('@/assets/pic6.jpeg')},
        {url: require('@/assets/pic3.jpeg')},
        {url: require('@/assets/pic1.jpeg')}
      ]
    }
  }
}
</script>

<style scoped>
html, body {
    height: 100%;
}
.container {
    margin: 0;
    height: 100%;
    width: 100%;
    background-color: aliceblue;
}
img {
    max-width:100%;
    height:auto;
}
.main-text{
    font-size: 20px;
}
</style>
