<template>
  <v-layout>
    <v-app-bar flat location="top">
      <HeaderComp />
    </v-app-bar>
    <v-main>
      <v-container
        class="d-flex justify-center align-center text-h5"
        style="min-height: 300px"
      >
        <router-view />
      </v-container>
    </v-main>
    <v-app-bar flat location="bottom" height="100">
      <FooterComp />
    </v-app-bar>
  </v-layout>
</template>

<script lang="ts" setup>
import FooterComp from "@/layouts/default/FooterComp.vue";
import HeaderComp from "@/layouts/default/HeaderComp.vue";
import { RouterView } from "vue-router";
</script>
