<template>
  <div class="list_page" align="center" id="video">
    <h2>Video Board List</h2>
    <table>
      <tr>
        <td><input type="text" v-model="movTitle" placeholder="영화명 입력"></td>
        <td><button @click="onVideoSearch">[검색]</button></td>
      </tr>
    </table>
    <br>
    <!-- <router-link :to="{ name: 'VideoRegisterPage' }">[영화 정보 등록]</router-link> -->
    <!-- <router-link :to="{ name: 'VideoFavoritePage' }">[관심사 영상 페이지 이동]</router-link> -->

    <!-- <button onclick="window.location.reload()">[새로고침]</button> -->
      <v-app>
        <v-col cols="5" sm="12">
          <div class="vue-listpage">

            <!--
            <v-text-field
              label="영화명 입력"
              outlined
            ></v-text-field>
            <v-btn color="primary" v-model="movTitle" v-on:click="onVideoSearch">검색</v-btn>
            <br><br>
            -->
            <v-btn color="primary" v-bind:to="{ name: 'VideoRegisterPage' }">영화 정보 등록</v-btn>
            <br><br>
            <v-btn color="warning" v-bind:to="{ name: 'VideoFavoritePage' }">관심사 영상 페이지 이동</v-btn>
            <v-btn icon color="green" onclick="window.location.reload()">
              <v-icon>mdi-cached</v-icon>
            </v-btn>
            <video-list-form :list-array="pageArray"/>
            <main-style-sheet/>
          </div>
        </v-col>
      </v-app>

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
  * { margin: 0; padding: 0;}
</style>
