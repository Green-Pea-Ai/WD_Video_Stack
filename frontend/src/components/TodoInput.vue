<template>
  <div>
    <h3>Todo Input</h3>
    <input type="text" v-model="newTodoItem"
        v-on:keypress.enter="addTodo">
    <button v-on:click="addTodo">Add</button>
  </div>
</template>

<script>

export default {
  data () {
    return {
      newTodoItem: ''
    }
  },
  methods: {
    addTodo () {
      if (this.newTodoItem !== '') {
        var value = this.newTodoItem && this.newTodoItem.trim()
        // trim()은 공백제거
        // this.newTodoItem.trim()
        console.log('addTodo: ' + value)
        this.$emit('addTodo', value)
        this.clearInput()
      }
    },
    clearInput () {
      this.newTodoItem = ''
    }
  }
}

</script>

// css를 보면 스타일링을 좀 더 할수있다.
<style scoped>
  div {
    background-color: #E27676;
  }
</style>
