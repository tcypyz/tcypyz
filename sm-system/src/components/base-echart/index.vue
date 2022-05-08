<template>
  <div class="base-echart">
    <div ref="eChartDivRef" :style="{ width: width, height: height }" />
  </div>
</template>
<script>
import { 
  defineComponent, 
  ref,
  onMounted,
  watchEffect, 
} from 'vue';
import useEchars from '@/utils/useEchars';
export default defineComponent({
  name: 'BaseEchart',
});
</script>

<script setup>
const props = defineProps({
  width: {
    type: String,
    default: '100%',
  },
  height: {
    type: String,
    default: '360px',
  },
  options: {
    type: Object,
    required: true,
    default: () => {},
  },
});
const eChartDivRef = ref();
onMounted(() => {
  const { setOptions } = useEchars(eChartDivRef.value);
  watchEffect(() => {
    setOptions(props.options);
  });
});
</script>
<style lang="less">
.base-echart{
  margin: 0;
  background-color:white;
}
</style>
