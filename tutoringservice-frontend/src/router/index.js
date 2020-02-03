import Vue from 'vue'
import Router from 'vue-router'
import SignUp from '@/components/SignUp.vue'
import Login from '@/components/Login.vue'
import TutorInfoPage from '@/components/TutorInfoPage.vue'
import ProfilePage from '@/components/ProfilePage.vue'
import Homepage from '@/components/Homepage.vue'
import HomepageTutor from '@/components/HomepageTutor.vue'
import HomepageCourse from '@/components/HomepageCourse.vue'

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/homepage",
      name: "homepage",
      component: Homepage
    },
    {
      path: "/homepagetutor",
      name: "homepagetutor",
      component: HomepageTutor
    },
    {
      path: "/homepagecourse",
      name: "homepagecourse",
      component: HomepageCourse
    },
    {
      path: '/SignUp',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/tutor_info',
      name: 'TutorInfoPage',
      component: TutorInfoPage
    },
    {
      path: '/ProfilePage',
      name: 'ProfilePage',
      component: ProfilePage
    }
  ]
});
