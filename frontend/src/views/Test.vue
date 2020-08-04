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

        <!-- border-collapse는 테두리와 셀 사이 간격 삭제 -->
        <p>count 기반 순회</p>
        <table border="1" style="border-collapse:collapse;">
          <tr v-bind:key=idx v-for="idx in count">
            <td>{{ msg }}</td>
            <td>{{ idx }}</td>
          </tr>
        </table>

        <p>list() 기반 순회</p>
        <table border="1" style="border-collapse:collapse;">
          <tr v-bind:key=idx v-for="idx in list()">
            <td>{{ message }}</td>
            <td>{{ idx }}</td>
          </tr>
        </table>

        <p>(key, value) 기반 순회</p>
        <table border="1" style="border-collapse:collapse;">
          <tr v-bind:key="(value, key)" v-for="(value, key) in data">
            <td>{{ value }}</td>
            <td>{{ key }}</td>
          </tr>
        </table>

        <!-- this.$store가 결국 Vuex를 사용하겠단 의미 -->
        <b>count: {{ this.$store.state.count }}</b><br>
        <b>count^2: {{ this.$store.getters.count }}</b><br>
        <b>weight: {{ this.$store.getters.weight }}</b><br>
        <input type="button" @click="increment()" value="inc"/>
        <input type="button" @click="decrement()" value="dec"/><br>
        <b>random: {{ this.$store.getters.random }}</b><br>
        <input type="button" @click="randomNumber()" value="random"/><br>

      </div>
    </div>

</template>

<script>
import Vue from 'vue'
/* eslint-disable no-unused-vars */
import store from '../store'
import cookies from 'vue-cookies'

// cookies는 상태정보를 저장한다.
Vue.use(cookies)

export default {
  data: function () {
    return {
      msg: 'Test',
      count: 7,
      list: function () {
        var list = []
        for (var i = 1; i < this.count; i += 2) {
          list.push(i)
        }
        return list
      },
      message: 'Test Page',
      seen: true,
      todos: [
        { text: 'JavaScript' },
        { text: 'Golang' },
        { text: 'C++' }
      ],
      cnt: 0,
      data: {
        bird: 'raven',
        animal: 'tiger',
        fish: 'tuna',
        proj: 'cnn',
        major: 'EE'
      }
    }
  },
  methods: {
    reverseMsg: function () {
      this.message = this.message.split('').reverse().join('')
    },
    intCnt: function () {
      this.cnt++
    },
    increment: function () {
      this.$store.commit('increment')
      // 60 * 60 * 24 : 24시간, '1h' : 1시간
      this.$cookies.set('value', this.$store.state.count, '1h')
    },
    decrement: function () {
      this.$store.commit('decrement')
      this.$cookies.set('value', this.$store.state.count, '1h')
    },
    randomNumber: function () {
    // dispatch는 무조건 action으로 간다.
    // commit은 내부에서 실행되며 비동기 처리가 가능하다.
    // 쓰레드의 동기, 비동기 처리를 알고 있어야 한다.
      this.$store.dispatch('generateRandomNumber')
    }
  },
  created: function () {
    this.$store.state.count = this.$cookies.get('value')
  }
}
</script>
