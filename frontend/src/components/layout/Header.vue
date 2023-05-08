<template>
  <el-header style="padding: 0px">
    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      :ellipsis="false"
      @select="handleSelect"
    >
      <el-menu-item index="0" @click="menuBtnClick('/')">원두</el-menu-item>
      <!--      <div class="flex-grow" />-->
      <el-menu-item index="1" @click="menuBtnClick('/about')">Processing Center</el-menu-item>
      <el-sub-menu index="2">
        <template #title>Workspace</template>
        <el-menu-item index="2-1">item one</el-menu-item>
        <el-menu-item index="2-2">item two</el-menu-item>
        <el-menu-item index="2-3">item three</el-menu-item>
        <el-sub-menu index="2-4">
          <template #title>item four</template>
          <el-menu-item index="2-4-1">item one</el-menu-item>
          <el-menu-item index="2-4-2">item two</el-menu-item>
          <el-menu-item index="2-4-3">item three</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      <div class="flex-grow" />
      <el-menu-item index="3" @click="menuBtnClick('/login')">login </el-menu-item>
    </el-menu>
  </el-header>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const index = sessionStorage.getItem('index')
const activeIndex = ref(index)
const handleSelect = (key: string, keyPath: string[]) => {
  // console.log(key, keyPath)
  setIndexInSession('index', key)
}
const menuBtnClick = function (path: string): void {
  router.push(path)
}
const setIndexInSession = function (key: string, value: string) {
  sessionStorage.setItem(key, value)
}
</script>

<style scoped>
.flex-grow {
  flex-grow: 1;
}
</style>
