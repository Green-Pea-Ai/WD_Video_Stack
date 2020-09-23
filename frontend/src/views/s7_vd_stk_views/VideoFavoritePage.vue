<template>
  <div>
    <h2>Video Favorite Crawl List</h2>
      <table>
        <tr>
          <td>ㄱㄴㄷㄹ</td>
          <td>ㅁㄴㅇㄹ</td>
        </tr>
      </table>
      <br>
      <router-link :to="{ name: 'VideoListPage'}">
        [게시판 리스트로 돌아가기]
      </router-link>
      <video-favorite-form v-bind:crawl-list-array="crawlPageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import VideoFavoriteForm from '@/components/s7_vd_stk_comp/VideoFavoriteForm.vue'

export default {
  name: 'VideoFavoritePage',

  components: {
    VideoFavoriteForm
  },
  data () {
    return {
      crawlPageArray: []
    }
  },
  created () {
    // DB 가져오기
    axios.get('http://localhost:7777/videos/crawl')
      .then(res => {
        console.log(res)
        this.crawlPageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
  },
  methods: {
  }
}
</script>

<style>
.favorite_page {
  max-width: auto;
  max-height: auto;
  margin: auto;
  background-color: #FFDADA;
}
</style>
