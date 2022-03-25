/**
 * 加载所有插件
 * @param app
 */
export function loadPlugins (app) {
  const files = require.context('.', true, /\.js$/);
  files.keys().forEach(key => {
    if (typeof files(key).default === 'function') {
      if (key !== './index.js') files(key).default(app);
    }
  });
}
