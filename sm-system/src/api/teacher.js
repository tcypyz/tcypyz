import request from '@/utils/request';
const API = {
  list: '/teacher/list',
};

export function getList(data) {
  return request({
    url: API.list,
    method: 'POST',
    data,
  });
}
