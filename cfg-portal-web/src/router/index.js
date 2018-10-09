import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'
import HomePage from '../views/HomePage'
import appPage from '../views/AppPage'
import appConfig from '../views/AppConfig/AppConfig'
import clusterPage from '../views/cluster/cluster'

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
        }
      ]
    },
    {
      path: '/appConfig',
      name: 'appConfig',
      component: appConfig
    }
  ]
})
