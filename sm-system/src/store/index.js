import { createStore } from 'vuex';
import modules from './modules';
import { LoginEnum } from '@/type/enum';
export default createStore({
  state: {
    isLogin: LoginEnum.NO_LOGIN,
  },
  getters: {
    getIsLogin(state) {
      if (state.isLogin === LoginEnum.NO_LOGIN) {
        return Number(sessionStorage.getItem('isLogin')) === LoginEnum.LOGIN;
      }
      return true;
    },
  },
  mutations: {
    setIsLogin(state, isLogin) {
      state.isLogin = isLogin;
      sessionStorage.setItem('isLogin', isLogin);
    },
  },
  actions: {
  },
  modules,
});
