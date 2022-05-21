import BaseEchart from './base-echart/index.vue';
import Loading from './Loading/index.vue';

const components = [
  BaseEchart,
  Loading,
];

export default function (app) {
  components.forEach(component => {
    app.component(component.name, component);
    console.log(component.name);
  });
};
