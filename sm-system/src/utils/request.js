import axios from 'axios';
import router from '@/router';
import store from '@/store';
import { message } from 'ant-design-vue';

const service = axios.create({
  baseURL: '/api',
  timeout: 5 * 1000,
});

service.interceptors.request.use(
  config => {
    // 获取后端传来的token
    const token = store.getters.getToken;
    config.headers['Content-Type'] = 'application/json;charset=UTF-8';
    config.data = JSON.stringify(config.data);
    // eslint-disable-next-line dot-notation
    config.headers['token'] = token;
    return config;
  },
  error => {
    console.error('request error', error);
    return Promise.reject(error);
  },
);
service.interceptors.response.use(
  response => {
    return new Promise((resolve, reject) => {
      const data = response.data;
      if (data.code === 200) {
        return resolve(data.data);
      }
      message.error(data.msg);
      if (data.code === 401 || response.status === 401) {
        router.replace('/login');
      }
      return reject(data.msg || 'error');
    });
  }, _error => {
    message.error('服务器异常');
    return Promise.reject(_error);
  },
);
export default service;
