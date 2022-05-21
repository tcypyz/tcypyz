import request from '@/utils/request';

const API = {
  TqueryCourse: '/course/teacherSelectClass',
};

export function TqueryCourse() {
  return request({
    url: API.selCourse,
    method: 'get',
  });
}
