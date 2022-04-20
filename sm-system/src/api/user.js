import request from '@/utils/request';

const API = {
  add: '/user/add',
  list: '/user/list',
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
