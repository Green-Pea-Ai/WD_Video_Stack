import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'

// Movie Mania Project
// 회원가입을 한다.
import VideoAdminSignUpPage from '../views/s7_vd_stk_views/VideoAdminSignUpPage.vue'
import VideoStackSignUp from '../views/s7_vd_stk_views/VideoStackSignUp.vue'

// 로그인, 로그아웃 한다.
import VideoLoginPage from '../views/s7_vd_stk_views/VideoLoginPage.vue'

import VideoStackMain from '../views/s7_vd_stk_views/VideoStackMain.vue'
// C: 게시판에 글을 등록할 수 있고,
import VideoRegisterPage from '../views/s7_vd_stk_views/VideoRegisterPage.vue'
// R: 글을 읽을 수 있고
import VideoReadPage from '../views/s7_vd_stk_views/VideoReadPage.vue'
// U: 글을 수정할 수 있고
// D: 글을 삭제할 수 있다.
import VideoModifyPage from '../views/s7_vd_stk_views/VideoModifyPage.vue'
// S: 글의 제목, 내용으로 검색할 수 있다.
// P: 페이지네이션
import VideoListPage from '../views/s7_vd_stk_views/VideoListPage.vue'

// 크롤링한 데이터들을 출력하는 페이지이다.
// S: 검색할 수 있다.
// P: 페이지네이션
import VideoFavoritePage from '../views/s7_vd_stk_views/VideoFavoritePage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    // VideoStack Project Main
    path: '/VideoStackMain',
    name: 'VideoStackMain',
    components: {
      default: VideoStackMain
    }
  },
  {
    path: '/VideoStackSignUp',
    name: 'VideoStackSignUp',
    components: {
      default: VideoStackSignUp
    }
  },
  {
    path: '/VideoLoginPage',
    name: 'VideoLoginPage',
    components: {
      default: VideoLoginPage
    }
  },
  // Admin Setup
  {
    path: '/VideoAdminSignUpPage',
    name: 'VideoAdminSignUpPage',
    components: {
      default: VideoAdminSignUpPage
    }
  },
  {
    path: '/video/create',
    name: 'VideoRegisterPage',
    components: {
      default: VideoRegisterPage
    }
  },
  {
    path: '/video/read/:videoNo',
    name: 'VideoReadPage',
    components: {
      default: VideoReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/video/update/:videoNo',
    name: 'VideoModifyPage',
    components: {
      default: VideoModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/video/list',
    name: 'VideoListPage',
    components: {
      default: VideoListPage
    }
  },
  {
    path: '/VideoFavoritePage',
    name: 'VideoFavoritePage',
    components: {
      default: VideoFavoritePage
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
