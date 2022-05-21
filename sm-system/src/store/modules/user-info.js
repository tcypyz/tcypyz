import { getInfo } from '@/api/user';
const state = {
  college: '计算机工程系',
  profession: '计算机科学与技术',
  no: '29412767',
};

const getters = {
  getUserInfo(state) {
    const college = state.college;
    const profession = state.profession;
    const no = state.no;
    return { college, profession, no };
  },
};
const mutations = {
  setInfo(state, info) {
    state.college = info.college;
    state.profession = info.profession;
    state.no = info.no;
  },
};

const actions = {
  info({ commit }) {
    return new Promise((resolve, reject) => {
      getInfo().then(res => {
        commit('setInfo', res);
        resolve();
      }).catch((error) => {
        reject(error);
      });
    },
    );
  },
};

export default {
  state,
  getters,
  mutations,
  actions,
};
