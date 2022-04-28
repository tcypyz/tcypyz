import BaseTable from './BaseTable/index.vue';

const components = [
  BaseTable,
];

export default function (app) {
  components.forEach(component => {
    app.component(component.name, component);
  });
};
