<template>
  <div class="mania_sign_up" align="center">
    <h1>영상 업로드 상세 페이지</h1>
    <br>
    <h4>영상 제목과 세부옵션 설정 후 업로드 할 수 있습니다.</h4>
    <br>

    <form @submit.prevent="submit">
      <table>
        <tr>
          <td>영상 제목</td>
          <td><input type="text" v-model="userid"></td>
        </tr>

        <tr>
          <td>영상(썸네일 이미지 표시)</td>
          <td><input type="password" v-model="password"></td>
        </tr>

        <tr>
          <td>설명이나 메모</td>
          <td><input type="password" v-model="password"></td>
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
