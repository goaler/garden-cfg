// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import ElementUI from 'element-ui'
Vue.use(ElementUI)

import 'vue2-animate/dist/vue2-animate.min.css'
import 'element-ui/lib/theme-chalk/index.css'

import axios from './utils/request'
Vue.prototype.axios = axios

import util from './utils/util'
Vue.prototype.util = util

Vue.filter('formatDateStr', function (dateStr) {
  return util.formatDateStr(dateStr)
})

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
