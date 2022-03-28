import axios from 'axios';
import router from '@/router'
import store from '@/store';

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

    });
  }, error => {

  }
);
export default service;
