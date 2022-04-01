import { isStringEmpty } from '@/utils';

const state = {
  username: '',
  token: '',
  role: '',
  id: 0,
  sex: 0,
  phone: '',
};
const getters = {
  getToken(state) {
    const token = state.token;
    return isStringEmpty(token) ? sessionStorage.getItem('token') : token;
  },
  getUsername(state) {
    const name = state.username;
    return isStringEmpty(name) ? sessionStorage.getItem('username') : name;
  },
  getRole(state) {
    const role = state.role;
    return isStringEmpty(role) ? sessionStorage.getItem('role') : role;
  },
  getId(state) {
    const id = state.id;
    return isStringEmpty(id) ? Number(sessionStorage.getItem('id')) : id;
  },
  getSex(state) {
    const sex = state.sex;
    return isStringEmpty(sex) ? Number(sessionStorage.getItem('sex')) : sex;
  },
  getPhone(state) {
    const phone = state.phone;
    return isStringEmpty(phone) ? sessionStorage.getItem('phone') : phone;
  },
};

const mutations = {
  setToken(state, token) {
    state.token = token;
    sessionStorage.setItem('token', token);
  },
  setUsername(state, item) {
    state.username = item;
    sessionStorage.setItem('username', item);
  },
  setRole(state, item) {
    state.role = item;
    sessionStorage.setItem('role', item);
  },
  setSex(state, item) {
    state.sex = item;
    sessionStorage.setItem('sex', item);
  },
  setId(state, item) {
    state.id = item;
    sessionStorage.setItem('id', item);
  },
  setPhone(state, item) {
    state.phone = item;
    sessionStorage.setItem('phone', item);
  },
};

const actions = {
  userInfo(context, user) {
    context.commit('setUsername', user.username);
    context.commit('setRole', user.role);
    context.commit('setSex', user.sex);
    context.commit('setPhone', user.phone);
    context.commit('setId', user.id);
  },
};

export default {
  state,
  getters,
  mutations,
  actions,
};
