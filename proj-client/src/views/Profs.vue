<template>
  <div class="main">
      <br/>
      <h1>Professors</h1>
      <el-carousel indicator-position="outside" height=450px>
        <el-carousel-item v-for="(prof, idx) in cardList" :key="idx">
          <div class="card">
            <div class="card-left">
              <i class="el-icon-s-custom"></i>
            </div>
            <div class="card-right">
              <h1>{{prof.name}}</h1>
              <p class="bullet"> Average Rating: {{prof.rating}} </p>
              <h2>Introduction:</h2>
              <p>{{prof.intro}}</p>
            </div>
          </div>
        </el-carousel-item>
      </el-carousel>
      <p class="bottom-info">For more specific information for more professors, please <a href="/Login">log in</a>! <br/><br/><br/> </p>
  </div>
</template>

<script>
import { API } from '@/api/index'

export default {
  data () {
    return {
      cardList: [
        {
          name: '',
          rating: null,
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
      API.getProfs()
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
