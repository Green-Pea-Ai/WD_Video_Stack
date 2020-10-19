import {
  // mutation: Vuex의 데이터, 즉 state 값을 변경하는 로직들을 의미
  FETCH_VIDEO_LIST,
  FETCH_VIDEO,
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO
} from './mutation-types'

import axios from 'axios'
// vuex 개체라 정보를 공유 안해서 import 해줘야 함
import cookies from 'vue-cookies'

export default {
  [FETCH_VIDEO_LIST] (state, videos) {
    state.videos = videos
  },
  [FETCH_VIDEO] (state, video) {
    state.video = video
  },
  [SET_ACCESS_TOKEN] (state, accessToken) {
    if (accessToken) {
      state.accessToken = accessToken

      axios.defaults.headers.common.Authorization = `Bearer ${accessToken}`
      console.log('axios Auth: ' + axios.defaults.headers.common.Authorization)

      cookies.set('accessToken', accessToken, '1h')
    }
  },
  [SET_MY_INFO] (state, myinfo) {
    if (myinfo) {
      state.myinfo = myinfo
    }
  },
  [DESTROY_ACCESS_TOKEN] (state) {
    state.accessToken = ''
    delete axios.defaults.headers.common.Authorization
    cookies.remove('accessToken')
  },
  [DESTROY_MY_INFO] (state) {
    state.myinfo = null
  }
}
