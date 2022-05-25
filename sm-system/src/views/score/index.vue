<template>
  <div>
    <a-card title="成绩查询">
      <a-form
        ref="formRef"
        :model="formState"
        layout="inline"
        :label-col="labelCol" 
        :wrapper-col="wrapperCol"
      >
        <a-form-item name="teacher" label="教师">
          <a-input v-model:value="formState.teacher"/>
        </a-form-item>
        <a-form-item name="academic" label="所属学院">
          <a-input v-model:value="formState.academic"/>
        </a-form-item>
        <a-form-item name="className" label="课程名">
          <a-input v-model:value="formState.className"/>
        </a-form-item>
        <a-row>
          <a-col :span="24" style="text-align: right">
            <a-button type="primary" html-type="submit" @click="onFinish">查询</a-button>
            <a-button style="margin: 0 8px" @click="() => formRef.resetFields()">清除</a-button>
          </a-col>
        </a-row>
      </a-form>
    </a-card>
    <a-divider/>
    <a-card>
      <div class="table-bar">
        <div class="table-left">
          成绩表格
        </div>
        <div class="table-right">
          <ReloadOutlined @click="handleReload"/>
        </div>
       </div>
      <a-table
        :columns="columns"
        :data-source="data.list"
        :pagination="false"
        :loading="loading"
      >
      </a-table>
    </a-card>
  </div>
</template>

<script>
import { defineComponent, onMounted, reactive, ref, toRefs } from 'vue';
import { ReloadOutlined } from '@ant-design/icons-vue';
import { queryStudent } from '@/api/score';
import { TABLE_COLUMS } from './data';

export default defineComponent({
  name: 'Score',
  components: { ReloadOutlined },
  setup() {
    const formRef = ref();
    const loading = ref(false);
    const formState = reactive({
      teacher: '',
      academic: '',
      className: '',
    });
    const state = reactive({ columns: TABLE_COLUMS });
    const data = reactive({
      list: [],
    });
    const handleQuery = (params) => {
      loading.value = true;
      queryStudent(params).then((res) => {
        data.list = res;
      }).finally(() => {
        loading.value = false;
      });
    };
    const onFinish = () => {
      handleQuery({ ...formState });
    };
    const handleReload = () => {
      formRef.value.resetFields();
      handleQuery({ ...formState });
    };
    onMounted(() => {
      handleQuery({ ...formState });
    });
    return {
      formRef,
      formState,
      onFinish,
      labelCol: { style: { width: '70px' } },
      wrapperCol: { style: { width: 'auto' } },
      handleReload,
      data,
      ...toRefs(state),
      loading,
    };
  },
});
</script>

<style lang="less" scoped>
.ant-divider-horizontal{
  margin: 15px 0;
}
.table-bar{
  display: flex;
  justify-content: space-between;
  padding: 10px 0;
  .table-right{
    display: flex;
    align-items: center;
    justify-content: flex-end;
    color: rgba(0,0,0,.85);
    font-weight: 500;
    font-size: 16px;
  }
  .table-left{
    display: flex;
    align-items: center;
    justify-content: flex-start;
    color: rgba(0,0,0,.85);
    font-weight: 500;
    font-size: 16px;
  }
}

</style>
