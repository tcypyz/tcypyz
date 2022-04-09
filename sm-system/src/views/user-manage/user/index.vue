<template>
  <a-button type="primary" @click="showDrawer">
    <template #icon><PlusOutlined /></template>
    新用户
  </a-button>
<a-drawer
    :width="500"
    title="新添用户"
    :closable="false"
    :visible="visible"
    @close="onClose"
  >
    <template #extra>
      <a-button style="margin-right: 8px" @click="onClose">取消</a-button>
      <a-button type="primary" @click="onSubmit">提交</a-button>
    </template>
    <p>Some contents...</p>
    <p>Some contents...</p>
  </a-drawer>
</template>

<script>
import { defineComponent, ref, reactive } from 'vue';
import { PlusOutlined } from '@ant-design/icons-vue';
export default defineComponent({
  name: 'UserSetting',
  components: { PlusOutlined },
  setup() {
    const visible = ref(false);
    const form = reactive({
      
    });
    const showDrawer = () => {
      visible.value = true;
    };
    const onClose = () => {
      visible.value = false;
    };
    const onSubmit = () => {
      onClose();
    };
    return {
      showDrawer,
      visible,
      onClose,
      onSubmit,
    };
  },
});
</script>
