<template>
  <h1>先生情報</h1>
  <table>
    <tr>
      <th>No.</th>
      <th>苗字</th>
      <th>名前</th>
    </tr>
    <tr v-for="teacher in teacherList">
      <th>{{ teacher.no }}</th>
      <th>{{ teacher.firstName }}</th>
      <th>{{ teacher.familyName }}</th>
    </tr>
  </table>
</template>

<script>
// Optionsで作成 

import { ref, defineProps } from 'vue'

export default {
  props: ["teachers"],
  data() {
    return {
      teacherList: [{
        no: "-",
        familyName: "-",
        firstName: "-"
      }]
    }
  },
  mounted() {
    // propsの先生情報があれば先生情報リストに設定
    if (this.teachers != null) {
      this.teacherList = this.teachers
    }
  }
}
</script>