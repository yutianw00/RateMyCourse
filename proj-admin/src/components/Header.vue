<template>
  <div class="header">
      <div class="header-left">
        Admin System
      </div>
      <div class="header-right">

        <div class="admin-avator">
            <img
            src="../assets/logo.jpeg"
            style="border-radius: 50%"
            width="50"
            height="50">
        </div>

        <el-dropdown trigger="click" @command="handleDropdown">
            <span class="el-dropdown-link">
                <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
                <el-dropdown-item style="font-family: Arial" command="logout">Log Out</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
      </div>
  </div>
</template>

<script>
export default {
  methods: {
    handleDropdown (cmd) {
      if (cmd === 'logout') {
        this.$router.push('/')
      }
    }
  }

}
</script>

<style>
.header{
    line-height: 70px;
}

.header-left{
    float: left;
    font-size: 30px;
    font-family: Arial, Helvetica, sans-serif;
}

.header-right{
    float: right;
}

.admin-avator{
    float: left;
}

img {
    vertical-align: middle;
}

</style>
