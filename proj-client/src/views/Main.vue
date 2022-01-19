<template>
<div>
    <Header class="header"/>
    <router-view></router-view>
    <Footer class="footer"/>
</div>

</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
export default {
  components: {
    Header,
    Footer
  }
}
</script>

<style>
html, body {
  height: 100%;
  margin: 0;
  text-align: center;
}
.header {
    top: 0;
    height: 70px;
    width: 100%;
    background-color: rgb(250, 233, 233);
    margin: 0;
}
.content {
    float:left;
}
.footer {
  position: fixed;
  bottom: 0;
  height: 80px;
  width: 100%;
  /* line-height: 30px; */
  background-color: rgb(170, 170, 170);
}

</style>
