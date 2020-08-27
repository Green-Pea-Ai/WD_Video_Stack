<template>
  <div class="mania_sign_up" align="center">
    <h1>영상 업로드 페이지</h1>
    <br>
    <h4>영상 제목과 세부옵션 설정 후 업로드 할 수 있습니다.</h4>
    <br>

    <form @submit.prevent="submit">
      <table>
        <tr>
          <td>영상 제목</td>
          <td><input type="text" v-model="vid_title"></td>
        </tr>

        <tr>
          <td>영상(썸네일 이미지 표시)</td>
          <td><input type="video" v-model="vid_video"></td>
        </tr>

        <tr>
          <td>영상설명 또는 메모</td>
          <td><input type="text" v-model="vid_comment"></td>
        </tr>

        <tr>
          <td>카테고리(분류 용도, 사용자에게 보이지 않음)</td>
          <td><input type="text" v-model="vid_category"></td>
        </tr>

        <tr>
          <!-- 영상 다이렉트 업로드, 제목은 영상이름, 내용은 업로드 날짜시간이 자동으로 들어감 -->
          <td colspan="2" align="center">
            <button type="submit">영상 업로드</button>
          </td>
        </tr>
      </table>
    </form>
  </div>
</template>
