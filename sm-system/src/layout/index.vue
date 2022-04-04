<template>
  <a-layout has-sider class="main-layout">
    <a-layout-sider  v-model:collapsed="collapsed" collapsible :trigger="null">
      <div class="logo">
        <h1 v-if="!collapsed">学生管理系统</h1>
      </div>
      <PermissionMenu />
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
import { defineComponent, ref } from 'vue';
import PermissionMenu from './components/PermissionMenu.vue';
import Header from './components/Header.vue';
export default defineComponent({
  name: 'AdminLayout',
  components: { PermissionMenu, Header },
  setup() {
    const collapsed = ref(false);
    const handleClickCollapse = () => {
      collapsed.value = !collapsed.value;
    };
    return {
      collapsed,
      handleClickCollapse,
    };
  },
});
</script>

<style lang="less" scoped >
.main-layout{
  min-height: 100vh;
  .logo{
    text-align: center;
    height: 32px;
    margin: 16px;
    h1{
      line-height: 32px;
      color: #fff;
    }
  }
}

</style>
