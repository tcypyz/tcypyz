import request from '@/utils/request';

const API = {
  query: '/score/student/query',
};

export function queryStudent(data) {
  return request({
    url: API.query,
    method: 'POST',
    data,
  });
};
