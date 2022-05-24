import request from '@/utils/request';

const API = {
  TqueryCourse: '/course/teacherSelectClass',
  addCourse: '/course/',
};

export function tQueryCourse() {
  return request({
    url: API.selCourse,
    method: 'get',
  });
}

export function addCourse(data) {
  return request({
    url: API.addCourse,
    method: 'POST',
    data,
  });
}
