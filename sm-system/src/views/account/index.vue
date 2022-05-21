<template>
  <div>
    <a-card  title="修改密码">
      <Loading :spin="loading">
        <a-form
          ref="formRef"
          :model="formState"
          :rules="rules"
          v-bind="layout"
          @finish="handleFinish"
          @finishFailed="handleFinishFailed"
        >
          <a-form-item has-feedback label="密码" name="pass">
            <a-input v-model:value="formState.pass" type="password" autocomplete="off" />
          </a-form-item>
          <a-form-item has-feedback label="确认密码" name="checkPass">
            <a-input v-model:value="formState.checkPass" type="password" autocomplete="off" />
          </a-form-item>
          <a-form-item :wrapper-col="{ span: 14, offset: 8 }">
            <a-button type="primary" html-type="submit">修改</a-button>
            <a-button style="margin-left: 10px" @click="resetForm">重置</a-button>
          </a-form-item>
        </a-form>
      </Loading>
    </a-card>
  </div>
</template>

<script>
import { defineComponent, ref, reactive } from 'vue';
import { message } from 'ant-design-vue';
import { isStringEmpty } from '@/utils';
import { change } from '@/api/user';

export default defineComponent({
  setup() {
    const formRef = ref();
    const formState = reactive({
      pass: '',
      checkPass: '',
    });
    const loading = ref(false);
    const validatePass = async (_rule, value) => {
      if (isStringEmpty(value)) {
        return Promise.reject(new Error('请输入密码'));
      } else if (value.length < 6) {
        return Promise.reject(new Error('密码不能小于6位'));
      } else {
        if (!isStringEmpty(formState.checkPass)) {
          formRef.value.validateFields('checkPass');
        }
        return Promise.resolve();
      }
    };
    const validateCheckPass = async (_rule, value) => {
      if (isStringEmpty(value)) {
        return Promise.reject(new Error('请再次输入密码'));
      } else if (value !== formState.pass) {
        return Promise.reject(new Error('两次密码输入不一致'));
      } else {
        return Promise.resolve();
      }
    };
    const layout = {
      labelCol: {
        span: 8,
      },
      wrapperCol: {
        span: 8,
      },
    };
    const rules = {
      pass: [{
        require: true,
        validator: validatePass,
        trigger: 'change',
      }],
      checkPass: [{
        require: true,
        validator: validateCheckPass,
        trigger: 'change',
      }],
    };
    const resetForm = () => {
      formRef.value.resetFields();
    };
    const handleFinish = values => {
      loading.value = true;
      change({ pass: formState.pass }).then(res => {
        message.success('修改成功');
      }).catch(() => {
        message.error('修改失败');
      }).finally(() => {
        loading.value = false;
      });
    };

    const handleFinishFailed = errors => {
      console.log(errors);
    };
    return {
      formRef,
      formState,
      rules,
      resetForm,
      handleFinish,
      handleFinishFailed,
      layout,
      loading,
    };
  },
});
</script>
