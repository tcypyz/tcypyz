import request from '@/utils/request';

const API = {
  add: '/user/add',
};

export function add(data) {
  return request({
    url: API.add,
    method: 'POST',
    data,
  });
}
