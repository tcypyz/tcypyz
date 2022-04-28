<template>
  <router-view v-slot="{ Component }">
    <transition name="fade" mode="out-in" appear>
      <keep-alive>
        <component :is="Component" />
      </keep-alive>
    </transition>
  </router-view>
</template>

<style>
.fade-enter.fade-enter-active,
.fade-appear.fade-appear-active {
    -webkit-animation-name: none;
    animation-name: none;
}

.fade-leave.fade-leave-active {
    -webkit-animation-name: none;
    animation-name: none;
}
</style>
