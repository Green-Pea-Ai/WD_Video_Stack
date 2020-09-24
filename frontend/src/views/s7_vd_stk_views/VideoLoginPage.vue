<template>
  <div class="mania_login" align="center">
    <h1>VS 로그인 페이지</h1><br>
    <video-login-form @submit="onSubmit"/>
  </div>
</template>

<script>
import VideoLoginForm from '@/components/s7_vd_stk_comp/VideoLoginForm.vue'
import { mapActions } from 'vuex'

export default {
  name: 'VideoLoginPage',
  components: {
    VideoLoginForm
  },
  methods: {
    onSubmit (payload) {
      console.log('VideoLoginPage onSubmit()')
      this.login(payload).then(res => {
        alert('Video Login Success')
        this.$router.push({ name: 'Home' })
      }).catch(err => {
        alert('Something Fail: ', err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>
