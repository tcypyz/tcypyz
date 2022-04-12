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
    <a-form :model="from" :rules="rules" >
      <a-form-item name="no" label="学号：">
         <a-input v-model:value="form.no" placeholder="请输入学号"/>
      </a-form-item>
      <a-form-item name="name" label="姓名：">
        <a-input v-model:value="form.name" placeholder="请输入姓名"/>
      </a-form-item>
      <a-form-item name="sex" label="性别：">
        <a-radio-group v-model:value="form.sex" button-style="solid">
          <a-radio-button :value="SexEnum.male.no">{{ SexEnum.male.zh }}</a-radio-button>
          <a-radio-button :value="SexEnum.female.no">{{ SexEnum.female.zh }}</a-radio-button>
        </a-radio-group>
      </a-form-item>
      <a-form-item name="password" label="密码：">
        <a-input v-model:value="form.password" placeholder="请输入密码"/>
      </a-form-item>
      <a-form-item name="phone" label="手机：" >
        <a-input v-model:value="form.phone" placeholder="请输入手机号码"/>
      </a-form-item>
      <a-form-item name="role" label="角色：">
        <a-select
          ref="select"
          v-model:value="form.role"
          style="width: 120px"
        >
          <a-select-option :value="RoleEnum.admin.id">{{ RoleEnum.admin.zh }}</a-select-option>
          <a-select-option :value="RoleEnum.student.id">{{ RoleEnum.student.zh }}</a-select-option>
          <a-select-option :value="RoleEnum.teacher.id"> {{ RoleEnum.teacher.zh }}</a-select-option>
        </a-select>
      </a-form-item>
    </a-form>
  </a-drawer>
</template>

<script>
import { defineComponent, ref, reactive } from 'vue';
import { PlusOutlined } from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import { SexEnum, RoleEnum } from '@/type/enum';
import { add } from '@/api/user';
export default defineComponent({
  name: 'UserSetting',
  components: { PlusOutlined },
  setup() {
    const visible = ref(false);
    const form = reactive({
      no: '',
      name: '',
      password: '123456',
      sex: 1,
      phone: '',
      role: '',
    });
    const rules = {
      no: [{
        required: true,
        message: '请输入学号',
      }],
      name: [{
        required: true,
        message: '请输入用户名',
      }],
      password: [{
        required: true,
        message: '请输入密码',
      }],
      role: [{
        require: true,
      }],
    };
    const showDrawer = () => {
      visible.value = true;
    };
    const onClose = () => {
      visible.value = false;
    };
    const onSubmit = () => {
      let config = {};
      add(form).then(() => {
        onClose();
        config = { type: 'success', content: '添加成功' };
      }).catch(() => {
        config = { type: 'warn', content: '添加失败' };
      });
      console.log(config);
      message.open(config);
    };
    return {
      showDrawer,
      visible,
      onClose,
      onSubmit,
      form,
      rules,
      SexEnum,
      RoleEnum,
    };
  },
});
</script>
