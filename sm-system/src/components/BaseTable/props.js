
export const tableProps = {
  columns: {
    type: Array,
    require: true,
    default: () => [],
  },
  data: {
    type: Array,
    require: true,
    default: () => [],
  },
  tableTitle: {
    type: String,
    default: '表格',
  },
  showEdit: {
    type: Boolean,
    default: true,
  },
  showDelete: {
    type: Boolean,
    default: true,
  },
  current: {
    type: Number,
    default: 1,
  },
  pageSize: {
    type: Number,
    default: 10,
  },

};
