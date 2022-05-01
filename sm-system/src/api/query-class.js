import request from '@/utils/request';

const API = {
  add: '/selectCourse/studentAddCourse',
  del: '/selectCourse/studentDeleteCourse',
};

export function add(data) {
  return request({
    url: API.add,
    method: 'post',
    data,
  });
}

export function del(data) {
  return request({
    url: API.del,
    method: 'post',
    data,
  });
}
