<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->

    <div id="header" v-if="isAuthorized">
      <button id="login" @click="onCLickLogout">Logout</button>

      <router-link :to="{ name: 'Home' }"
          class="nav-link"
          active-class="active">
        [home]
      </router-link>

      <router-link :to="{ name: 'About' }"
          class="nav-link"
          active-class="active">
        [About Us]
      </router-link>

      <router-link :to="{ name: 'Test' }"
          class="nav-link"
          active-class="active">
        [testttt]
      </router-link>

      <router-link :to="{ name: 'Todo' }"
          class="nav-link"
          active-class="active">
        [Todo exam]
      </router-link>

      <router-link :to="{ name: 'FiveEyeGame' }"
          class="nav-link"
          active-class="active">
        [FiveEyeGame]
      </router-link>

      <router-link :to="{ name: 'BoardListPage' }"
          class="nav-link"
          active-class="active">
        [Board!]
      </router-link>

      <router-link :to="{ name: 'VuetifyBoard' }"
          class="nav-link"
          active-class="active">
        [VuetifyBoard]
      </router-link>

      <router-link :to="{ name: 'VuetifyBoardListPage' }"
          class="nav-link"
          active-class="active">
        [VuetifyBoardListPage]
      </router-link>

    <h2>This is an Home Page</h2>
      <div id="app">
        {{ message }}<br>
      </div>

      <router-link :to="{ name: 'CrawlCategory' }"
          class="nav-link"
          active-class="active">
        [CrawlCategory]
      </router-link>

      <div>
        <br><span>{{ myinfo.auth }}계정, 접속을 환영합니다.</span>
      </div>
    </div>

    <div id="header" v-else>
      <button id="login" @click="$router.push('LoginPage')">
        [ Login ]
      </button>

      <button id="login" @click="$router.push('AdminSetupPage')">
        [ Register Admin ]
      </button>

      <router-link :to="{ name: 'Home' }"
          class="nav-link"
          active-class="active">
        [Home]
      </router-link>

      <router-link :to="{ name: 'About' }"
          class="nav-link"
          active-class="active">
        [About Us]
      </router-link>

      <router-link :to="{ name: 'VideoStackMain' }"
          class="nav-link"
          active-class="active"><!-- 이전 이름 MovieMania -->
        [Video Stack Main]
      </router-link>

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
// import cookies from 'vue-cookies'

import { mapState, mapGetters, mapActions } from 'vuex'

// Vue.use(cookies)

export default {
  name: 'Home',
  data: function () {
    return {
      message: 'Vue Test Message'
    }
  },
  methods: {
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
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

#header {
  padding: 15px;
  margin-bottom: 15px;
  margin: 5px 5px;
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

#login {
  background-color: #567A4B;
  color: #ffffff;
  font-weight: bold;
  float: right;
}
</style>
