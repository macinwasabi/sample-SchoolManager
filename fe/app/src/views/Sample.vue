<template>
  <Student :students="students" />
  <Teacher :teachers="teachers" />
</template>

<script setup>
import { ref } from "vue"
import Student from '../components/Student.vue'
import Teacher from '../components/Teacher.vue'

const students = ref([
  {
    no: 1,
    familyName: "te",
    firstName: "st"
  }
])

const teachers = ref([
  {
    no: 1,
    familyName: "鈴木",
    firstName: "先生"
  }
])

// TODO:PromiseとasyncでAPIを呼び出したい
</script>