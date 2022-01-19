import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Login from '@/views/Login.vue'
import AdminHome from '@/views/AdminHome.vue'
import HomePage from '@/pages/HomePage.vue'
import UserPage from '@/pages/UserPage.vue'
import CoursePage from '@/pages/CoursePage.vue'
import ProfPage from '@/pages/ProfPage.vue'
import CourseEvalPage from '@/pages/CourseEvalPage.vue'
import ProfEvalPage from '@/pages/ProfEvalPage.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/Home',
      name: 'AdminHome',
      component: AdminHome,
      children: [
        {
          path: '/Homepage',
          component: HomePage
        },
        {
          path: '/Users',
          component: UserPage
        },
        {
          path: '/Courses',
          component: CoursePage
        },
        {
          path: '/Profs',
          component: ProfPage
        },
        {
          path: '/Course-eval',
          component: CourseEvalPage
        },
        {
          path: '/Prof-eval',
          component: ProfEvalPage
        }
      ]
    }
  ]
})
