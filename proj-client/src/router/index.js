import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/views/Main'
import Home from '@/views/Home'
import Signup from '@/views/Signup'
import Login from '@/views/Login'
import Comments from '@/views/Comments'
import Courses from '@/views/Courses'
import Profs from '@/views/Profs'
import MakeComments from '@/views/MakeComments.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main,
      children: [
        {
          path: '',
          component: Home
        },
        {
          path: '/Home',
          component: Home
        },
        {
          path: '/Courses',
          component: Courses
        },
        {
          path: '/Comments',
          component: Comments
        },
        {
          path: '/Profs',
          component: Profs
        },
        {
          path: '/Makecomments',
          component: MakeComments
        },
        {
          path: '/Signup',
          component: Signup
        },
        {
          path: '/Login',
          component: Login
        }
      ]
    }
  ]
})
