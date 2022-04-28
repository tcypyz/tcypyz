<template>
  <div>
    <div>dashboard</div>
      <a-spin :spinning="spinning">
      <a-alert
        message="Alert message title"
        description="Further details about the context of this alert."
      ></a-alert>
    </a-spin>
    <div class="spin-state">
      Loading state：
      <a-switch v-model:checked="spinning" />
    </div>
  </div>
</template>

<script>
import { defineComponent, ref } from 'vue';

export default defineComponent({
  setup() {
    const spinning = ref(false);
    return {
      spinning,
    };
  },
});
</script>
