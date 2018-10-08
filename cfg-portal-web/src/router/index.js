import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import HomePage from '../components/HomePage'
import appConfig from '../components/AppConfig/AppConfig'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/appConfig',
      name: 'appConfig',
      component: appConfig
    }
  ]
})
