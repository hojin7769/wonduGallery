<template>
  <v-select
    :model-value="modelValue"
    :label="title"
    :items="array"
    @update:modelValue="
      (value) => {
        $emit('update-value', value);
      }
    "
  ></v-select>
</template>
<script lang="ts" setup>
defineProps(["title", "array", "modelValue"]);
const emit = defineEmits(["update-value"]);
</script>
