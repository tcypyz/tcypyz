import request from '@/utils/request';

const API = {
  add: '/user/add',
  list: '/user/list',
  edit: '/user/edit',
  del: '/user/delete',
  info: '/user',
  dashboard: '/user/dashboard/info',
  change: '/user/change/password',
};

export function add(data) {
  return request({
    url: API.add,
    method: 'POST',
    data,
  });
}

export function userList(dto) {
  return request({
    url: API.list,
    method: 'post',
    data: dto,
  });
}

export function edit(dto) {
  return request({
    url: API.edit,
    method: 'POST',
    data: dto,
  });
}

export function deleteUser(data) {
  return request({
    url: API.del,
    method: 'POST',
    data,
  });
}

export function getInfo() {
  return request({
    url: API.info,
    method: 'GET',
  });
}

export function getDashboardInfo() {
  return request({
    url: API.dashboard,
    method: 'GET',
  });
}

export function change(data) {
  return request({
    url: API.change,
    method: 'POST',
    data,
  });
}
