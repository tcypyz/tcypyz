const path = require('path');
const resolve = (dir) => path.join(__dirname, dir);

module.exports = {
  transpileDependencies: true, 
  chainWebpack: config => {
    config.resolve.symlinks(true);
  
    config.resolve.alias // 添加别名
      .set('@', resolve('src'));
  },
  devServer: {
    port: 3250, // 启动端口
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:8080', // 接口域名
        changeOrigin: true, // 是否跨域
        secure: false,
        pathRewrite: {
          '^/api': '', // rewrite重写,
        },
      },
    },
  },
};

