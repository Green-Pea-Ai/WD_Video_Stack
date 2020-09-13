<template>
  <div align="center">
    <h2>Video Board Register</h2>
    <br>
    <video-register-form @submit="onSubmit"/>
  </div>
</template>

<script>
import VideoRegisterForm from '@/components/s7_vd_stk_comp/VideoRegisterForm'
import axios from 'axios'

export default {
  name: 'VideoRegisterPage',
  components: {
    VideoRegisterForm
  },
  methods: {
    onSubmit (payload) {
      console.log('VideoRegisterPage onSubmit()!!!')
      const { movTitle, director, content } = payload
      axios.post('http://localhost:7777/videos', { movTitle, director, content })
        .then(res => {
          console.log(res)
          alert('VS Register Success!')
          this.$router.push({
            name: 'VideoReadPage',
            params: { videoNo: res.data.videoNo.toString() }
          })
        })
        .catch(err => {
          alert(err.response.data.message)
        })
    }
  }
}
</script>
