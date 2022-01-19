<template>
  <div class="content">
    <div class="left">
      <div class="left-pic-signup"></div>
    </div>
    <div class="right">
        <el-form :model="form" ref="form" class="login-container" label-position="left" label-width="0px" size=small>
            <h3 class="login_title">User Sign Up</h3>
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
            <el-form-item>
                <el-input
                type="password"
                v-model="form.confPassword"
                auto-complete="off"
                placeholder="confirm your password"
                ></el-input>
            </el-form-item>
            <el-form-item>
                <el-input
                v-model="form.email"
                auto-complete="off"
                placeholder="email (e.g. tom@example.com)"
                ></el-input>
            </el-form-item>
            <el-form-item>
                <el-input
                v-model="form.college"
                auto-complete="off"
                placeholder="college (e.g. MCS/SCS/CIT/DC)"
                ></el-input>
            </el-form-item>
            <el-form-item>
                <el-input
                v-model="form.gradYear"
                auto-complete="off"
                placeholder="Graduation Year (e.g. 2023)"
                ></el-input>
            </el-form-item>
            <el-form-item style="width: 100%">
                <el-button style="width: 100%; border:none" type="primary" @click="signUp">Sign Up</el-button>
            </el-form-item>
        </el-form>
        <div>
            <br/>
            <h3>Already have an account?</h3>
            <h3>Log in <a href="/Login">HERE</a>!</h3>
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
        password: '',
        confPassword: '',
        email: '',
        college: '',
        gradYear: null
      }
    }
  },
  methods: {
    signUp () {
      if (this.form.name === '') {
        this.$notify({
          title: 'Username cannot be empty',
          type: 'error'
        })
        return
      } else if (this.form.password === '') {
        this.$notify({
          title: 'Password cannot be empty',
          type: 'error'
        })
      } else if (this.form.password !== this.form.confPassword) {
        this.$notify({
          title: 'Passwords doesn\'t match.',
          type: 'error'
        })
        return
      }
      this.addData()
      console.log('signing up!')
    },
    addData () {
      let params = new URLSearchParams()
      params.append('username', this.form.name)
      params.append('password', this.form.password)
      params.append('email', this.form.email)
      params.append('college', this.form.college)
      params.append('gradYear', this.form.gradYear)
      API.addUser(params)
        .then(res => {
          if (res) {
            // this.$nextTick(() => {
            //   this.$refs[this.form].resetFields()
            // })
            this.$notify({
              title: 'Adding User Succeed.',
              type: 'success'
            })
          } else {
            this.$notify({
              title: 'Adding User Failed. Server Error.',
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
          this.$notify({
            title: 'Adding User Failed. Frontend Error.',
            type: 'error'
          })
        })
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
.left-pic-signup {
    background: url("../assets/left2.jpeg") no-repeat;
    background-size: contain;
    width: 100%;
    float: left;
    margin-top: 3%;
    margin-right: 13%;
    margin-left: 13%;
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
  margin: 30px auto;
  width: 350px;
  padding: 25px 25px 5px 25px;
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
    font-size: 20px;
    text-align: left;
    margin-left: 15%;
}
</style>
