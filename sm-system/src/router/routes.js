import Login from '@/views/login';
import AdminLayout from '@/layout';

export default [
  {
    path: '/',
    name: 'home',
    redirect: '/login',
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
  },
  {
    path: '/admin',
    name: 'admin',
    redirect: '/admin/dashboard',
    component: AdminLayout,
    children: [
      {
        path: '/admin/dashboard',
        name: 'dashboard',
        component: () => import('@/views/dashboard/index.vue'),
      },
    ],
  },
  {
    path: '/:pathMatch(.*)*',
    name: '404',
    component: () => import('@/views/404/index.vue'),
  },
];
