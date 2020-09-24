<template>
  <form @submit.prevent="submit">
    <table>
      <tr>
        <td>Admin 아이디</td>
        <td><input type="text" v-model="userId"></td>
      </tr>

      <tr>
        <td>암호</td>
        <td><input type="password" v-model="userPw"></td>
      </tr>

      <tr>
        <td>Admin 이름</td>
        <td><input type="text" v-model="userName"></td>
      </tr>
    </table>

    <div>
      <button type="submit">[등록]</button>
    </div>
  </form>
</template>

<script>
export default {
  name: 'VideoAdminSignUpForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId +
                  ', ' + this.userName +
                  ', ' + this.userPw)
      const { userId, userName, userPw } = this
      this.$emit('submit', { userId, userName, userPw })
    }
  }
}
</script>
