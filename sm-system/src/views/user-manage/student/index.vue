<template>
  <div>
    <a-spin :spinning="spinning">
      <a-table 
        :dataSource="data.list" 
        :columns="TABLE_COLUMS" 
        :pagination="false"
      >
      </a-table>
    </a-spin>
  </div>
</template>

<script>
import { 
  defineComponent, 
  onMounted, 
  reactive, 
  ref, 
  toRefs, 
} from 'vue';
import { getList } from '@/api/student';
import { TABLE_COLUMS } from './data';

export default defineComponent({
  setup() {
    const spinning = ref(false);
    const data = reactive({
      list: [],
    });
    const loadList = () => {
      getList().then(res => {

      });
    };
    const state = reactive({
      TABLE_COLUMS,
    });
    onMounted(() => {
      // loadList();
    });
    return {
      spinning,
      data,
      ...toRefs(state),
    };
  },
});
</script>
