<template>
  <a-table :columns="columns" :data-source="data">
    <template #bodyCell="{ column, text }">
      <template v-if="column.dataIndex === 'id'">
        <a>{{ text }}</a>
      </template>
    </template>
  </a-table>
</template>

<script>
import { defineComponent, onMounted, reactive } from 'vue';
import { tQueryCourse } from '@/api/t-query-class';
import { TABLE_COLUMS } from './data';

export default defineComponent({
  name: 'TQueryCourse',
  setup() {
    const data = reactive({
      list: [],
    });

    const columns = TABLE_COLUMS;

    const initList = () => {
      tQueryCourse().then((res) => {
        data.list = res;
      });
    };

    onMounted(() => {
      initList();
    });

    return {
      initList,
      columns,
      data,
    };
  },
});
</script>

<style lang="less" scoped></style>
