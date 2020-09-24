<template>
  <form @submit.prevent="submit">
    <table>
      <tr>
        <td>ID</td>
        <td><input type="text" v-model="userid"></td>
      </tr>

      <tr>
        <td>Password</td>
        <td><input type="password" v-model="password"></td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <button type="submit">[로그인]</button>

          <!--
          <button id="login" @click="$router.push('VideoStackMain')">
            [로그인]
          </button>
          <button id="login" @click="$router.push('VideoStackSignUp')">
            [회원가입]
          </button>
          <v-spacer>     ------------      </v-spacer>
          -->
        </td>
      </tr>
    </table>
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
