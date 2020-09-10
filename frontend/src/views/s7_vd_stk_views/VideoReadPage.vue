<template>
  <div id="center">

    <h2>Detailed Video List(Read)</h2>
    <video-read v-if="video" :video="video"/>
    <p v-else>Loading...</p>
    <router-link :to="{ name: 'VideoModifyPage', params: { videoNo } }">
      [Modify]
    </router-link>

    <button @click="onVideoDelete">Delete</button>
    <router-link :to="{ name: 'VideoListPage'}">
      [List]
    </router-link>

  </div>
</template>

<script>
import VideoRead from '@/components/s7_vd_stk_comp/VideoRead'
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
  }
}
</script>
