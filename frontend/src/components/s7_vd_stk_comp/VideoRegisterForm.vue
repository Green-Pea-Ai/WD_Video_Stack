<template>
  <form @submit.prevent="onSubmit">
    <h3>Video Register Form</h3>
    <br/>
    <table>
      <tr>
        <td>Movie Title</td>
        <td><input type="text" v-model="movTitle"></td>
      </tr>

      <tr>
        <td>Director</td>
        <td><input type="text" v-model="director"></td>
      </tr>

      <tr>
        <td>Content</td>
        <td><textarea v-model="content" rows="5"></textarea></td>
      </tr>
    </table>
    <br/>
    <v-app>
      <div>
          <v-btn
            type="submit"
            color="primary"
            elevation="2"
            raised
            rounded
          >Register</v-btn>
          <v-btn
            color="#ffffff"
            x-small
            elevation="0"
          ></v-btn>
          <v-btn
            v-bind:to="{ name: 'VideoListPage' }"
            color="secondary"
            elevation="2"
            raised
            rounded
          >Cancel</v-btn>
        <!-- <button type="submit">[Register]</button> -->
        <!-- <router-link :to="{ name: 'VideoListPage'}">[Cancel]</router-link> -->
      </div>
    </v-app>
  </form>
</template>

<script>
export default {
  name: 'VideoRegisterForm',
  data () {
    return {
      movTitle: '',
      director: '',
      content: ''
    }
  },
  methods: {
    onSubmit () {
      const { movTitle, director, content } = this
      this.$emit('submit', { movTitle, director, content })
    }
  }
}
</script>
