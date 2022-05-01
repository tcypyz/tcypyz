<template>
  <div class="course-sel">
    <div class="course-tab">
      <div class="tab-item current">我学的课</div>
    </div>
    <div>
      <ul class="course-list">
        <li class="course" v-for="(course, index) in courseList" :key="index">
          <a-card hoverable style="width: 270px">
            <template #cover>
              <img
                alt="FAILED TO LOAD PICTURE"
                src="../../../assets/course.jpg"
              />
            </template>
            <a-card-meta>
              <template #title>
                {{ course.className }}
              </template>
              <template #description>
                <p>{{ course.academic }}</p>
                <p>{{ course.teacher }}</p>
                <p>开课时间：{{ course.createTime }}-{{ course.endTime }}</p>
              </template>
            </a-card-meta>
          </a-card>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { defineComponent, ref, onMounted } from 'vue';
import { selCourse } from '@/api/select-class';

export default defineComponent({
  name: 'SelCourse',
  setup() {
    const courseList = ref([
      {
        className: '',
        academic: '',
        teacherName: '',
        createTime: '',
        endTime: '',
      },
    ]);
    const handleSelCourse = () => {
      selCourse().then((res) => {
        courseList.value = res;
      });
    };
    onMounted(() => {
      handleSelCourse();
    });

    return {
      courseList,
      handleSelCourse,
    };
  },
});
</script>

<style lang="less" scoped>
ul,
li {
  list-style: none;
  padding: 0;
  margin: 0;
}

.course-tab {
  height: 60px;
  box-shadow: 0px -1px 0px 0px #f2f2f2 inset;
  padding: 0 30px;
  font-size: 0;
  .tab-item {
    position: relative;
    display: inline-block;
    margin-right: 30px;
    padding: 0 24px;
    text-align: center;
    line-height: 60px;
    font-size: 16px;
    color: #646873;
  }
}

.course-tab .tab-item.current {
  position: relative;
  font-weight: 500;
  color: hsl(227, 36%, 15%);
}

.tab-item.current::after {
  position: absolute;
  bottom: 0;
  left: 50%;
  transform: translateX(-50%);
  content: ' ';
  width: 34px;
  height: 4px;
  background: #3b90ff;
  border-radius: 2px;
}

.course-list {
  font-size: 0;
  padding: 30px 30px 0;
  overflow: hidden;
  width: 100%;
  li {
    position: relative;
    float: left;
    box-sizing: border-box;
    font-size: 12px;
    vertical-align: top;
    overflow: visible;
    cursor: pointer;
    margin-right: 40px;
    margin-bottom: 0;
  }
}
</style>
