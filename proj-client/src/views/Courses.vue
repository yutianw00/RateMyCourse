<template>
  <div class="main">
      <br/>
      <h1>Courses</h1>
      <el-carousel indicator-position="outside" height=450px>
        <el-carousel-item v-for="(course, idx) in cardList" :key="idx">
          <div class="card">
            <div class="card-left">
              <i class="el-icon-document"></i>
            </div>
            <div class="card-right">
              <h1>{{course.name}}</h1>
              <p class="bullet"> Course Number: {{course.number}} </p>
              <p class="bullet"> Professor of the course: {{course.prof}} </p>
              <p class="bullet"> Course Units: {{course.units}} </p>
              <h2>Introduction:</h2>
              <p>{{course.intro}}</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
      <p class="bottom-info">For more specific information for more courses, please <a href="/Login">log in</a>! <br/><br/><br/> </p>
  </div>
</template>

<script>
import { API } from '@/api/index'

export default {
  data () {
    return {
      cardList: [
        {
          number: 15213,
          name: 'Computer System',
          units: null,
          prof: '',
          intro: ''
        }
      ]
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      this.cardList = []
      API.getCourses()
        .then((res) => {
          this.cardList = res
        }).catch((err) => {
          console.log(err)
        })
    }
  }

}
</script>

<style scoped>
.main {
  height: 100%;
  width: 100%;
  background-color: aliceblue;
}

.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #cddcf1;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d9e9ee;
}

.card {
  width: 80%;
  height: 350px;
  margin: 50px auto auto auto;
  background-color: rgb(245, 250, 223);
  border-radius: 20px;
}

.bottom-info {
  font-size: 20px;
}

.card-left {
  float: left;
  font-size: 200px;
  margin: 80px 80px 30px 30px;
  width: 30%;
}

.card-right {
  float: left;
  width: 50%;
}

.bullet {
  font-size: 20px;
}
</style>
