import Vue from 'vue'
import Vuex from 'vuex'
// axios : 스프링과의 통신을 도와줌
// import axios from 'axios'

import state from './states'
import actions from './actions'
import mutations from './mutations'
import getters from './getters'

Vue.use(Vuex)

export default new Vuex.Store({

  state,
  actions,
  mutations,
  getters

})
