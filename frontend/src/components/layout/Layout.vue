<template>
  <el-container>
    <Header />
    <el-main class="mainContainer">
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
.mainContainer
  display: flex
  justify-content: center
  justify-items: center
.footerContainer
  position: absolute
  bottom: 0
  width: 100%
  height: 100px
  text-align: center
</style>
