export default {
  filteredTodoItems (state) {
    if (!state.filter) {
      return state.todoItems
    }

    if (state.filter === 'A') {
      return state.todoItems.filter(todoItem => {
        return todoItem.done === false
      })
    }

    if (state.filter === 'B') {
      return state.todoItems.filter(todoItem => {
        return todoItem.done === true
      })
    }
  },
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
