<template>
   <i-frame v-model:src="url"></i-frame>
</template>

<script setup>
import iFrame from '@/components/iFrame'
// swagger ui
//const url = ref(import.meta.env.VITE_APP_BASE_API + "/swagger-ui/index.html")
// knife4j
const url = ref(import.meta.env.VITE_APP_BASE_API + "/doc.html")
</script>
