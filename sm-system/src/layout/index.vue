<template>
  <div>
      layout<br>
      <router-view></router-view>
  </div>
</template>

<script>
import { defineComponent } from 'vue';
export default defineComponent({
  name: 'AdminLayout',
  setup() {
    return {};
  },
});
</script>

<style>

</style>
