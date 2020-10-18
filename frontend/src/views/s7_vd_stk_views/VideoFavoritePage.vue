<template>
  <v-app>
  <div align="center">
    <h2>Video Favorite Crawl List</h2>
      <table>
        <tr>
          <!--
            v-model movTitle을 그대로 써서 웹에서 값을 못받아오고
            undefined 오류 계속 났었음, 시간버림..
            복붙은 대체로 피하고 있지만 만약 한다면 항상 주의해서 하자.
          -->
          <td><input type="text" v-model="youtubeTitle" placeholder="유튜브 제목 입력"></td>
          <!-- <td><button @click="onCrawlSearch" class="crawl-btn">[크롤링 데이터 검색]</button></td> -->
          <td>
            <v-btn @click="onCrawlSearch"
              color="primary"
            >크롤링 데이터 검색</v-btn>
          </td>
        </tr>
      </table>
      <br>
      <!-- <router-link :to="{ name: 'VideoListPage'}">[게시판 페이지 이동]</router-link> -->
      <!-- <button onclick="window.location.reload()">[새로고침]</button> -->
      <v-btn color="warning" v-bind:to="{ name: 'VideoListPage' }">게시판 페이지 이동</v-btn>
      <v-btn icon color="green" onclick="window.location.reload()">
        <v-icon>mdi-cached</v-icon>
      </v-btn>
      <video-favorite-form v-bind:crawl-list-array="crawlPageArray"/>
  </div>
  </v-app>
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
    onCrawlSearch () {
      const youtubeTitle = this.youtubeTitle
      console.log('wd power: ' + youtubeTitle, this.youtubeTitle)
      axios.get(`http://localhost:7777/videos/search/crawl/${youtubeTitle}`)
        .then(res => {
          alert('Crawl Search Success!')
          console.log('res', res)
          this.crawlPageArray = res.data
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>

<style>
.crawl-btn {
  width: 150px;
}
</style>
