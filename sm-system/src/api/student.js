import request from '@/utils/request';

const API = {
  list: '/student/list',
};

export function getList() {
  return request({
    url: API.list,
    method: 'post',
  });
}
