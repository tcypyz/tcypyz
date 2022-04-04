import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import { loadPlugins } from '@/plugins';
import 'ant-design-vue/dist/antd.css';
import '@/router/permission';

(() => {
  const app = createApp(App);
  loadPlugins(app);
  app.use(store);
  app.use(router);
  app.mount('#app');
})();
