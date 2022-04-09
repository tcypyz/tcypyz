import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import { message } from 'ant-design-vue';
import router from '@/router';
import store from '@/store';
import { isStringEmpty, isArrayEmpty } from '@/utils';
import { getCookieToken } from '@/utils/auth';
import { auth, getMenu } from '@/api/system';
import AdminLayout from '@/layout/index.vue';

NProgress.configure({ showSpinner: false });

router.beforeEach((to, from, next) => {
  const token = getCookieToken();
  const menu = store.getters.getMenu;
  NProgress.start();
  
  if (isStringEmpty(token)) {
    if (to.fullPath.includes('/login')) {
      next();
      NProgress.done();
    } else {
      message.error('请先登录！');
      next(`/login?redirect=${to.path}`);
      NProgress.done();
    }
  } else {
    auth().then(() => {
      if (isArrayEmpty(menu)) {
        asyncRouter(router);
        next({ ...to, replace: true });
      } else {
        next();
      }
    }).catch(() => {
      next('/');
    });
    NProgress.done();
  }
});

router.afterEach(() => {
  NProgress.done();
});

const asyncRouter = function (router) {
  getMenu().then((res) => {
    const fmtRouter = assembleMenu(res);
    fmtRouter.forEach(item => {
      if (!isArrayEmpty(item.children)) {
        router.addRoute(item);
      } else {
        router.addRoute('admin', item);
      }
    });
    store.commit('setMenu', fmtRouter);
  });
};

const assembleMenu = function (route) {
  const resRouter = [];
  route.forEach(item => {
    if (!isArrayEmpty(item.children)) {
      item.children = assembleMenu(item.children);
    }
    const fmtRoute = {
      ...item,
      component: item.component === 'layout'
        ? AdminLayout
        : () => require('@/views/' + item.component + '/index.vue'),
    };
    resRouter.push(fmtRoute);
  });
  return resRouter;
};

