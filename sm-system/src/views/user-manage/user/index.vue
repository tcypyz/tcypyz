<template>
  <div>
    <a-button type="primary" @click="showDrawer"  :style="{ marginBottom: '10px' }">
      <template #icon>
        <PlusOutlined/>
      </template>
      新用户
    </a-button>
    <a-drawer
      :width="500"
      title="新添用户"
      :closable="false"
      :visible="visible"
      @close="onClose"
    >
      <template #extra>
        <a-button style="margin-right: 8px" @click="onClose">取消</a-button>
        <a-button type="primary" @click="onSubmit">提交</a-button>
      </template>
      <a-form :model="data.form" :rules="rules">
        <a-form-item name="no" label="学号：">
          <a-input v-model:value="data.form.no" placeholder="请输入学号"/>
        </a-form-item>
        <a-form-item name="name" label="姓名：">
          <a-input v-model:value="data.form.name" placeholder="请输入姓名"/>
        </a-form-item>
        <a-form-item name="sex" label="性别：">
          <a-radio-group v-model:value="data.form.sex" button-style="solid">
            <a-radio-button :value="SexEnum.MALE">{{
                SexEnum.properties[SexEnum.MALE].zh
              }}
            </a-radio-button>
            <a-radio-button :value="SexEnum.FEMALE">{{
                SexEnum.properties[SexEnum.FEMALE].zh
              }}
            </a-radio-button>
          </a-radio-group>
        </a-form-item>
        <a-form-item name="password" label="密码：">
          <a-input v-model:value="data.form.password" placeholder="请输入密码"/>
        </a-form-item>
        <a-form-item name="phone" label="手机：">
          <a-input v-model:value="data.form.phone" placeholder="请输入手机号码"/>
        </a-form-item>
        <a-form-item name="birth" label="出生日期：">
          <a-date-picker v-model:value="data.form.birth" value-format="YYYY-MM-DD"/>
        </a-form-item>
        <a-form-item name="college" label="学院">
          <a-input v-model:value="data.form.college" placeholder="请输入学院"/>
        </a-form-item>
        <a-form-item name="role" label="角色：">
          <a-select ref="select" v-model:value="data.form.role" style="width: 120px">
            <a-select-option :value="RoleEnum.ADMIN">
              {{ RoleEnum.properties[RoleEnum.ADMIN].zh }}
            </a-select-option>
            <a-select-option :value="RoleEnum.STUDENT">
              {{ RoleEnum.properties[RoleEnum.STUDENT].zh }}
            </a-select-option>
            <a-select-option :value="RoleEnum.TEACHER">
              {{ RoleEnum.properties[RoleEnum.TEACHER].zh }}
            </a-select-option>
          </a-select>
        </a-form-item>
        <a-form-item name="profession" v-if="data.form.role === RoleEnum.STUDENT" label="专业">
          <a-input v-model:value="data.form.profession" placeholder="请输入学生专业"/>
        </a-form-item>
        <a-form-item name="occupation" v-if="data.form.role === RoleEnum.TEACHER" label="职称">
          <a-input v-model:value="data.form.occupation" placeholder="请输入教师职称"/>
        </a-form-item>
      </a-form>
    </a-drawer>
    <a-spin :spinning="false">
      <a-card :bordered="false">
        <div class="table-page-wrapper">
          <div class="table-toolbar-left">
            {{ tableTitle }}
          </div>
          <div class="table-toolbar-right">
            <a-space>
              <a-button danger :disabled="showDel" @click="handleDeleteAll">删除全部</a-button>
              <ReloadOutlined @click="loadList({page: 1, size:10})"/>
            </a-space>
          </div>
        </div>
        <a-table
          :columns="columns"
          :data-source="data.list"
          :pagination="false"
          :row-selection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
        >
          <template #bodyCell="{ column, record }">
            <template v-if="column.key === 'role'">
              <a-tag :color="selectColor(record.roleId)">{{ record.role }}</a-tag>
            </template>
            <template v-if="column.key === 'sex'">
              {{ SexEnum.properties[record.sex].zh }}
            </template>
            <template v-if="column.key === 'action'">
              <span>
                <a @click="handleDelete(record)">删除</a>
                <a-divider type="vertical"/>
                <a @click="handleEdit(record)">编辑</a>
              </span>
            </template>
          </template>
        </a-table>
        <a-pagination
          :current="data.pagination.page"
          v-model:pageSize="data.pagination.size"
          :total="data.pageOption.total"
          class="table-page"
          @change="handleChange"
        ></a-pagination>
      </a-card>
    </a-spin>
    <a-modal
      :visible="editShow"
      title="修改用户"
      @ok="handleOk"
      @cancel="handleCancel"
    >
      <a-form :model="data.editForm" :rules="rules">
        <a-form-item name="name" label="姓名：">
          <a-input v-model:value="data.editForm.name" placeholder="请输入姓名"/>
        </a-form-item>
        <a-form-item name="sex" label="性别：">
          <a-radio-group v-model:value="data.editForm.sex" button-style="solid">
            <a-radio-button :value="SexEnum.MALE">{{
                SexEnum.properties[SexEnum.MALE].zh
              }}
            </a-radio-button>
            <a-radio-button :value="SexEnum.FEMALE">{{
                SexEnum.properties[SexEnum.FEMALE].zh
              }}
            </a-radio-button>
          </a-radio-group>
        </a-form-item>
        <a-form-item name="phone" label="手机：">
          <a-input v-model:value="data.editForm.phone" placeholder="请输入手机号码"/>
        </a-form-item>
        <a-form-item name="birth" label="出生日期：">
          <a-date-picker v-model:value="data.editForm.birth" value-format="YYYY-MM-DD"/>
        </a-form-item>
        <a-form-item name="role" label="角色：">
          <a-select ref="select" v-model:value="data.editForm.roleId" style="width: 120px">
            <a-select-option :value="RoleEnum.ADMIN">
              {{ RoleEnum.properties[RoleEnum.ADMIN].zh }}
            </a-select-option>
            <a-select-option :value="RoleEnum.STUDENT">
              {{ RoleEnum.properties[RoleEnum.STUDENT].zh }}
            </a-select-option>
            <a-select-option :value="RoleEnum.TEACHER">
              {{ RoleEnum.properties[RoleEnum.TEACHER].zh }}
            </a-select-option>
          </a-select>
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script>
import {
  defineComponent,
  ref,
  reactive,
  onMounted,
  toRefs,
} from 'vue';
import { PlusOutlined, ReloadOutlined } from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import { SexEnum, RoleEnum } from '@/type/enum';
import { add, userList, edit, deleteUser } from '@/api/user';
import { formData, formRules, columns, initData } from './data';

export default defineComponent({
  name: 'UserSetting',
  components: { PlusOutlined, ReloadOutlined },
  setup() {
    const visible = ref(false);
    const editShow = ref(false);
    const spinning = ref(false);
    const data = reactive({
      ...initData,
    });
    const rules = formRules;
    const onClose = () => {
      visible.value = false;
      data.form = formData;
    };
    const onSubmit = () => {
      add(data.form).then(() => {
        onClose();
        message.open({ type: 'success', content: '添加成功' });
        loadList();
      }).catch(() => {
        message.open({ type: 'warn', content: '添加失败' });
      });
    };
    const changeSpinning = () => {
      spinning.value = !spinning.value;
    };
    const loadList = (params) => {
      changeSpinning();
      userList(params).then((res) => {
        res.list = res.list.map(element => {
          return { ...element, key: element.id };
        });
        data.list = res.list;
        data.pageOption.total = res.total;
        data.pagination.page = res.pageNum;
        data.pagination.size = res.pageSize;
      }).finally(() => {
        changeSpinning();
      });
    };
    const handle = reactive({
      selectColor(id) {
        switch (id) {
          case RoleEnum.ADMIN: return 'red';
          case RoleEnum.TEACHER: return 'green';
          case RoleEnum.STUDENT: return 'blue';
          default: return 'blue';
        }
      },
      selectedRowKeys: [],
      handleEdit(row) {
        editShow.value = true;
        data.editForm = { ...row };
        console.log(data.editForm);
      },
      onSelectChange(selectedRowKeys) {
        handle.selectedRowKeys = selectedRowKeys;
      },
      handleChange(page, size) {
        loadList({ page, size });
      },
      handleDel(param) {
        deleteUser({ idList: param }).then(() => {
          message.success('添加成功');
          loadList();
        }).catch(() => {
          message.error('添加失败');
        });
      },
      showDrawer: () => {
        visible.value = true;
      },
    });
    const handleCancel = () => {
      editShow.value = false;
    };
    const handleOk = () => {
      edit().then(() => {
        message.success('修改成功');
        handleCancel();
        loadList();
      }).catch(() => {
        message.error('修改失败');
      });
    };
    onMounted(() => {
      loadList(data.pagination);
    });
    return {
      visible,
      onClose,
      onSubmit,
      data,
      rules,
      SexEnum,
      RoleEnum,
      columns,
      loadList,
      spinning,
      editShow,
      handleCancel,
      handleOk,
      ...toRefs(handle),
    };
  },
});
</script>

<style lang="less" scoped>
.user-table {
  margin-top: 10px;
}
.table-page {
  margin-top: 16px;
  justify-content: flex-end;
  display: flex;
  flex-wrap: wrap;
  row-gap: 8px;
}
.ant-card{
  &:deep(.ant-card-body){
    padding-top: 0;
  }
}

.table-page-wrapper{
  display: flex;
  justify-content: space-between;
  padding: 16px 0;
  .table-toolbar-left{
    display: flex;
    align-items: center;
    justify-content: flex-start;
    color: rgba(0,0,0,.85);
    font-weight: 500;
    font-size: 16px;
  }
  .table-toolbar-right{
    display: flex;
    justify-content: flex-end;
    align-items: center;
  }
}
</style>
