import request from '@/utils/request';

const API = {
  login: '/sys/login',
  auth: '/sys/authentication',
};

export function login(params) {
  return request({
    url: API.login,
    method: 'POST',
    data: params,
  });
}

export function auth() {
  return request({
    url: API.auth,
    method: 'GET',
  });
}
