<template>
  <div class="mania_login" align="center">
    <!-- 제각각의 이름이었던 영상들의 이름을 카테고리 기준으로 일괄적으로 바꿀 수 있다 -->
    <!-- 정리된 이름으로 영상을 다시 다운로드 받을 수 있다 -->

    <h1>내 영상 보기</h1> <br>
    <h3>영상들이 쌓이는 페이지</h3> <br>
    <form @submit.prevent="submit">
      <table>
        <tr>
          <td>
            <button id="animal_btn" @click="$router.push('VideoStackDetail')" >
              강아지
            </button>
          </td>
          <td><a href="https://www.youtube.com/user/PlayMnet/featured">샘플</a></td>
        </tr>

        <tr>
          <td>고양이</td>
          <td><input type="text" v-model="정의필요"></td>
        </tr>

        <tr>
          <td>Unknown(미분류)</td>
          <td><input type="text" v-model="정의필요"></td>
        </tr>

      </table>
    </form>

  </div>
</template>
