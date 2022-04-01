<template>
  <div class="container">
    <div class="top">
      <div class="title">学生管理系统</div>
      <div class="dec">汤臣一品业组</div>
    </div>
    <a-form
      :model="data.form"
      class="main"
      @finish="onFinish"
      @finishFailed="onFinishFailed"
    >
      <a-form-item
        name="id"
        :rules="[{ required: true, message: '请输入学号/手机号!' }]"
      >
        <a-input v-model:value="data.form.id" size="large" placeholder="学号/手机号">
          <template #prefix>
            <UserOutlined class="site-form-item-icon" />
          </template>
        </a-input>
      </a-form-item>

      <a-form-item
        name="password"
        :rules="[{ required: true, message: '请输入您的密码!' }]"
      >
        <a-input-password v-model:value="data.form.password" size="large" placeholder="密码">
          <template #prefix>
            <LockOutlined class="site-form-item-icon" />
          </template>
        </a-input-password>
      </a-form-item>
      <div>
        <a-button type="link" class="forget">忘记密码</a-button>
      </div>
      <a-form-item>
        <a-button
          :disabled="disabled"
          type="primary"
          html-type="submit"
          :loading="loading"
          block
        >
          登录
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import { defineComponent, reactive, computed, ref } from 'vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import { UserOutlined, LockOutlined } from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import { login } from '@/api/system';

export default defineComponent({
  name: 'Login',
  components: {
    UserOutlined,
    LockOutlined,
  },
  setup() {
    const router = useRouter();
    const store = useStore();
    const loading = ref(false);
    const data = reactive({
      form: {
        id: '',
        password: '',
        code: '',
      },
    });
    const disabled = computed(() => !(data.form.id && data.form.password));
    const onFinish = (values) => {
      loading.value = true;
      const params = { ...values };
      login(params).then((res) => {
        message.success('登录成功');
        store.commit('setToken', res.token);
        store.dispatch('userInfo', res);
        router.push('/admin');
      }).finally(() => {
        loading.value = false;
      });
    };
    const onFinishFailed = (errorInfo) => {
      console.log('Failed:', errorInfo);
    };
    return {
      data,
      disabled,
      onFinish,
      onFinishFailed,
      loading,
    };
  },
});
</script>

<style lang="less" scoped>
.container {
  width: 100%;
  min-height: 100%;
  background: #f0f2f5 url(../../assets/background.5825f033.svg) no-repeat 50%;
  background-size: 100%;
  position: relative;
  .top {
    padding-top: 72px;
    text-align: center;
    .title {
      font-size: 33px;
      color: rgba(0, 0, 0, 0.85);
      font-family: Avenir, Helvetica Neue, Arial, Helvetica, sans-serif;
      font-weight: 600;
      position: relative;
      top: 2px;
    }
    .dec {
      font-size: 14px;
      color: rgba(0, 0, 0, 0.45);
      margin-top: 12px;
      margin-bottom: 40px;
    }
  }
  .main {
    min-width: 260px;
    width: 368px;
    margin: 0 auto;
    .site-form-item-icon {
      color: rgba(0, 0, 0, 0.25);
    }
    .forget {
      padding: 0;
    }
  }
}
</style>
