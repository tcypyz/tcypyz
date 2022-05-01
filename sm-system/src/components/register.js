

const components = [

];

export default function (app) {
  components.forEach(component => {
    app.component(component.name, component);
  });
};
