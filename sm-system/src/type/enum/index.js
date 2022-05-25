export const SexEnum = {
  MALE: 1,
  FEMALE: 0,
  properties: {
    1: { no: 1, zh: '男', en: 'male' },
    0: { no: 0, zh: '女', en: 'female' },
  },
};

export const RoleEnum = {
  ADMIN: 1,
  STUDENT: 2,
  TEACHER: 3,
  properties: {
    1: { id: 1, zh: '管理员', name: 'admin' },
    2: { id: 2, zh: '学生', name: 'teacher' },
    3: { id: 3, zh: '教师', name: 'student' },
  },
};

export const StatusEnum = {
  NO_OPENT: 0,
  OPENED: 1,
  FINISH: 2,
  properties: {
    0: { id: 0, desc: '未开课' },
    1: { id: 1, desc: '开课中' },
    2: { id: 2, desc: '已结束' },
  },
};
