<template>
  <div id="center">
    <h3>Video Detailed View(test)</h3>
    <table>
      <tr>
        <td>No</td>
        <td><input type="text" :value="video.videoNo" readonly></td>
      </tr>

      <tr>
        <td>등록 날짜</td>
        <td><input type="text" :value="video.regDate" readonly></td>
      </tr>

      <tr>
        <td>Movie Title</td>
        <td><input type="text" :value="video.mov_title" readonly></td>
      </tr>

      <tr>
        <td>Director</td>
        <td><input type="text" :value="video.director" readonly></td>
      </tr>

      <tr>
        <td>Content</td>
        <td><textarea :value="video.content" rows="5" readonly></textarea></td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'VideoReadForm',
  props: {
    video: {
      type: Object,
      required: true
    }
  }
}
</script>
