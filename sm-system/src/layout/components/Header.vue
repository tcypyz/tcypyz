<template>
  <MenuUnfoldOutlined v-if="collapsed" class="trigger" @click="handleCollapsed" />
  <MenuFoldOutlined v-else class="trigger" @click="handleCollapsed" />
  <div class="header-right">
    <a-dropdown class="dropdown">
      <div>
        <a-avatar
          size="small"
          src="https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png"
          class="avatar" />
        <span>{{ username }}</span>
      </div>

      <template v-slot:overlay>
        <a-menu>
          <a-menu-item >
            <div class="drop-item">
              <SettingOutlined class="icon"/>个人设置
            </div>
          </a-menu-item>
          <a-menu-item >
            <div class="drop-item" @click="handleLogout">
              <LoginOutlined class="icon"/>退出登录
            </div>
          </a-menu-item>
        </a-menu>
      </template>
    </a-dropdown>
  </div>
</template>

<script>
import { defineComponent, computed } from 'vue';
import {
  MenuUnfoldOutlined,
  MenuFoldOutlined,
  SettingOutlined,
  LoginOutlined,
} from '@ant-design/icons-vue';
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import { logout } from '@/api/system';

export default defineComponent({
  name: 'Header',
  props: {
    collapsed: Boolean,
  },
  emits: ['clickCollapse'],
  components: {
    MenuUnfoldOutlined,
    MenuFoldOutlined,
    SettingOutlined,
    LoginOutlined,
  },
  setup(_, { emit }) {
    const store = useStore();
    const { replace } = useRouter();
    const username = computed(() => store.getters.getUsername);
    const handleCollapsed = () => {
      emit('clickCollapse');
    };
    const handleLogout = () => {
      logout().then().finally(() => {
        store.dispatch('logout');
        replace('/login');
      });
    };
    return {
      handleCollapsed,
      username,
      handleLogout,
    };
  },
});
</script>

<style lang="less" scoped>
.trigger{
  font-size: 18px;
  line-height: 64px;
  padding: 0 24px;
  cursor: pointer;
  transition: color .3s;
}
.trigger:hover{
  color: #1890ff;
}
.header-right{
  float: right;
  height: 100%;
  margin-left: auto;
  margin-right: 8px;
  .dropdown{
    padding: 0 10px;

  }
  .dropdown:hover{
    background: rgba(0,0,0,.025);
  }
  .avatar{
    margin-right: 8px;
  }
}
.drop-item{
  font-weight: 400;
  min-width: 120px;
  font-size: 12px;
  .icon{
    margin-right: 8px;
  }
}
</style>
