<template>
  <div align="center">
    <h2>관리자 등록 페이지(VS admin)</h2>
    <video-admin-sign-up-form @submit="onSubmit"/>
  </div>
</template>

<script>
import axios from 'axios'
import VideoAdminSignUpForm from '@/components/s7_vd_stk_comp/VideoAdminSignUpForm.vue'

export default {
  name: 'VideoAdminSignUpPage',
  components: {
    VideoAdminSignUpForm
  },
  methods: {
    onSubmit (payload) {
      // jpa에서 생성한 데이터
      console.log('payload: ' + payload.userId +
                  ', ' + payload.userName +
                  ', ' + payload.userPw)
      const { userId, userName, userPw } = payload
      axios.post('http://localhost:7777/users/setup',
        { userId, userName, userPw })
        .then(res => {
          alert('Register Success')
          this.$router.push({
            name: 'Home'
          })
        })
        .catch(err => {
          alert(err.response.data)
        })
    }
  }
}
</script>
