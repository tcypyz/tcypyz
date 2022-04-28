<template>
  <a-card :bordered="false">
    {{ load }}
    <div class="table-page-wrapper">
      <div class="table-toolbar-left">
          {{ tableTitle }}
      </div>
      <div class="table-toolbar-right">
        <a-space>
          <a-button danger :disabled="showDel" @click="handleDeleteAll">删除全部</a-button>
          <ReloadOutlined @click="handleReload"/>
        </a-space>
      </div>
    </div>
    <a-table 
      :columns="columns" 
      :data-source="data" 
      :pagination="false"
      :row-selection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
    >
    <template #bodyCell="{ column, record }">
      <template v-if="column.key === 'role'">
        <a-tag :color="selectColor(record.roleId)">{{ record.role }}</a-tag>
      </template>
      <template v-if="column.key === 'sex'">
        {{ SexEnum.properties[record.sex].zh }}
      </template>
      <template v-if="column.key === 'action'">
        <span>
          <a v-if="showDelete" @click="handleDelete(record)">删除</a>  
          <a-divider v-if="showDivider" type="vertical" />
          <a v-if="showEdit" @click="handleEdit(record)">编辑</a>
        </span>
      </template>
    </template>
    </a-table>
    <a-pagination 
      v-model:current="current"
      v-model:pageSize="pageSize"
      class="table-page"
    ></a-pagination>
  </a-card>
</template>

<script>
import { computed, defineComponent, reactive, toRefs } from 'vue';
import { ReloadOutlined } from '@ant-design/icons-vue';
import { tableProps } from './props';
import { SexEnum, RoleEnum } from '@/type/enum';
export default defineComponent({
  name: 'BaseTable',
  props: { 
    ...tableProps,
  },
  components: { ReloadOutlined },
  emits: ['onReload', 'onDelete', 'edit', 'deleteAll'],
  setup(props, { emit }) {
    const state = reactive({
      selectedRowKeys: [],
    });
    const showDivider = computed(() => props.showDelete && props.showEdit);
    const showDel = computed(() => state.selectedRowKeys.length === 0); 
    const onSelectChange = (selectedRowKeys) => {
      state.selectedRowKeys = selectedRowKeys;
    };
    const handleReload = () => {
      emit('onReload');
    };
    const handleDelete = (row) => {
      emit('onDelete', [row.id]);
    };
    const handleEdit = (r) => {
      emit('edit', r);
    };
    const handleDeleteAll = () => {
      emit('deleteAll', state.selectedRowKeys);
    };
    const selectColor = (id) => {
      switch (id) {
        case RoleEnum.ADMIN: return 'red';
        case RoleEnum.TEACHER: return 'green';
        case RoleEnum.STUDENT: return 'blue';
        default: return 'blue';
      }
    }; 
    return {
      ...toRefs(state),
      onSelectChange,
      handleReload,
      handleDelete,
      handleEdit,
      showDivider,
      showDel,
      SexEnum,
      RoleEnum,
      selectColor,
      handleDeleteAll,
    };
  },
});
</script>

<style lang="less" scoped>
.ant-card{
  &:deep(.ant-card-body){
    padding-top: 0;
  }
}

.table-page-wrapper{
  display: flex;
  justify-content: space-between;
  padding: 16px 0;
  .table-toolbar-left{
    display: flex;
    align-items: center;
    justify-content: flex-start;
    color: rgba(0,0,0,.85);
    font-weight: 500;
    font-size: 16px;
  }
  .table-toolbar-right{
    display: flex;
    justify-content: flex-end;
    align-items: center;
  }
}

.table-page{
  margin-top: 16px;
  justify-content: flex-end;
  display: flex;
  flex-wrap: wrap;
  row-gap: 8px;
}
</style>
