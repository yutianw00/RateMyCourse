<template>
  <el-menu
    :default-active="currRoute"
    class="el-menu-vertical-demo"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    router>

      <el-menu-item index="homepage">
        <i class="el-icon-menu"></i>
        <span slot="title">Home Page</span>
      </el-menu-item>
      <el-menu-item index="users" >
        <i class="el-icon-document"></i>
        <span slot="title">Users</span>
      </el-menu-item>
      <el-menu-item index="courses" >
        <i class="el-icon-document"></i>
        <span slot="title">Courses</span>
      </el-menu-item>
      <el-menu-item index="profs" >
        <i class="el-icon-document"></i>
        <span slot="title">Professors</span>
      </el-menu-item>
      <el-submenu index="eval">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>Evaluations</span>
        </template>

        <el-menu-item index="prof-eval">Professor Evaluations</el-menu-item>
        <el-menu-item index="course-eval">Course Evaluations</el-menu-item>

      </el-submenu>
    </el-menu>
</template>

<script>
export default {
  computed: {
    currRoute () {
      return this.$route.path.replace('/', '')
    }
  }
}
</script>

<style>

</style>
