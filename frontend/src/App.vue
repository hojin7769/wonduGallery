<template>
  <div v-if="true" class="common-layout">
    <LoginView></LoginView>
  </div>
  <div class="common-layout" v-if="false">
    <el-container class="pageContainer" style="padding: 0px">
      <Layout />
    </el-container>
  </div>
</template>

<script setup>
import Layout from '@/components/layout/Layout.vue'
import LoginView from '@/views/LoginView.vue'
// import ComponentYouAreDeveloping from '@element-plus/components'
</script>
<style lang="sass" scoped>
.common-layout
  height: 100%
.pageContainer
  height: inherit
*
  box-sizing: border-box
</style>
