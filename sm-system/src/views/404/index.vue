<template>
  <div>404</div>
</template>
<script setup name="404">
import { computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';
const { getters } = useStore();
const router = useRouter();
const handleBack = () => {
  router.back();
};
const handleGoLogin = () => {
  router.push('/');
};
const fromRoute = computed(() => getters.getPath);
const handleCurrentRoute = () => {
  if (fromRoute.value.includes('/admin') && router.hasRoute(router.currentRoute.value.fullPath)) {
    router.replace(fromRoute.value);
  }
};
onMounted(() => {
  handleCurrentRoute();
});
</script>

<style scoped>
</style>
