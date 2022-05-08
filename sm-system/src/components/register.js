import BaseEchart from './base-echart/index.vue';

const components = [
  BaseEchart,
];

export default function (app) {
  components.forEach(component => {
    app.component(component.name, component);
    console.log(component.name);
  });
};
