<template>
  <a-spin :indicator="indicator" :spinning="spin" :tip="tip">
    <slot></slot>
  </a-spin>
</template>
<script>
import { LoadingOutlined } from '@ant-design/icons-vue';
import { defineComponent, h } from 'vue';
export default defineComponent({
  name: 'Loading',
  props: {
    tip: {
      type: String,
      default: '',
    },
    spin: {
      type: Boolean,
      default: false,
      require: true,
    },
  },
  setup() {
    const indicator = h(LoadingOutlined, {
      style: {
        fontSize: '24px',
      },
    });
    return {
      indicator,
    };
  },

});
</script>
