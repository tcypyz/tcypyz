<template>
  <div>
    <div class="page-header">
      <div class="heading-title">工作台</div>
      <div class="header-content">
        <div class="header-avatar">
          <a-avatar
            :size="64"
            src="https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png"
            class="avatar" />
        </div>
        <div class="content-center">
          <div class="center-title">
            早安，{{ username }}，祝你开心每一天！
          </div>
          <div>
            福州大学至诚学院
            <a-divider type="vertical"/>
            {{ userInfo.college }} 
            <a-divider type="vertical"/>
            {{ userInfo.profession }}
            <a-divider type="vertical"/>
            {{ userInfo.no }}
          </div>
        </div>
        <div class="other-info">
          <div class="state-item">
            <a-statistic title="选课门数" :value="data.select" :valueStyle="{ textAlign: 'center' }"/>
          </div>
          <div class="state-item">
            <a-statistic title="总成绩" :value="data.select" :valueStyle="{'text-align': 'center' }"/>
          </div>
        </div>
      </div>
    </div>
    <div class="page-container">
      <div style="margin-bottom: 8px">
        <ClassChart :xAxisData="data.axis" :seriesData="data.series" />
      </div>
      <a-row :gutter="16">
        <a-col :span="16">
          <div>
            <a-card title="已选课程">
              <a-list item-layout="vertical" size="middle" :data-source="data.classList">
                <template #renderItem="{ item }">
                  <a-list-item>
                    <template #extra>
                      {{ `2021-3-12-2021-7-1` }}
                    </template>
                    <a-list-item-meta :description="`授课教师：`+item">
                      <template #title>
                        <a>{{ item }}</a>
                      </template>
                      <template #avatar>
                        <a-avatar style="background-color: #1890ff" size="small">K</a-avatar>
                      </template>
                    </a-list-item-meta>
                  </a-list-item>
                </template>
              </a-list>
            </a-card>
          </div>
        </a-col>
        <a-col :spn="8">
          <div :style=" {width: '485px'}">
            <a-calendar :fullscreen="false"></a-calendar>
          </div>
        </a-col>
      </a-row>
      
    </div>
  </div>
</template>

<script>
import { 
  computed, 
  defineComponent, 
  onMounted, 
  reactive, 
  ref,
} from 'vue';
import { useStore } from 'vuex';
import ClassChart from './components/ClassChart.vue';

export default defineComponent({
  name: 'Dashboad',
  components: { ClassChart },
  setup() {
    const spinning = ref(false);
    const store = useStore();
    const username = computed(() => store.getters.getUsername);
    const userInfo = computed(() => store.getters.getUserInfo);
    const data = reactive({
      select: 0,
      score: 0,
      classList: [],
      axis: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
      series: [10, 52, 200, 334, 390, 330, 220],
    });
    onMounted(() => {
      // store.dispatch('getInfo');
      data.classList = ['数据库', '计算机网络', 'java'];
    });
    return {
      spinning,
      username,
      userInfo,
      data,
    };
  },
});
</script>
<style lang="less" scoped>
.page-header{
  padding: 12px 24px;
  background: #fff;
  .heading-title{
    color: rgba(0,0,0,.85);
    font-weight: 600;
    font-size: 20px;
    line-height: 32px;
  }
  .header-content{
    padding-top: 12px;
    display: flex;
    .header-avatar{
      flex: 0 1 64px;
    }
    .content-center{
      margin-left: 24px;
      color: rgba(0,0,0,.45);
      flex: auto;
      width: 100%;
      .center-title{
        margin-bottom: 12px;
        color: rgba(0,0,0,.85);
        font-weight: 500;
        font-size: 20px;
        line-height: 28px;
      }
    }
    .other-info{
      min-width: 242px;
      margin-left: 88px;
      text-align: right;
      white-space: nowrap;
      .state-item{
        display: inline-block;
        padding: 0 24px;
        position: relative;
      }
      .state-item::after{
        position: absolute;
        top: 8px;
        right: 0;
        width: 1px;
        height: 40px;
        background-color: #e0e0e0;
        content: "";
      }
    }
  }
}
.page-container{
  margin: 20px 0;
  .card-grid{
    color: rgba(0,0,0,.45);
    .class-a{
      display: inline-block;
      height: 24px;
      margin-left: 12px;
      color: rgba(0,0,0,.85);
      font-size: 14px;
      line-height: 24px;
      vertical-align: top;
    }
    .t-text{
      margin: 4px 0;
      line-height: 22px;
    }
  }
}
</style>
