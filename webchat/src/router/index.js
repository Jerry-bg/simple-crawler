import Vue from 'vue'
import Router from 'vue-router'
import head from '@/components/head'
import home from '../pages/home'

Vue.use(Router)

export default new Router({
  routes: [{
      path: '',
      component:head
    },
    {
      path: '/home',
      component: home
    }
  ]
})
