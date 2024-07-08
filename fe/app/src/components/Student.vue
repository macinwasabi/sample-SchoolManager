<template>
  <h1>生徒情報</h1>
  <table>
    <tr>
      <th>No.</th>
      <th>苗字</th>
      <th>名前</th>
    </tr>
    <tr v-for="student in studentList">
      <th>{{ student.no }}</th>
      <th>{{ student.firstName }}</th>
      <th>{{ student.familyName }}</th>
    </tr>
  </table>
</template>

<script setup>
// Compositionで作成 

import { ref, defineProps, onMounted } from 'vue'

const props = defineProps(["students"])

// 生徒情報リスト
var studentList = ref([{
  no: "-",
  familyName: "-",
  firstName: "-"
}])

onMounted(() => {
  // propsの生徒情報があれば生徒情報リストに設定
  if (props.students != null) {
    studentList.value = props.students
  }
})
</script>