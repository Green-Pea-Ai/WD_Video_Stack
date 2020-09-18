<template>
  <div>
    <h3>Video Board 항목 수정하기</h3>

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

        <div>
          <button type="submit">[수정하기]</button>
          <router-link :to="{ name: 'VideoReadPage',
            params: { videoNo: video.videoNo.toString() } }">
            [취소]
          </router-link>
        </div>
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
