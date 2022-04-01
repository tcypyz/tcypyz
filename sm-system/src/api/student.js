import request from '@/utils/request';

const API = {
  st: '/student/filter',
};

export function st() {
  return request({
    url: API.st,
    method: 'GET',
  });
}
