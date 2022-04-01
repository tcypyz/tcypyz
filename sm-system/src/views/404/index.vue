<template>
  <div>404</div>
</template>
<script setup name="404">
import { useRouter } from 'vue-router';

const router = useRouter();
const handleBack = () => {
  router.back();
};
const handleGoLogin = () => {
  router.push('/');
};
</script>

<style scoped>
</style>
