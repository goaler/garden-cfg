import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'
import HomePage from '../views/HomePage'
import appPage from '../views/app/App'
import appConfig from '../views/AppConfig/AppConfig'
import clusterPage from '../views/cluster/Cluster'
import envPage from '../views/env/Env'
import createAppPage from '../views/app/CreateApp'

Vue.use(Router)

export default new Router({
  routes: [{
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/',
      name: 'HomePage',
      component: HomePage,
      children: [
        {
          path: '',
          name: 'appPage',
          component: appPage
        },
        {
          path: '/appPage',
          name: 'appPage',
          component: appPage
        },
        {
          path: '/clusterPage',
          name: 'clusterPage',
          component: clusterPage
        },
        {
          path: '/envPage',
          name: 'envPage',
          component: envPage
        }
      ]
    },
    {
      path: '/appConfig',
      name: 'appConfig',
      component: appConfig
    },
    {
      path: '/createApp',
      name: 'createApp',
      component: createAppPage
    }
  ]
})
