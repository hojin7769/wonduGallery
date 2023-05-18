<template>
  <SelectBoxComp :index="lstIndex"></SelectBoxComp>

  <div style="display: block">
    <v-btn @click="addIndex">확장</v-btn>
  </div>
</template>
<script lang="ts" setup>
import SelectBoxComp from "@/components/selectBox/SelectBoxComp.vue";
import { ref } from "vue";

const lstIndex = ref([0]);
const addIndex = () => {
  lstIndex.value.push(index.value++);
};
const index = ref(1);
</script>
