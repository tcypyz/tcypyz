import request from '@/utils/request';

const API = {
  login: '/sys/login',
  auth: '/sys/authentication',
  logout: '/sys/logout',
  menu: '/user/menu',
  role: '',
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

export function getMenu() {
  return request({
    url: API.menu,
    method: 'GET',
  });
}

export function getRole() {
  return request({
    url: API.role,
    method: 'GET',
  });
}
