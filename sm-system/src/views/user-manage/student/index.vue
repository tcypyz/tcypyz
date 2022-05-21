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
                <a @click="handleEdit(record)">编辑</a>
              </span>
            </template>
        </template>
      </a-table>
    </a-spin>
  </div>
</template>

<script>
import { defineComponent, onMounted, reactive, ref, toRefs } from 'vue';
import { getList } from '@/api/student';
import { TABLE_COLUMS } from './data';
import { SexEnum } from '@/type/enum';

export default defineComponent({
  setup() {
    const spinning = ref(false);
    const data = reactive({
      list: [],
    });
    const loadList = () => {
      getList()
        .then((res) => {
          data.list = res.map((item) => {
            return { ...item, key: item.userId };
          });
        });
    };
    const state = reactive({
      TABLE_COLUMS,
      SexEnum,
    });
    onMounted(() => {
      loadList();
    });
    return {
      spinning,
      data,
      ...toRefs(state),
    };
  },
});
</script>
