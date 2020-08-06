export default {
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
}
