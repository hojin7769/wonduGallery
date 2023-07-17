<script lang="ts" setup>
import { ref } from 'vue'
import { Plus } from '@element-plus/icons-vue'

import type { UploadInstance, UploadProps, UploadUserFile } from 'element-plus'
import axios from 'axios'

const dialogImageUrl = ref('')
const dialogVisible = ref(false)
const disabled = ref(false)
const fileList = ref<UploadUserFile[]>([])
const upload = ref<UploadInstance>()
const title = ref<string>()
const content = ref<string>()

const handleRemove: UploadProps['onRemove'] = (uploadFile, uploadFiles) => {
  console.log(uploadFile, uploadFiles)
}

const handlePictureCardPreview: UploadProps['onPreview'] = (uploadFile) => {
  dialogImageUrl.value = uploadFile.url!
  dialogVisible.value = true
}
const test: UploadProps['beforeUpload'] = (uploadFiles) => {
  console.log(uploadFiles)
}

const postData = function (url, data) {
  return axios
    .post(url, data)
    .then((response) => {
      console.log('POST request successful')
      console.log(response.data)
      return response.data
    })
    .catch((error) => {
      console.error('Error:', error)
      throw error
    })
}

const submitUpload = (param) => {
  // upload.value!.submit()
  // console.log(file)
  const data = makeParam(title.value, content.value)
  postData('/api/file/uploadFile')
    .then((res) => postData('/api/board/save', data))
    .then(() => {
      console.log('All POST requests completed')
    })
    .catch((error) => {
      console.error('Error:', error)
    })
}
const makeParam = function (boardTitle: string, boardContent: string): object {
  const param = {
    boardTitle: boardTitle,
    boardContent: boardContent
  }
  return param
}
</script>

<template>
  <el-card body-style="width:70vw">
    <el-header> 게시글 작성 </el-header>
    <div>
      <div>제목</div>
      <el-input v-model="title"></el-input>
    </div>
    <div>
      <div>내용</div>
      <el-input type="textarea" v-model="content"></el-input>
    </div>
    <div>
      <div>사진</div>
      <el-upload
        ref="upload"
        v-model:file-list="fileList"
        action="https://run.mocky.io/v3/9d059bf9-4660-45f2-925d-ce80ad6c4d15"
        list-type="picture-card"
        multiple
        :auto-upload="false"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
        :before-upload="test"
      >
        <el-icon><Plus /></el-icon>
      </el-upload>
    </div>
    <el-button @click="submitUpload(fileList)">저장</el-button>
  </el-card>

  <el-dialog v-model="dialogVisible">
    <img w-full :src="dialogImageUrl" alt="Preview Image" />
  </el-dialog>
</template>

<style scoped>
.avatar-uploader .avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

<style>
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  text-align: center;
}
</style>
<script setup lang="ts"></script>
