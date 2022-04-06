import { isStringEmpty } from '@/utils';
import { setCookieToken, getCookieToken, removeCookieToken } from '@/utils/auth';

const state = {
  username: '',
  token: '',
  role: '',
  id: 0,
  sex: -1,
  phone: '',
};
const getters = {
  getToken(state) {
    const token = state.token;
    return isStringEmpty(token) ? getCookieToken() : token;
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
    return id === 0 ? Number(sessionStorage.getItem('id')) : id;
  },
  getSex(state) {
    const sex = state.sex;
    return sex === -1 ? Number(sessionStorage.getItem('sex')) : sex;
  },
  getPhone(state) {
    const phone = state.phone;
    return isStringEmpty(phone) ? sessionStorage.getItem('phone') : phone;
  },
};

const mutations = {
  setToken(state, token) {
    state.token = token;
    setCookieToken(token);
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
  logout(context) {
    context.commit('setUsername', '');
    context.commit('setRole', '');
    context.commit('setSex', -1);
    context.commit('setPhone', '');
    context.commit('setId', 0);
    context.commit('setToken', '');
    sessionStorage.clear();
    removeCookieToken();
  },
};

export default {
  state,
  getters,
  mutations,
  actions,
};
