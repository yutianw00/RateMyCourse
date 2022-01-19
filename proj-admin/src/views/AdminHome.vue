<template>
  <el-container>
    <el-header height="70px">
      <Header/>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <Aside/>
      </el-aside>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
import Header from '@/components/Header.vue'
import Aside from '@/components/Aside.vue'
export default {
  name: 'AdminHome',
  components: {
    Header,
    Aside
  }
}
</script>

<style>
html, body {
  height: 100%;
  margin: 0%;
}

.el-header {
    background-color: #1A1B1C;
    color: rgb(219, 218, 218);
    /* text-align: center; */
  }

.el-aside {
  background-color: #060607;
  color: #333;
  text-align: center;
  height: 100%;
  line-height: 200px;
  /* line-height: 100vh; */
}

.el-main {
  background-color: #E9EEF3;
  color: #333;
  text-align: center;
  height: 100%;
  line-height: 30px;

}

.el-container {
  padding: 0px;
  margin: 0px;
  height: 100%;
  direction: vertical;
}
</style>
