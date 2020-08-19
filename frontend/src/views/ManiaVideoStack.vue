<template>
  <div class="mania_login" align="center">
    <!-- 제각각의 이름이었던 영상들의 이름을 카테고리 기준으로 일괄적으로 바꿀 수 있다 -->
    <!-- 정리된 이름으로 영상을 다시 다운로드 받을 수 있다 -->

    <h1>내 영상 관리</h1> <br>
    <h3>현재는 3개의 카테고리만 지원합니다.</h3> <br>
    <form @submit.prevent="submit">
      <table>
        <tr>
          <td>Animal(개, 고양이)</td>
          <td><input type="text" v-model="userid"></td>
        </tr>

        <tr>
          <td>Machine(자동차, 드론)</td>
          <td><input type="password" v-model="password"></td>
        </tr>

        <tr>
          <td>Food</td>
          <td><input type="password" v-model="password"></td>
        </tr>

        <tr>
          <td>Unknown(미분류)</td>
          <td><input type="password" v-model="password"></td>
        </tr>

      </table>
    </form>

  </div>
</template>
