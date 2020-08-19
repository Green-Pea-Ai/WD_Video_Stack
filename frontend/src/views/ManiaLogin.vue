<template>
  <div class="mania_login" align="center">
    <h1>로그인 페이지</h1>

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
          <td colspan="2" align="center">
            <button type="submit">로그인</button>
          </td>
        </tr>
      </table>
    </form>

  </div>
</template>
