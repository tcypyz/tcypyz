export const formData = {
  no: '',
  name: '',
  password: '123456',
  sex: 2,
  phone: '',
  birth: '',
  college: '',
  role: null,
  profession: '',
  occupation: '',
};

export const formRules = {
  no: [{
    required: true,
    message: '请输入学号',
  }],
  name: [{
    required: true,
    message: '请输入用户名',
  }],
  password: [{
    required: true,
    message: '请输入密码',
  }],
};
export const columns = [
  {
    title: '名字',
    dataIndex: 'name',
    key: 'name',
  },
  {
    title: '年龄',
    dataIndex: 'age',
    key: 'age',
  },
  {
    title: '性别',
    dataIndex: 'sex',
    key: 'sex',
  },
  {
    title: '电话',
    dataIndex: 'phone',
    key: 'phone',
  },
  {
    title: '角色',
    dataIndex: 'role',
    key: 'role',
  },
  {
    title: '操作',
    key: 'action',
  },
];

