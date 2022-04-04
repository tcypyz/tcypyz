import NProgress from 'nprogress';
import 'nprogress/nprogress.css';
import { message } from 'ant-design-vue';
import router from '@/router';
import store from '@/store';
import { isStringEmpty } from '@/utils';
import { auth } from '@/api/system';
import { getCookieToken } from '@/utils/auth';

NProgress.configure({ showSpinner: false });

router.beforeEach((to, from, next) => {
  const token = getCookieToken();
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
    // next();
    auth().then(() => {
      next();
    }).catch(() => {
      next('/login');
    });
    NProgress.done();
  }
});

router.afterEach(() => {
  NProgress.done();
});
