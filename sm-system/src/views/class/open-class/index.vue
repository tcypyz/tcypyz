<template>
  <div>
    <a-card title="开课">
      <a-form
        ref="formRef"
        :model="formState"
        :label-col="labelCol"
        :wrapper-col="wrapperCol"
      >
        <a-form-item name="className" class="input" label="课程名称">
          <a-input v-model:value="formState.className" />
        </a-form-item>

        <a-form-item name="academic" class="input" label="学院">
          <a-input v-model:value="formState.academic" />
        </a-form-item>

        <a-form-item name="type" label="时间" v-bind="rangeConfig">
          <a-range-picker
            v-model:value="formState.type"
            value-format="YYYY-MM-DD"
          />
        </a-form-item>

        <a-form-item name="radioGroup" label="开课状态">
          <a-radio-group v-model:value="formState.radioGroup">
            <a-radio :value="0">未开课</a-radio>
            <a-radio :value="1">开课中</a-radio>
            <a-radio :value="2">已结束</a-radio>
          </a-radio-group>
        </a-form-item>

        <a-form-item name="inputNumber" label="开课人数">
          <a-input-number
            v-model:value="formState.inputNumber"
            :min="1"
            :max="1000"
          />
        </a-form-item>

        <a-form-item :wrapper-col="{ span: 14, offset: 3 }">
          <a-button type="primary" @click="onSubmit" :loading="loading">提交</a-button>
          <a-button style="margin-left: 10px" @click="resetForm">Reset</a-button>
        </a-form-item>
      </a-form>
    </a-card>
  </div>
</template>

<script>
import { defineComponent, reactive, ref } from 'vue';
import { message } from 'ant-design-vue';
import { addCourse } from '@/api/t-query-class';

export default defineComponent({
  name: 'TeacherOpenClass',
  setup() {
    const formRef = ref();
    const loading = ref(false);
    const formState = reactive({
      className: '',
      academic: '',
      type: [],
      radioGroup: 1,
      inputNumber: 10,
    });

    const rangeConfig = {
      rules: [{
        type: 'array',
        message: 'Please select time!',
      }],
    };
    const onSubmit = () => {
      loading.value = true;
      addCourse().then(() => {
        message.success('修改成功');
      }).catch(() => {
        message.error('修改失败');
      }).finally(() => {
        loading.value = false;
      });
    };
    const resetForm = () => {
      formRef.value.resetFields();
    };
    return {
      labelCol: { style: { width: '150px' } },
      wrapperCol: { span: 14 },
      formState,
      rangeConfig,
      onSubmit,
      resetForm,
      formRef,
      loading,
    };
  },
});
</script>

<style lang="less" scoped>
.input {
  width: 38%;
}
</style>
