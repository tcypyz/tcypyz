<template>
  <a-layout has-sider class="main-layout">
    <a-layout-sider  v-model:collapsed="collapsed" collapsible :trigger="null">
      <div class="logo">
        <div>
          <Icon icon="logos:ant-design" style="font-size: 32px; vertical-align: middle;"/>
          <h1 :style="{display: disable}">学生管理系统</h1>
        </div>
      </div>
      <PermissionMenu :menu="menuList"/>
    </a-layout-sider>
    <a-layout>
      <a-layout-header :style="{ background: '#fff', padding: 0 }">
        <Header :collapsed="collapsed" @clickCollapse="handleClickCollapse"/>
      </a-layout-header>
      <a-layout-content :style="{ margin: '24px 16px 0' }">
        <router-view v-slot="{ Component }">
          <keep-alive>
            <component :is="Component" />
          </keep-alive>
        </router-view>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>

<script>
import { computed, defineComponent, ref } from 'vue';
import { useStore } from 'vuex';
import PermissionMenu from './components/PermissionMenu.vue';
import Header from './components/Header.vue';
export default defineComponent({
  name: 'AdminLayout',
  components: { PermissionMenu, Header },
  setup() {
    const store = useStore();
    const menuList = computed(() => store.getters.getMenu);
    const collapsed = ref(false);
    const handleClickCollapse = () => {
      collapsed.value = !collapsed.value;
    };
    const disable = computed(() => collapsed.value ? 'inline-block' : 'inline-block');
    return {
      collapsed,
      handleClickCollapse,
      menuList,
      disable,
    };
  },
});
</script>

<style lang="less" scoped >
.main-layout{
  min-height: 100vh;
  .logo{
    position: relative;
    height: 64px;
    padding-left: 24px;
    overflow: hidden;
    -webkit-transition: all .3s;
    transition: all .3s;
    line-height: 64px;
    background: #001529;
    h1{
      margin: 0 0 0 12px;
      line-height: 32px;
      color: #fff;
      vertical-align: middle;
    }
  }
}

</style>
