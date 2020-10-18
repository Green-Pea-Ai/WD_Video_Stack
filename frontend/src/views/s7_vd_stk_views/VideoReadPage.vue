<template>
  <div id="center">

    <h2>Detailed Video Board List(Read)</h2>
    <video-read-form v-if="video" :video="video" align="center"/>
    <p v-else>Loading...</p>
    <v-app>
      <div>
        <v-btn
          v-bind:to="{ name: 'VideoModifyPage', params: { videoNo } }"
          color="primary"
          rounded
        >Modify</v-btn>
        <v-btn
          color="#ffffff"
          x-small
          elevation="0"
        ></v-btn>
        <v-btn @click="onVideoDelete"
          color="#FF7070"
          rounded
        >Delete</v-btn>
        <br/><br/>
        <v-btn v-bind:to="{ name: 'VideoListPage' }"
          color="normal"
          rounded
        >List</v-btn>
        <!--
          <router-link :to="{ name: 'VideoModifyPage', params: { videoNo } }">
            [Modify]
          </router-link>
          <button @click="onVideoDelete">[Delete]</button>
          <router-link :to="{ name: 'VideoListPage'}">
            [List]
          </router-link>
        -->
        </div>
    </v-app>

  </div>
</template>

<script>
import VideoReadForm from '@/components/s7_vd_stk_comp/VideoReadForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'VideoReadPage',
  props: {
    videoNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState([
      'video'
    ])
  },
  created () {
    console.log('VideoReadPage created(): ' + this.videoNo)
    this.fetchVideo(this.videoNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.push()
      })
  },
  methods: {
    ...mapActions([
      'fetchVideo'
    ]),
    onVideoDelete () {
      const { videoNo } = this.video
      axios.delete(`http://localhost:7777/videos/${videoNo}`)
        .then(res => {
          alert('Video Delete Success!')
          this.$router.push({ name: 'VideoListPage' })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  },
  components: {
    VideoReadForm
  }
}
</script>
