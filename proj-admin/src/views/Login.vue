<template>
 <body id="login-page">
  <el-form class="login-container" label-position="left" label-width="0px">
    <h3 class="login_title">Admin Login</h3>
    <el-form-item>
        <el-input
        type="text"
        v-model="form.name"
        auto-complete="off"
        placeholder="admin username"
        ></el-input>
    </el-form-item>
    <el-form-item>
        <el-input
        type="password"
        v-model="form.password"
        auto-complete="off"
        placeholder="admin password"
        ></el-input>
    </el-form-item>
    <el-form-item style="width: 100%">
        <el-button style="width: 100%; border:none" type="primary" @click="login">Log In</el-button>
    </el-form-item>
  </el-form>
 </body>
</template>

<script>

export default {
  name: 'Login',
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
      let params = new URLSearchParams()
      params.append('loginName', this.form.name)
      params.append('password', this.form.password)
      this.$axios
        .post('/login', params)
        .then(successResp => {
          if (successResp.data.code === 200) {
            this.$router.replace({path: '/homepage'})
            this.$notify({
              title: successResp.data.message,
              type: 'success'
            })
          } else {
            this.$notify({
              title: successResp.data.message,
              type: 'error'
            })
          }
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}

</script>

<style>
#login-page {
  background: url("../assets/admin-cover.png") no-repeat;
  background-position: center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

body {
    height: 100%;
    margin: 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
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
</style>
