<template>
  <div style="padding-top: 70px;">
    <a-result
      status="error"
      title="404 page"
      sub-title="Sorry, the page you visited does not exist."
    >
      <template #extra>
        <a-button key="console" type="primary" @click="handleBack">返回</a-button>
        <a-button key="buy" @click="handleGoLogin">登录页</a-button>
      </template>

      <div class="desc">
        <p style="font-size: 16px">
          <strong>The content you submitted has the following error:</strong>
        </p>
        <p>
          <CloseCircleOutlined :style="{ color: 'red' }" />
          Your URL address is not enter correctly
          <a>Correct URL &gt;</a>
        </p>
        <p>
          <CloseCircleOutlined :style="{ color: 'red' }" />
          Please try to go back to previous pages baecuse of vuex cache
          <a>Go Back &gt;</a>
        </p>
      </div>
    </a-result>
  </div>
</template>
<script setup name="404">
import { computed, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { useStore } from 'vuex';
import { CloseCircleOutlined } from '@ant-design/icons-vue';
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
  // handleCurrentRoute();
});
</script>

<style lang="less" scoped>
.desc p {
  margin-bottom: 1em;
}
</style>
