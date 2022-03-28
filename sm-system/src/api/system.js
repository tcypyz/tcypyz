import request from '@/utils/request';

const API = {
  login: '/sys/login',
};

export function login(params){
  return request({
    url: API.login,
    method: 'POST',
    data: params,
  })
}
