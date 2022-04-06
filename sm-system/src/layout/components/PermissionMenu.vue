<template>
  <a-menu 
    theme="dark"
    mode="inline"
    v-model:selectedKeys="selectedKeys"
  >
    <template v-for="item in menu" :key="item.name">
      <a-menu-item 
        v-if="isArrayEmpty(item.children)" 
        :key="item.path"
        @click="handleClick(item)"
      >
        <template #icon>
          <Icon :icon="item.icon" style="font-size: 16px;"/>
        </template>
        <router-link :to="item.path">{{ item.menuName }}</router-link>
      </a-menu-item>
      <a-sub-menu v-else :key="item.path + ':sub'">
        <template #icon>
          <Icon :icon="item.icon" style="font-size: 16px;" /> 
        </template>
        <template #title>{{ item.menuName }}</template>
        <a-menu-item
          v-for="child in item.children" 
          :key="child.name"
          @click="handleClick(child)"
        >
          <template #icon>
            <Icon :icon="child.icon" style="font-size: 16px;" />
          </template>
          <router-link :to="child.path">{{ child.menuName }}</router-link>
        </a-menu-item>
      </a-sub-menu>
    </template>
  </a-menu>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { useStore } from 'vuex';
import { isArrayEmpty } from '@/utils';
export default defineComponent({
  name: 'PermissionMenu',
  props: {
    menu: {
      type: Array,
      default: () => [], 
    },
    collapsed: {
      type: Boolean,
      default: false,
    },
  },
  setup() {
    const { commit } = useStore();
    const selectedKeys = ref(['/admin/dashboard']);
    const handleClick = (item) => {
      commit('changeCurrentRouter', item.path);
    };
    return {
      handleClick,
      isArrayEmpty,
      selectedKeys,
    };
  },
});
</script>

<style lang="less">
</style>
