import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import { loadPlugins } from '@/plugins';
import registerComponents from '@/components/register';
// 路由权限钩子函数
import '@/router/permission';
import 'ant-design-vue/dist/antd.css';

(() => {
  const app = createApp(App);
  // 加载plugins下所有插件
  loadPlugins(app);
  // 注册所有公共组件
  registerComponents(app);
  app.use(store);
  app.use(router);
  app.mount('#app');
})();
