<template>
  <div class="header">

      <div class="header-left" @click="goHome">
        <i class="el-icon-edit"></i>
        Ratings
      </div>

      <div class="buttons-left">
          <el-button type="danger" plain @click="goHome">Home</el-button>
          <el-button type="danger" plain @click="goCourse">Courses</el-button>
          <el-button type="danger" plain @click="goProf">Professors</el-button>
          <el-button type="danger" plain @click="goComments">Comments</el-button>
          <el-button type="primary" @click="goMakeComments" v-show="login">Make A Comment</el-button>
      </div>

      <div class="buttons-right" v-show="!login">
          <el-button type="warning" round plain @click="goLogin">Log In</el-button>
          <el-button type="warning" round plain @click="goSignup">Sign Up</el-button>
      </div>

      <div class="buttons-right" v-show="login">
          <div class="user-welcome" >Welcome, {{ username }}!</div>
          <el-button type="warning" round plain @click="logout">Log Out</el-button>
      </div>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters([
      'username',
      'login'
    ])
  },
  methods: {
    goHome () {
      this.$router.push('/Home')
    },
    goCourse () {
      this.$router.push('/Courses')
    },
    goProf () {
      this.$router.push('/Profs')
    },
    goComments () {
      this.$router.push('/Comments')
    },
    goLogin () {
      this.$router.push('/Login')
    },
    goSignup () {
      this.$router.push('/Signup')
    },
    goMakeComments () {
      this.$router.push('/Makecomments')
    },
    logout () {
      this.$store.commit('setUsername', '')
      this.$store.commit('setLogin', false)
      window.localStorage.clear()
      window.sessionStorage.clear()
      this.$router.push({path: '/'})
    }
  }
}
</script>

<style scoped>
.header{
    line-height: 70px;
}

.logo {
    float: left;
}

.header-left{
    float: left;
    font-size: 30px;
    font-family: Arial, Helvetica, sans-serif;
    text-align: center;
    width: 12%
}

.buttons-left{
    float: left;
    margin-left: 3%;
    margin-right: 3%;
    /* width: 10%;
    margin-top: 0.8%;

    background-color:rgb(214, 55, 55);
    color: bisque; */

}

.buttons-right{
    float: right;
    margin-right: 1%;
    /* width: 5% */
}

img {
    vertical-align: middle;
}

.user-welcome {
    float: left;
    line-height: 70px;
    font-size: 20px;
    width: 200px;
    font-family: Arial, Helvetica, sans-serif;
}

</style>
