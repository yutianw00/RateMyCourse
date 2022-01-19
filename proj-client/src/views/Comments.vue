<template>
  <div>
    <div class="main-left">
        <br/>
        <h1>Professors Evaluations</h1>
        <el-carousel indicator-position="outside" height=400px :autoplay=false>
          <el-carousel-item v-for="(profEval, idx) in profEvalList" :key="idx">
            <div class="card">
              <div class="card-left">
                <i class="el-icon-s-custom"></i>
              </div>
              <div class="card-right">
                <h1>{{profEval.profname}}</h1>
                <p class="bullet"> Average Rating: {{profEval.rating}} </p>
                <h2>Comment:</h2>
                <p>{{profEval.comment}}</p>
              </div>
            </div>
          </el-carousel-item>
        </el-carousel>
        <!-- <p class="bottom-info">For more comments of more professors, please <a href="/Login">log in</a>! <br/><br/><br/> </p> -->
    </div>
    <div class="main-right">
        <br/>
        <h1>Courses Evaluations</h1>
        <el-carousel indicator-position="outside" height=400px :autoplay=false>
          <el-carousel-item v-for="(courseEval, idx) in courseEvalList" :key="idx">
            <div class="card">
              <div class="card-left">
                <i class="el-icon-document"></i>
              </div>
              <div class="card-right">
                <h1>{{courseEval.coursenumber}}</h1>
                <p class="bullet"> Teaching Professor: {{courseEval.profname}} </p>
                <p class="bullet"> Semester: {{courseEval.semester}} </p>
                <p class="bullet"> Average Rating: {{courseEval.rating}} </p>
                <h2>Comment:</h2>
                <p>{{courseEval.comment}}</p>
              </div>
            </div>
          </el-carousel-item>
        </el-carousel>
        <!-- <p class="bottom-info">For more comments of more courses, please <a href="/Login">log in</a>! <br/><br/><br/> </p> -->
    </div>
    <p class="bottom-info">For more comments or to make your own comments, please <a href="/Login">log in</a>! <br/><br/><br/> </p>
  </div>
</template>

<script>
import { API } from '@/api/index'

export default {
  data () {
    return {
      profEvalList: [],
      courseEvalList: []
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      this.profEvalList = []
      API.getProfEvals()
        .then((res) => {
          this.profEvalList = res
        }).catch((err) => {
          console.log(err)
        })

      this.courseEvalList = []
      API.getCourseEvals()
        .then((res) => {
          this.courseEvalList = res
        }).catch((err) => {
          console.log(err)
        })
    }
  }

}
</script>

<style scoped>
.main-left {
  float: left;
  height: 100%;
  width: 48%;
  margin-left: 1%;
  margin-right: 1%;
  background-color: aliceblue;
}

.main-right {
  float: left;
  height: 100%;
  width: 48%;
  margin-left: 1%;
  margin-right: 1%;
  background-color: rgb(240, 255, 244);
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
  height: 300px;
  margin: 50px auto auto auto;
  background-color: rgb(245, 250, 223);
  border-radius: 20px;
}

.bottom-info {
  font-size: 20px;
  line-height: 60px;
}

.card-left {
  float: left;
  font-size: 200px;
  margin: 80px 80px 10px auto;
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
