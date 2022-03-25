module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: [
    'plugin:vue/vue3-essential',
    '@vue/standard',
  ],
  parserOptions: {
    parser: '@babel/eslint-parser',
  },
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
    quotes: ['error', 'single'], // 使用单引号
    'comma-dangle': [2, 'always-multiline'],
    semi: [2, 'always'],
    'semi-spacing': [0, { before: false, after: true }],
    'space-before-function-paren': [0, 'always'],
    'no-multiple-empty-lines': 0,
  },
};
