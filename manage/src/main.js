import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
axios.defaults.baseURL = '/api' //关键代码
import '@/assets/css/global.css'
import locale from 'element-ui/lib/locale/lang/zh-CN'
import axios from "axios"; // 引入中文语言包
import 'element-ui/lib/theme-chalk/icon.css';

Vue.config.productionTip = false

// 使用 ElementUI 并设置默认语言为中文
Vue.use(ElementUI, {
  locale,
  size: 'small' // 设置默认大小为 small
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
