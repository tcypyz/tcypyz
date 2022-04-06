import { isStringEmpty } from '@/utils';
const state = {
  menu: [],
  current_router: '',
};

const getters = {
  getMenu(state) {
    return state.menu;    
  },
  getPath(state) {
    const path = state.current_router;
    return isStringEmpty(path) ? localStorage.getItem('path') : path;
  },
};

const mutations = {
  setMenu(state, menu) {
    state.menu = menu;
  },
  changeCurrentRouter(state, path) {
    state.current_router = path;
    localStorage.setItem('path', path);
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
