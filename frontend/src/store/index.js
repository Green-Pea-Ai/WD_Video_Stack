import Vue from 'vue'
import Vuex from 'vuex'
// axios 스프링과의 통신을 도와줌
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0,
    weight: 2,
    random: 0
  },

  mutations: {
    // state가 크리티컬 섹션이 됐다.
    // 메서드 계산할 때 자동으로 뮤택스 처리를 해준다.
    increment (state) {
      state.count++
    },
    decrement (state) {
      state.count--
    },
    successGenRandNum (state, payload) {
      state.random = payload
    },
    failGenRandNum () {
      alert('망')
    }
  },
  getters: {
    count (state, getters) {
      // 연산이 없어서 크리티컬 섹션이 발생할 일이 없다.
      return Math.pow(state.count, getters.weight)
    },
    weight (state) {
      return state.weight
    },
    random (state) {
      return state.random
    }
  },
  actions: {
    generateRandomNumber ({ commit }) {
      console.log(commit)

      axios.get('http://localhost:7777/random')
        .then((res) => {
          commit('successGenRandNum',
            parseInt(res.data.randNumber))
        })
        .catch((res) => {
          commit('failGenRandNum', res)
        })
    }
  },
  modules: {
  }
})
