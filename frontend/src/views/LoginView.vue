<template>
  <div id="appLog">
    <div class="header">
      <h2 class="logo">LOGO HERE</h2>
    </div>
    <Login />

    <div class="footer">
      <div class="links">
        <span>Feature 1</span>
        <span>Feature 2</span>
        <span>Feature 3</span>
      </div>
      <div class="version">Version 1.02.05</div>
    </div>
  </div>
</template>

<script setup lang="ts">
import Login from '@/components/Login/Login.vue'
</script>

<style lang="scss" scoped>
#appLog {
  font-family: Roboto, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0;
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
#appLog {
  margin: 0;
  padding: 0;
  background-color: #102a43;
  background-image: url('https://uploads.codesandbox.io/uploads/user/c3fb8e8a-35ea-4232-b5d6-0f3c5373510b/LVs7-dots.png');
  background-size: contain;
}
.footer,
.header {
  padding: 20px 20px;
  color: #f0f4f8;
  display: flex;
  flex-direction: column;
  align-items: center;
  h1,
  h2,
  h3 {
    color: #f0f4f8;
    padding: 0;
    margin: 0;
  }
  .links {
    display: flex;
    font-family: 'Open Sans';
    span {
      padding: 0 10px;
      font-size: 18px;
      border-right: 1px solid #9fb3c8;
      &:last-child {
        border-right: none;
      }
    }
  }
  .version {
    font-family: 'Open Sans';
    padding: 0 10px;
    color: #9fb3c8;
    font-size: 12px;
    margin-top: 5px;
  }
}
.header {
  padding: 10px 20px;
  .logo {
    font-family: 'Open Sans';
    letter-spacing: 3px;
    padding-top: 15px;
    padding-bottom: 15px;
  }
  .logo .part-2 {
    color: #d64545;
  }
}
</style>
