<template>
  <div>
    <h3>Todo List</h3>
    <ul>
      <li v-for="(todoItem, idx) in todoItems"
          v-bind:key="idx">
          {{ todoItem }}
          <button v-on:click="removeTodo(todoItem, idx)">
            Delete
          </button>
      </li>
    </ul>
  </div>
</template>

<script>

export default {
  data () {
    return {
      todoItems: ['item1', 'item2', 'item3']
    }
  },
  methods: {
    removeTodo (todoItem, idx) {
      console.log('removeTodo')
      // splice() : 배열에서 값 추출
      this.todoItems.splice(idx, 1)
    }
  }
}

</script>

<style scoped>
  div {
    background-color: #C0FCC5;
  }

</style>
