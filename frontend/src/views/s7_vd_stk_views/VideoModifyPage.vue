<template>
  <div id="center">
    <h2>Video Board Modification(Update)</h2>
    <video-modify-form v-if="video" :video="video" @submit="onSubmit" align="center"/>
    <p v-else>Loading ...</p>
  </div>
</template>

<script>
import VideoModifyForm from '@/components/s7_vd_stk_comp/VideoModifyForm'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
  name: 'VideoModifyPage',
  components: {
    VideoModifyForm
  },
  props: {
    videoNo: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['video'])
  },
  created () {
    console.log('============VideoModifyPage created()============')
    this.fetchVideo(this.videoNo)
      .catch(err => {
        alert(err.response.data.message)
        this.$router.back()
      })
  },
  methods: {
    onSubmit (payload) {
      const { movTitle, director, content } = payload
      console.log('============VideoModifyPage payload: ' + payload)
      axios.put(`http://localhost:7777/videos/${this.videoNo}`, { movTitle, director, content })
        .then(res => {
          alert('Modify Success')
          console.log('res: ' + res.data)
          this.$router.push({
            name: 'VideoReadPage',
            params: { videoNo: res.data.videoNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    },
    ...mapActions([
      'fetchVideo'
    ])
  }
}
</script>
