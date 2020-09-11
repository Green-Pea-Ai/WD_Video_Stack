<template>
  <form @submit.prevent="onSubmit">
    <h3>Video Register Form</h3>
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

    <div>
      <button type="submit">[Register]</button>
      <router-link :to="{ name: 'VideoListPage'}">
        [Cancel]
      </router-link>
    </div>
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
