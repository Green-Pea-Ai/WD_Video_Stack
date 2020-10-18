<template>
  <form @submit.prevent="submit">
    <br/>
    <table>
      <tr>
        <td>Admin ID</td>
        <td><input type="text" v-model="userId"></td>
      </tr>

      <tr>
        <td>Password</td>
        <td><input type="password" v-model="userPw"></td>
      </tr>

      <tr>
        <td>Admin Name </td>
        <td><input type="text" v-model="userName"></td>
      </tr>
    </table>
    <br/>
    <v-app>
    <div>
      <v-btn type="submit"
        color="primary"
      >등록</v-btn>
      <!-- <button type="submit">[등록]</button> -->
    </div>
    </v-app>
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
