<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->

    <div id="header">
      <router-link :to="{ name: 'Home' }"
          class="nav-link" active-class="active">
        [home]
      </router-link>

      <router-link :to="{ name: 'About' }"
          class="nav-link" active-class="active">
        [About Us]
      </router-link>

      <router-link :to="{ name: 'Test' }"
          class="nav-link" active-class="active">
        [testttt]
      </router-link>

      <router-link :to="{ name: 'Todo' }"
          class="nav-link"
          active-class="active">
        [Todo exam]
      </router-link>
    </div>

    <h2>This is an Home Page</h2>
      <div id="app">
        {{ message }}<br>
      </div>

  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
/* eslint-disable no-unused-vars */
// 위 주석을 넣어주면 오류가 없어짐
// 해킹 문제 때문에 사용하지 않는 변수는 선언 못하게 해놓고 있음
// 사용하지 않는 변수를 사용하게 해주는 옵션(보안에는 취약해짐)
// tab 2번 안됨, 공백 2칸 안됨, 나중엔 병적으로 잘 맞추게 된다고 함

import store from '../store'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  name: 'Home',
  data: function () {
    return {
      message: 'Vue Test Message'
    }
  },
  components: {
    // HelloWorld
  }
}
</script>

<style scoped>
div {
  border: 1px solid #ccc;
}

img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

</style>
