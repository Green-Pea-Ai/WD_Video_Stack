<template>
  <div>
    <h3>Video Detailed View(test)</h3>
    <table>
      <!--
        videoNo, regDate 등의 데이터들은 axios를 이용하여
        (actions의 fetchVideo 함수)
        자바 Repository에서 값을 가져오는 것이다.
        res.data에는 video의 Entity 값들이 담겨있다.

        video.videoNo의 video는 states에 있는 video이다.
       -->
      <tr>
        <td>No</td>
        <td><input type="text" :value="video.videoNo" readonly></td>
      </tr>

      <tr>
        <td>등록일자</td>
        <td><input type="text" :value="video.regDate" readonly></td>
      </tr>

      <tr>
        <td>Movie Title</td>
        <td><input type="text" :value="video.movTitle" readonly></td>
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
