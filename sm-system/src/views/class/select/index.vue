<template>
  <div>
    <a-card title="选课">
      <a-steps class="top-steps" :current="current">
        <a-step title="课程选择" />
        <a-step title="课程确认" />
        <a-step title="完成" />
      </a-steps>

      <a-button style="margin-left: 8px" @click="prev">Previous</a-button>
      
      <div v-if="current === 0">
        <div class="table-bar">
          <div class="table-left">
            <a-button class="next-btn" type="primary" @click="next">下一步</a-button>
          </div>
          <div class="table-right">
            <ReloadOutlined @click="handleReload"/>
          </div>
        </div>
        <a-table
          :dataS-source="data.list"
          :columns="columns"
          :loading="loading"
          :pagination="false"
          :row-selection="{selectedRowKeys: data.selectedRowKeys, onChange: onSelectChange}"
        >
          <template #bodyCell="{ column, record }">
            <template v-if="column.key === 'status'">
              <a-badge :status="selectStatus(record.status)" :text="StatusEnum.properties[record.status].desc"></a-badge>
            </template>
          </template>
        </a-table>
      </div>
    </a-card>
  </div>
</template>

<script>
import { defineComponent, onMounted, reactive, ref } from 'vue';
import { ReloadOutlined } from '@ant-design/icons-vue';
import { TABLE_COLUMNS } from './data';
import { StatusEnum } from '@/type/enum';

export default defineComponent({
  name: 'Select',
  components: { ReloadOutlined },
  setup() {
    const current = ref(0);
    const loading = ref(false);
    const data = reactive({
      list: [],
      selectedRowKeys: [],
    });
    const next = () => {
      current.value++;
    };
    const prev = () => {
      current.value--;
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
      },
    };
    onMounted(() => {
      
    });
    return {
      current,
      next,
      prev,
      ...state,
      loading,
      data,
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
