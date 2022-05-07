<template>
  <div>
    <a-spin :spinning="spinning">
      <a-table 
        :dataSource="data.list" 
        :columns="TABLE_COLUMS" 
        :pagination="false"
      >
        <template #bodyCell="{ column, record }">
           <template v-if="column.key === 'sex'">
              {{ SexEnum.properties[record.sex].zh }}
            </template>
            <template v-if="column.key === 'action'">
              <span>
                <a @click="handleDelete(record)">删除</a>
                <a-divider type="vertical"/>
                <a @click="handleEdit(record)">编辑</a>
              </span>
            </template>
        </template>
      </a-table>
    </a-spin>
  </div>
</template>

<script>
import { 
  defineComponent, 
  ref, 
  reactive, 
  toRefs, 
  onMounted, 
} from 'vue';
import { getList } from '@/api/teacher';
import { TABLE_COLUMS } from './data';
import { SexEnum } from '@/type/enum';

export default defineComponent({
  setup() {
    const spinning = ref(false);
    const data = reactive({
      pagination: {
        page: 1,
        size: 100,
      },
      list: [],
    });
    const state = reactive({
      SexEnum,
      TABLE_COLUMS,
      handleDelete(row) {},
      handleEdit(row) {},
    });
    const initList = (params) => {
      spinning.value = true;
      getList(params).then(res => {
        data.list = res.list.map(item => {
          return { ...item, key: item.userId };
        });
      }).finally(() => {
        spinning.value = false;
      });
    };
    onMounted(() => {
      initList(data.pagination);
    });
    return {
      spinning,
      data,
      ...toRefs(state),
    };
  },
});
</script>
