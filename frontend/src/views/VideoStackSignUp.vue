<template>
  <div class="mania_sign_up" align="center">
    <h1>회원가입 페이지</h1>
    <br>
    <h4>이메일 인증 완료 후 영상 업로드와</h4>
    <h4>영상 관리 서비스를 사용할 수 있습니다.</h4>
    <br>

    <form @submit.prevent="submit">
      <table>
        <tr>
          <td>E-mail</td>
          <td><input type="text" v-model="userid"></td>
        </tr>

        <tr>
          <td>Password</td>
          <td><input type="password" v-model="password"></td>
        </tr>

        <tr>
          <td>Password Confirm</td>
          <td><input type="password" v-model="password"></td>
        </tr>

        <tr>
          <td colspan="2" align="center">
            <button type="submit">회원가입</button>
          </td>
        </tr>
      </table>
    </form>

  </div>
</template>
