<template>
  <a-form
    :model="formState"
    :label-col="labelCol"
    :wrapper-col="wrapperCol"
    @finish="handleFinish"
    @finishFailed="handleFinishFailed"
  >
    <a-form-item class="input" label="课程名称">
      <a-input v-model:value="formState.className" />
    </a-form-item>

    <a-form-item class="input" label="学院">
      <a-input v-model:value="formState.academic" />
    </a-form-item>

    <a-form-item name="range-picker" label="时间" v-bind="rangeConfig">
      <a-range-picker
        v-model:value="formState['range-picker']"
        value-format="YYYY-MM-DD"
      />
    </a-form-item>

    <a-form-item name="radio-group" label="开课状态">
      <a-radio-group v-model:value="formState['radio-group']">
        <a-radio value="0">未开课</a-radio>
        <a-radio value="1">开课中</a-radio>
        <a-radio value="2">已结束</a-radio>
      </a-radio-group>
    </a-form-item>

    <a-form-item name="input-number" label="开课人数">
      <a-input-number
        v-model:value="formState['input-number']"
        :min="1"
        :max="1000"
      />
    </a-form-item>

    <a-form-item :wrapper-col="{ span: 14, offset: 4 }">
      <a-button type="primary" @click="onSubmit">创建</a-button>
      <a-button style="margin-left: 10px" @click="resetForm">Reset</a-button>
    </a-form-item>
  </a-form>
</template>

<script>
import { defineComponent, reactive, toRaw } from 'vue';

export default defineComponent({
  name: 'TeacherOpenClass',
  setup() {
    const formState = reactive({
      className: '',
      academic: '',
      type: [],
      'radio-group': '1',
      'input-number': '',
    });

    const rangeConfig = {
      rules: [
        {
          type: 'array',
          message: 'Please select time!',
        },
      ],
    };

    // 创建
    const onSubmit = () => {
      console.log('submit!', toRaw(formState));
    };

    // 重置
    const resetForm = () => {
      formState.value.resetFields();
    };

    const handleFinish = (values) => {
      console.log(values, formState);
    };

    const handleFinishFailed = (errors) => {
      console.log(errors);
    };

    return {
      labelCol: { style: { width: '150px' } },
      wrapperCol: { span: 14 },
      formState,
      rangeConfig,
      onSubmit,
      resetForm,
      handleFinish,
      handleFinishFailed,
    };
  },
});
</script>

<style lang="less" scoped>
.input {
  width: 38%;
}
</style>
