<template>
  <form @submit.prevent="submit">
    <div>
      <table>
        <tr>
          <td>ID</td>
          <td><input type="text" v-model="userid"></td>
        </tr>

        <tr>
          <td>Password</td>
          <td><input type="password" v-model="password"></td>
        </tr>
      </table>
    </div>
    <br/>
    <v-app>
      <div>
        <table>
            <tr>
              <!-- <button type="submit">[로그인]</button> -->
              <v-btn type="submit"
                color="primary"
              >로그인</v-btn>
              <v-btn color="#ffffff" x-small elevation="0"></v-btn>
              <v-btn @click="$router.push('VideoAdminSignUpPage')"
                color=""
              >회원가입</v-btn>
              <!--
                <button id="login" @click="$router.push('VideoStackMain')">
                  [로그인]
                </button>
                <button id="login" @click="$router.push('VideoStackSignUp')">
                  [회원가입]
                </button>
              -->
            </tr>
        </table>
      </div>
    </v-app>
  </form>
</template>

<script>
export default {
  name: 'VideoLoginForm',
  data () {
    return {
      userid: '',
      password: ''
    }
  },
  methods: {
    submit () {
      console.log('VideoLoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    }
  }
}
</script>
