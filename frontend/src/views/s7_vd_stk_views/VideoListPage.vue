<template>
  <div align="center" id="video">
    <h2>Video Board List</h2>
    <br>
    <router-link :to="{ name: 'VideoRegisterPage' }">
      [새로운 영화 정보 등록하기]
    </router-link>
    <video-list-form :list-array="pageArray"/>
    <video-search-form/>
    <main-style-sheet/>
  </div>
</template>

<script>
import axios from 'axios'
import VideoListForm from '@/components/s7_vd_stk_comp/VideoListForm.vue'
import VideoSearchForm from '@/components/s7_vd_stk_comp/VideoSearchForm.vue'
import MainStyleSheet from '@/components/s7_vd_stk_comp/MainStyleSheet.vue'

export default {
  name: 'VideoListPage',
  components: {
    VideoListForm,
    VideoSearchForm,
    MainStyleSheet
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    // DB 가져오는 코드
    // 아직 사용되지 않은 코드
    axios.get('http://localhost:7777/videos')
      .then(res => {
        console.log(res)
        this.pageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>
