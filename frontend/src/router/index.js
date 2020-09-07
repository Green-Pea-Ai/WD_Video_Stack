import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Test from '../views/Test.vue'
import Todo from '../views/Todo.vue'
import FiveEyeGame from '../views/FiveEyeGame.vue'
// Concave -> 식별이 어려워 FiveEyeGame으로 이름바꿈

// For Cafe Board
import BoardListPage from '../views/s3_board_view/BoardListPage.vue'
import BoardRegisterPage from '../views/s3_board_view/BoardRegisterPage.vue'
import BoardModifyPage from '../views/s3_board_view/BoardModifyPage.vue'
import BoardReadPage from '../views/s3_board_view/BoardReadPage.vue'

// For Login System
import LoginPage from '../views/s4_jwt_view/LoginPage.vue'
import AdminSetupPage from '../views/s4_jwt_view/AdminSetupPage.vue'

// Vuetify
import VuetifyBoard from '../views/s5_pagination_view/VuetifyBoard.vue'

// Vuetify Board List
import VuetifyBoardListPage from '../views/s5_pagination_view/VuetifyBoardListPage.vue'

// For Crawling
import CrawlCategory from '../views/s6_crawling_view/CrawlCategory.vue'

// Movie Mania Project
import VideoStackMain from '../views/vd_stk_views/VideoStackMain.vue'
import VideoStackLogin from '../views/vd_stk_views/VideoStackLogin.vue'
import VideoStackSignUp from '../views/vd_stk_views/VideoStackSignUp.vue'
import VideoStackUpload from '../views/vd_stk_views/VideoStackUpload.vue'
import VideoStackAutoUpload from '../views/vd_stk_views/VideoStackAutoUpload.vue'
import VideoStack from '../views/vd_stk_views/VideoStack.vue'
import VideoStackDetail from '../views/vd_stk_views/VideoStackDetail.vue'
import VideoStackFavorite from '../views/vd_stk_views/VideoStackFavorite.vue'

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
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/todo',
    name: 'Todo',
    component: Todo
  },
  {
    path: '/FiveEyeGame',
    name: 'FiveEyeGame',
    components: {
      default: FiveEyeGame
    }
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    // boardNo에 :를 넣으면 가변 페이지가 됨
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      // boolean 모드가 됨, 이 옵션을 설정하면 route.params가 컴포넌트의 props에 자동 설정됨
      default: true
    }
  },
  {
    path: '/LoginPage',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/AdminSetupPage',
    name: 'AdminSetupPage',
    components: {
      default: AdminSetupPage
    }
  },
  {
    path: '/VuetifyBoard',
    name: 'VuetifyBoard',
    components: {
      default: VuetifyBoard
    }
  },
  {
    path: '/VuetifyBoardListPage',
    name: 'VuetifyBoardListPage',
    components: {
      default: VuetifyBoardListPage
    }
  },
  {
    path: '/CrawlCategory',
    name: 'CrawlCategory',
    components: {
      default: CrawlCategory
    }
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
    path: '/VideoStackLogin',
    name: 'VideoStackLogin',
    components: {
      default: VideoStackLogin
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
    path: '/VideoStackUpload',
    name: 'VideoStackUpload',
    components: {
      default: VideoStackUpload
    }
  },
  {
    path: '/VideoStackAutoUpload',
    name: 'VideoStackAutoUpload',
    components: {
      default: VideoStackAutoUpload
    }
  },
  {
    path: '/VideoStack',
    name: 'VideoStack',
    components: {
      default: VideoStack
    }
  },
  {
    path: '/VideoStackDetail',
    name: 'VideoStackDetail',
    components: {
      default: VideoStackDetail
    }
  },
  {
    path: '/VideoStackFavorite',
    name: 'VideoStackFavorite',
    components: {
      default: VideoStackFavorite
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
