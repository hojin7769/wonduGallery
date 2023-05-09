<template>
  <el-container class="wrap">
    <Header />
    <el-main class="mainContainer" style="max-width: 100%; height: 100%">
      <RouterView />
    </el-main>
    <el-footer class="footerContainer">
      <Footer />
    </el-footer>
  </el-container>
</template>
<script setup lang="ts">
import Header from '@/components/layout/Header.vue'
import Footer from '@/components/layout/Footer.vue'
</script>

<style lang="sass" scoped>
.wrap
  min-height: 100vh
  width: 100%
.mainContainer
  display: flex
  justify-content: center
  padding-bottom: 20%
.footerContainer
  position: absolute
  bottom: 0
  width: 100%
  max-height: 10%
  text-align: center
</style>
