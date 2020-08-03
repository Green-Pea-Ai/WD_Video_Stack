<template>

    <div class="home">
      <!-- <img alt="Vue logo" src="../assets/logo.png">
      <HelloWorld msg="Welcome to Your Vue.js App"/> -->

      <div id="header">
        <router-link :to="{ name: 'Home' }"
            class="nav-link" active-class="active">
          home
        </router-link>

        <router-link :to="{ name: 'About' }"
            class="nav-link" active-class="active">
          About Us
        </router-link>

        <router-link :to="{ name: 'Test' }"
            class="nav-link" active-class="active">
          testttt
        </router-link>
      </div>

      <h2>This is an Test Page</h2>
      <div id="app">
        <p v-if="seen">You can see it!</p>
        <p v-bind:key=todo v-for="todo in todos">
          {{ todo.text }}
        </p>
        <p>{{ message }}</p>
        <button v-on:click="reverseMsg">Reverse Message</button>
        <p>{{ message }}</p>
        <!-- 2개를 연결(v)시킨다. html, vue 코드? -->
        <input v-model="message"><br>
        <!-- 싱글페이지 : 링크 없이 페이지 이동을 가능하게 함 -->
        <button @click="intCnt">{{ cnt }}</button><br>
      </div>
    </div>

</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
// cookies는 상태정보를 저장한다.
Vue.use(cookies)

export default {
  data: function () {
    return {
      message: 'Test Page',
      seen: true,
      todos: [
        { text: 'JavaScript' },
        { text: 'Golang' },
        { text: 'C++' }
      ],
      cnt: 0
    }
  },
  methods: {
    reverseMsg: function () {
      this.message = this.message.split('').reverse().join('')
    },
    intCnt: function () {
      this.cnt++
    }
  }
}
</script>
