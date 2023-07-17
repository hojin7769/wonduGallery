<script lang="ts" setup>
const porps = defineProps({
  value: {
    type: String
  },
  type: {
    type: String
  }
})
</script>
<template>
  <el-input :model-value="value" :type="type"> </el-input>
</template>
<style lang="sass" scoped></style>
