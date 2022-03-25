import { isStringEmpty } from '@/utils';

const state = {
  username: '',
  token: '',
  role: '',
  id: '',
  sex: '',

};
const getters = {
  getToken(state) {
    const token = state.token;
    return isStringEmpty(token) ? sessionStorage.getItem('token') : token;
  },
};

const mutations = {
  setToken(state, token) {
    state.token = token;
    sessionStorage.setItem('token', token);
  },
};

const actions = {

};

export default {
  state,
  getters,
  mutations,
  actions,
};
