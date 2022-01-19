<template>
  <div class="content">
    <div class="left">
      <div class="left-pic"></div>
    </div>
    <div class="right">
        <el-form class="login-container" label-position="left" label-width="0px" size=small>
            <h3 class="login_title">User Login</h3>
            <el-form-item>
                <el-input
                type="text"
                v-model="form.name"
                auto-complete="off"
                placeholder="username"
                ></el-input>
            </el-form-item>
            <el-form-item>
                <el-input
                type="password"
                v-model="form.password"
                auto-complete="off"
                placeholder="password"
                ></el-input>
            </el-form-item>
            <el-form-item style="width: 100%">
                <el-button style="width: 100%; border:none" type="primary" @click="login">Log In</el-button>
            </el-form-item>
        </el-form>
        <div>
            <h2>Do not have an account yet?</h2>
            <h2>Sign up <a href="/Signup">HERE</a>!</h2>
            <br/>
            <p class="left-text">Logged in users have the privileges including
                <ul>
                    <li>checking all public comments of all courses and professors,</li>
                    <li>making their own comments and ratings,</li>
                    <li>getting AI recommented posts and comments,</li>
                    <li>...And more!!!</li>
                </ul>
            </p>
        </div>
    </div>
  </div>
</template>

<script>
import { API } from '../api/index'
export default {
  data () {
    return {
      form: {
        name: '',
        password: ''
      }
    }
  },
  methods: {
    login () {
    //   let _this = this
      let params = new URLSearchParams()
      params.append('username', this.form.name)
      params.append('password', this.form.password)
      API.userLogin(params)
        .then(res => {
          console.log(res)
          if (res) {
            console.log('log in succeed!')
            this.$store.commit('setUsername', this.form.name)
            this.$store.commit('setLogin', true)
            this.$router.push({path: '/'})
            // setTimeout(function () {
            //   this.$router.push({path: '/'})
            // }, 2000)
          } else {
            console.log('log in failed')
            this.$notify({
              title: 'Username or password not correct',
              type: 'error'
            })
          }
        })
        .catch(failResponse => {})
    }
  }
}
</script>

<style scoped>
.content {
    width: 100%;
}
.left {
    float: left;
    width: 45%;
    background-color: aliceblue;
}
.left-pic {
    background: url("../assets/left.jpeg") no-repeat;
    background-size: contain;
    width: 100%;
    float: left;
    margin-top: 3%;
    margin-right: 10%;
    margin-left: 10%;
    margin-bottom: 3%;
    height: 600px;
}
.right {
    float: left;
    width: 52%;
    margin: 1.5% 1.5% auto;
    background-color: rgb(230, 255, 247);
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 50px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
.left-text {
    font-size: 15px;
    text-align: left;
    margin-left: 23%;
}
</style>
