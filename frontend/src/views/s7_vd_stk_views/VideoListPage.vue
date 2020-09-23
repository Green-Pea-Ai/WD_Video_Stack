<template>
  <div class="list_page" align="center" id="video">
    <h2>Video Board List</h2>
    <table>
      <tr>
        <td><input type="text" v-model="movTitle" placeholder="영화명 입력"></td>
        <td><button @click="onVideoSearch">[검색하기]</button></td>
      </tr>
    </table>
    <br>
    <router-link :to="{ name: 'VideoRegisterPage' }">
      [새로운 영화 정보 등록하기]
    </router-link>
    <br><br>
    <router-link :to="{ name: 'VideoFavoritePage' }">
      [관심 영상 정보 보러가기]
    </router-link>
    <video-list-form :list-array="pageArray"/>
    <main-style-sheet/>
  </div>
</template>

<script>
import axios from 'axios'
import { mapState, mapActions } from 'vuex'
import VideoListForm from '@/components/s7_vd_stk_comp/VideoListForm.vue'
// import VideoSearchForm from '@/components/s7_vd_stk_comp/VideoSearchForm.vue'
import MainStyleSheet from '@/components/s7_vd_stk_comp/MainStyleSheet.vue'

export default {
  name: 'VideoListPage',
  components: {
    VideoListForm,
    // VideoSearchForm,
    MainStyleSheet
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    // DB 가져오는 코드
    axios.get('http://localhost:7777/videos')
      .then(res => {
        console.log(res)
        this.pageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
  },
  computed: {
    ...mapState([
    ])
  },
  methods: {
    ...mapActions([
    ]),
    onVideoSearch () {
      const movTitle = this.movTitle
      console.log(movTitle, this.movTitle)
      axios.get(`http://localhost:7777/videos/search/${movTitle}`)
        .then(res => {
          alert('Video Search Success!')
          console.log('res', res)
          this.pageArray = res.data
          // this.$router.push({ name: 'VideoListPage' })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>

<style>
.list_page {
  max-width: auto;
  max-height: auto;
  margin: auto;
  background-color: ;
}
</style>
