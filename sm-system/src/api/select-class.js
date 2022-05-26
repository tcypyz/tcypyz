import request from '@/utils/request';

const API = {
  selCourse: '/select/course/studentSelected',
  schedule: '/select/course/enable/schedule',
  add: '/select/course/add',
};

export function selCourse() {
  return request({
    url: API.selCourse,
    method: 'get',
  });
}

export function getEnableSchedule() {
  return request({
    url: API.schedule,
    method: 'GET',
  });
}

export function addSelect(data) {
  return request({
    url: API.add,
    method: 'POST',
    data,
  });
}
