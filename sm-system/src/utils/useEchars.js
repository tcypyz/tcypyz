import * as echarts from 'echarts';

export default function (el) {
  const echartInstance = echarts.init(el);
  const setOptions = (options) => {
    echartInstance.setOption(options);
  };
  const updateSize = () => {
    echartInstance.resize();
  };

  window.addEventListener('resize', () => {
    echartInstance.resize();
  });

  return {
    echartInstance,
    setOptions,
    updateSize,
  };
}
