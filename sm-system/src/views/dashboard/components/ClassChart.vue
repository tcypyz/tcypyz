<template>
  <div>
    <BaseEchart :options="options" />
  </div>
</template>

<script>
import { computed, defineComponent } from 'vue';
export default defineComponent({
  name: 'ClassChart',
  props: {
    xAxisData: {
      type: Array,
      default: () => [],
    },
    seriesData: {
      type: Array,
      default: () => [],
    },
  },
  setup(props) {
    console.log(props.t);
    const options = computed(() => {
      return {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow',
          },
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true,
        },
        xAxis: [
          {
            type: 'category',
            data: props.xAxisData,
            axisTick: {
              alignWithLabel: true,
            },
          },
        ],
        yAxis: [
          {
            type: 'value',
          },
        ],
        series: [
          {
            name: '人数',
            type: 'bar',
            barWidth: '60%',
            data: props.seriesData,
          },
        ],
      };
    });
    return {
      options,
    };
  },
});
</script>
