import request from '@/utils/request';

const API = {
  selCourse: '/course/studentSelected',
};

export function selCourse() {
  return request({
    url: API.selCourse,
    method: 'get',
  });
}
