<template>
  <div align="center">
    <h1>VideoStack Main Page(Beta)</h1>
    <br>
    <router-link :to="{ name: 'VideoRegisterPage'}">
      새로운 영화정보 등록하기
    </router-link>
    <video-list-page-form :list-array="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import VideoListPageForm from '@/components/s7_vd_stk_comp/VideoListPageForm.vue'

export default {
  name: 'VideoStackMain',
  components: {
    VideoListPageForm
  },
  data () {
    return {
      pageArrya: []
    }
  },
  created () {
    // DB 가져오는 코드
    // 아직 사용되지 않은 코드?
    axios.get('http://localhost:7777/boards')
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
