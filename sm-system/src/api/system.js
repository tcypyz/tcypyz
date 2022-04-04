import request from '@/utils/request';

const API = {
  login: '/sys/login',
  auth: '/sys/authentication',
  logout: '/sys/logout',
};

export function login(params) {
  return request({
    url: API.login,
    method: 'POST',
    data: params,
  });
}

export function logout() {
  return request({
    url: API.logout,
    method: 'GET',
  });
}

export function auth() {
  return request({
    url: API.auth,
    method: 'GET',
  });
}
