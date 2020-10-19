import {
  /* Board Exam, JWT 관련 */
  SET_ACCESS_TOKEN,
  SET_MY_INFO,

  /* eslint-disable no-unused-vars */
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,

  /* WD Video Stack */
  FETCH_VIDEO_LIST,
  FETCH_VIDEO
} from './mutation-types'

import axios from 'axios'
import router from '../router'

export default {

  fetchVideoList ({ commit }) {
    return axios.get('http://localhost:7777/videos')
      .then(res => {
        commit(FETCH_VIDEO_LIST, res.data)
      })
  },
  fetchVideo ({ commit }, videoNo) {
    console.log('fetchVideo ' + commit + ', videoNo = ' + videoNo)
    return axios.get(`http://localhost:7777/videos/${videoNo}`)
      .then(res => {
        console.log('fetchVideo - res: ' + res.data)
        commit(FETCH_VIDEO, res.data)
      })
  },
  login ({ commit }, payload) {
    console.log('actions login')
    return axios.post(`http://localhost:7777/api/authenticate?username=${payload.userid}&password=${payload.password}`, {
      username: payload.userid,
      password: payload.password
    }).then(res => {
      console.log('actions after post')
      const { authorization } = res.headers
      const accessToken = authorization.substring(7)

      commit(SET_ACCESS_TOKEN, accessToken)

      return axios.get('http://localhost:7777/video_users/myinfo')
    }).then(res => {
      console.log('After Get Auth Info')
      commit(SET_MY_INFO, res.data)
    })
  },
  loginByToken ({ commit }, token) {
    commit(SET_ACCESS_TOKEN, token)
    return axios.get('http://localhost:7777/video_users/myinfo')
      .then(res => {
        commit(SET_MY_INFO, res.data)
      })
  },
  logout ({ commit }) {
    commit(DESTROY_MY_INFO)
    commit(DESTROY_ACCESS_TOKEN)
  }
}
