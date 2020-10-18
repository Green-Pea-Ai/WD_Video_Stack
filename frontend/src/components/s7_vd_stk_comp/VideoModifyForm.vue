<template>
  <div>
    <br/>
    <h3>Video Board Modify</h3>
    <br/>
      <form @submit.prevent="onSubmit">
        <table>
          <tr>
            <td>No</td>
            <td><input type="text" :value="video.videoNo" disabled></td>
          </tr>

          <tr>
            <td>등록일자</td>
            <td><input type="text" :value="video.regDate" disabled></td>
          </tr>

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
              rounded
            >Modify</v-btn>
            <v-btn
              color="#ffffff"
              x-small
              elevation="0"
            ></v-btn>
            <v-btn
              v-bind:to="{ name: 'VideoReadPage',
                params: { videoNo: video.videoNo.toString() } }"
              rounded
            >Cancel</v-btn>
            <!--
              <button type="submit">[Modify]</button>
              <router-link :to="{ name: 'VideoReadPage',
                params: { videoNo: video.videoNo.toString() } }">
                [Cancel]
              </router-link>
            -->
          </div>
        </v-app>
      </form>
  </div>
</template>

<script>
export default {
  name: 'VideoModifyForm',
  props: {
    video: {
      type: Object,
      required: true
    }
  },
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
  },
  created () {
    this.movTitle = this.video.movTitle
    this.director = this.video.director
    this.content = this.video.content
  }
}
</script>
