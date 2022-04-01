import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import { message } from 'ant-design-vue';
import router from '@/router';
import store from '@/store';
import { isStringEmpty } from '@/utils';
import { auth } from '@/api/system';

const token = store.getters.getToken;
NProgress.configure({ showSpinner: false });

router.beforeEach((to, from, next) => {
  NProgress.start();
  if (isStringEmpty(token)) {
    next({ path: '/login', query: { redirect: to.fullPath } });
    message.error('请先登录！');
    NProgress.done();
  } else {
    auth().then(() => {
      next();
    }).catch(() => {
      next('/login');
    }).finally(() => {
      NProgress.done();
    });
  }
});

router.afterEach(() => {
  NProgress.done();
});
