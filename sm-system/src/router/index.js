import { createRouter, createWebHistory } from 'vue-router';
import store from '@/store';

import routes from '@/router/routes';

console.log(store);
const token = store.getters.getToken;

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});
router.beforeEach((to, from, next) => {
  if (token) {
    next();
  } else {
    next();
  }
});

export default router;
