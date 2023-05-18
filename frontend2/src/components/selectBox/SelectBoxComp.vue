<template>
  <div style="width: 100%; display: flex; flex-direction: row; flex-wrap: wrap">
    <div
      v-for="number in index"
      :key="number"
      style="width: 100%; display: flex"
    >
      {{ number }}
      <SelectBoxCompSolo
        :modelValue="timeData.start"
        title="시작"
        :array="testArray"
        @update-value="
          (value) => {
            timeData.start = value;
            test(value);
          }
        "
      />
      ~
      <SelectBoxCompSolo
        :modelValue="timeData.end"
        title="끝"
        :array="testArray"
        @update-value="
          (value) => {
            timeData.end = value;
            test(value);
          }
        "
      />
      <v-btn @click="del(number)">del</v-btn>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { defaultTime } from "@/js/ArrayJS";
import { reactive, ref } from "vue";
import SelectBoxCompSolo from "@/components/selectBox/SelectBoxCompSolo.vue";

const props = defineProps(["index"]);
const testArray = ref(defaultTime);
const timeData = reactive({
  start: 0,
  end: 0,
});
const test = (value: number) => {
  console.log(value);
};

const del = (number: number) => {
  const idx = props.index.indexOf(number);
  props.index.splice(idx, 1);
};
</script>
