<template>
  <div>
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
      <a-form :model="data.form" :rules="rules">
        <a-form-item name="no" label="学号：">
          <a-input v-model:value="data.form.no" placeholder="请输入学号" />
        </a-form-item>
        <a-form-item name="name" label="姓名：">
          <a-input v-model:value="data.form.name" placeholder="请输入姓名" />
        </a-form-item>
        <a-form-item name="sex" label="性别：">
          <a-radio-group v-model:value="data.form.sex" button-style="solid">
            <a-radio-button :value="SexEnum.MALE">{{
              SexEnum.properties[SexEnum.MALE].zh
            }}</a-radio-button>
            <a-radio-button :value="SexEnum.FEMALE">{{
              SexEnum.properties[SexEnum.FEMALE].zh
            }}</a-radio-button>
          </a-radio-group>
        </a-form-item>
        <a-form-item name="password" label="密码：">
          <a-input v-model:value="data.form.password" placeholder="请输入密码" />
        </a-form-item>
        <a-form-item name="phone" label="手机：">
          <a-input v-model:value="data.form.phone" placeholder="请输入手机号码" />
        </a-form-item>
        <a-form-item name="birth" label="出生日期：">
          <a-date-picker v-model:value="data.form.birth" value-format="YYYY-MM-DD" />
        </a-form-item>
        <a-form-item name="college" label="学院">
          <a-input v-model:value="data.form.college" placeholder="请输入学院" />
        </a-form-item>
        <a-form-item name="role" label="角色：">
          <a-select ref="select" v-model:value="data.form.role" style="width: 120px">
            <a-select-option :value="RoleEnum.ADMIN">
              {{ RoleEnum.properties[RoleEnum.ADMIN].zh }}
            </a-select-option>
            <a-select-option :value="RoleEnum.STUDENT">
              {{ RoleEnum.properties[RoleEnum.STUDENT].zh }}
            </a-select-option>
            <a-select-option :value="RoleEnum.TEACHER">
              {{ RoleEnum.properties[RoleEnum.TEACHER].zh }}
            </a-select-option>
          </a-select>
        </a-form-item>
        <a-form-item name="profession" v-if="data.form.role === RoleEnum.STUDENT" label="专业">
          <a-input v-model:value="data.form.profession" placeholder="请输入学生专业" />
        </a-form-item>
        <a-form-item name="occupation" v-if="data.form.role === RoleEnum.TEACHER" label="职称">
          <a-input v-model:value="data.form.occupation" placeholder="请输入教师职称" />
        </a-form-item>
      </a-form>
    </a-drawer>
    <BaseTable 
      :data="data.list" 
      :columns="columns"
      table-title="用户表格" 
      class="user-table"
      @reload="loadList"
    >
    </BaseTable>
  </div>
</template>

<script>
import { defineComponent, ref, reactive, onMounted } from 'vue';
import { PlusOutlined } from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import { SexEnum, RoleEnum } from '@/type/enum';
import { add, userList } from '@/api/user';
import { formData, formRules, columns } from './data';
export default defineComponent({
  name: 'UserSetting',
  components: { PlusOutlined },
  setup() {
    const visible = ref(false);
    const data = reactive({
      form: {
        no: '',
        name: '',
        password: '123456',
        sex: 1,
        phone: '',
        birth: '',
        college: '',
        role: 2,
        profession: '',
        occupation: '',
      },
      list: [],
      pagination: {
        page: 1,
        size: 20,
      },
    });
    const rules = formRules;
    const showDrawer = () => {
      visible.value = true;
    };
    const onClose = () => {
      visible.value = false;
      data.form = formData;
    };
    const onSubmit = () => {
      add(data.form).then(() => {
        onClose();
        message.open({ type: 'success', content: '添加成功' });
      }).catch(() => {
        message.open({ type: 'warn', content: '添加失败' });
      });
    };
    const loadList = () => {
      userList(data.pagination).then((res) => {
        res.list = res.list.map(element => {
          return { ...element, key: element.id };
        });
        data.list = res.list;
      });
    };
    onMounted(() => {
      loadList();
    });
    return {
      showDrawer,
      visible,
      onClose,
      onSubmit,
      data,
      rules,
      SexEnum,
      RoleEnum,
      columns,
      loadList,
    };
  },
});
</script>

<style lang="less" scoped>
.user-table{
  margin-top: 10px;
}
</style>
