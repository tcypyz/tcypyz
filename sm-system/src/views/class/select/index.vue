<template>
  <div>
    <a-card title="选课">
      <a-steps class="top-steps" :current="current">
        <a-step title="课程选择" />
        <a-step title="课程确认" />
        <a-step title="完成" />
      </a-steps>
      
      <div v-if="current === 0">
        <div class="table-bar">
          <div class="table-left">
            <a-button 
              class="next-btn" 
              type="primary" 
              @click="next"
              :disabled="data.selectedRowKeys.length === 0"
            >下一步</a-button>
          </div>
          <div class="table-right">
            <ReloadOutlined @click="loadList"/>
          </div>
        </div>
        <a-table
          :data-source="data.tableList"
          :columns="columns"
          :loading="loading"
          :pagination="false"
          :row-selection="{
            selectedRowKeys: data.selectedRowKeys, 
            onChange: onSelectChange, 
            getCheckboxProps: getCheckboxProps,
          }"
        >
          <template #bodyCell="{ column, record }">
            <template v-if="column.key === 'status'">
              <a-badge :status="selectStatus(record.status)" :text="StatusEnum.properties[record.status].desc"></a-badge>
            </template>
          </template>
        </a-table>
      </div>
      <div v-else-if="current === 1">
        <a-typography-title  :level="2">课程确认</a-typography-title>
        <a-divider></a-divider>
         <a-list :grid="{ gutter: 16, column: 4 }" :data-source="data.list">
          <template #renderItem="{ item }">
            <a-list-item>
              <a-card :title="item.name" hoverable>
                {{ item.teacher }}<br/>
                <a-typography-text type="secondary">{{ item.time}}</a-typography-text>
              </a-card>
            </a-list-item>
          </template>
         </a-list>

        <a-button style="margin-left: 8px" @click="prev">返回</a-button>
        <a-button 
          class="next-btn" 
          type="primary" 
          @click="handleCommit"
          :loading="btnLoading"
        >确认</a-button>
      </div>
      <div v-else-if="current === 2">
        <a-result
          status="success"
          title="恭喜你完成选课！"
          sub-title="选课完成，你可以选择继续选课，或者退出系统。"
        >
          <template #extra>
            <a-button key="console" type="primary" @click="handleFinish">继续选课</a-button>
          </template>
        </a-result>
      </div>
    </a-card>
  </div>
</template>

<script>
import { defineComponent, onMounted, reactive, ref } from 'vue';
import { ReloadOutlined } from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import { TABLE_COLUMNS } from './data';
import { StatusEnum } from '@/type/enum';
import { getEnableSchedule, addSelect } from '@/api/select-class';

export default defineComponent({
  name: 'Select',
  components: { ReloadOutlined },
  setup() {
    const current = ref(0);
    const loading = ref(false);
    const btnLoading = ref(false);
    const data = reactive({
      tableList: [],
      selectedRowKeys: [],
      list: [],
    });
    const loadList = () => {
      loading.value = true;
      getEnableSchedule().then(res => {
        data.tableList = res.map(element => { return { ...element, key: element.id }; });;
      }).finally(() => {
        loading.value = false;
      });
    };
    const next = () => {
      current.value++;
    };
    const prev = () => {
      current.value--;
    };
    const handleCommit = () => {
      btnLoading.value = true;
      addSelect({ idList: data.selectedRowKeys }).then(() => {
        message.success('添加成功');
        next();
      }).catch(() => {
        message.error('添加课程失败，请重试！');
      }).finally(() => {
        btnLoading.value = false;
      });
    };
    const state = {
      columns: TABLE_COLUMNS,
      selectStatus(index) {
        switch (index) {
          case StatusEnum.NO_OPENT: return 'warning';
          case StatusEnum.OPENED: return 'processing';
          case StatusEnum.FINISH: return 'default';
          default: return 'error';
        }
      },
      StatusEnum,
      onSelectChange(selectedRowKeys) {
        data.selectedRowKeys = selectedRowKeys;
        data.list = data.tableList.filter(item => data.selectedRowKeys.includes(item.key));
      },
      getCheckboxProps: record => ({
        disabled: record.status === StatusEnum.FINISH,
      }),
    };
    const handleFinish = () => {
      loadList();
      data.list = [];
      data.selectedRowKeys = [];
      current.value = 0;
    };
    onMounted(() => {
      loadList();
    });
    return {
      current,
      next,
      prev,
      ...state,
      loading,
      data,
      loadList,
      handleCommit,
      btnLoading,
      handleFinish,
    };
  },
});
</script>
<style lang="less" scoped>
.top-steps{
  margin-bottom: 30px;
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
    .next-btn{
      margin-right: 10px;
    }
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
