<template>
  <div class="gallery-area">
    <el-card
      :body-style="{ padding: '0px' }"
      v-for="(o, index) in 6"
      :key="o"
      :offset="index > 0 ? 2 : 0"
    >
      <img
        src="data:image/jpeg;base64,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"
        class="image"
      />
      <div style="padding: 14px">
        <span>게시글</span>
        <div class="bottom">
          <time class="time">{{ currentDate }}</time>
          <el-button text class="button">Operating</el-button>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const currentDate = ref(new Date())
</script>

<style>
.gallery-area {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: center;
  column-gap: 10px;
  row-gap: 10px;
  width: 100%;
}
.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  object-fit: cover;
}
</style>
