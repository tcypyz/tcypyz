import request from '@/utils/request';

const API = {
  add: '/user/add',
  list: '/user/list',
  edit: '/user/edit',
  del: '/user/delete',
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
