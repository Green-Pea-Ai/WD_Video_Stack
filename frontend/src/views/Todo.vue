<template>
  <div class="todo">
    <todo-header></todo-header>
    <todo-input v-on:addTodo="onAddTodo"></todo-input>
    <todo-list v-bind:todoItems="todoItems"
              v-on:removeTodo="onRemoveTodo"></todo-list>
    <todo-footer v-on:removeAll="onClearAll"></todo-footer>
    <b>random: {{ this.$store.getters.random }}</b><br>
    <input type="button" @click="randomNumber()" value="random"/><br>
  </div>
</template>

<script>
import TodoHeader from '../components/TodoHeader.vue'
import TodoInput from '../components/TodoInput.vue'
import TodoList from '../components/TodoList.vue'
import TodoFooter from '../components/TodoFooter.vue'
// import store from '../store'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'Todo',
  components: {
    'todo-header': TodoHeader,
    'todo-input': TodoInput,
    'todo-list': TodoList,
    'todo-footer': TodoFooter
  },
  /* data () {
    return {
      todoItems: []
    }
  }, */
  methods: {
    ...mapActions([
      'clearAll',
      'addTodo',
      'removeTodo',
      'generateRandomNumber',
      'save',
      'restore'
    ]),
    onClearAll () {
      this.clearAll()
      this.save()
    },
    onAddTodo (todoItem) {
      this.addTodo(todoItem)
      this.save()
    },
    onRemoveTodo (todoItem, idx) {
      this.removeTodo(idx)
      this.save()
    },
    randomNumber () {
      this.generateRandomNumber()
    },
    created () {
      this.restore()
    }
    /* clearAll () {
      // this.todoItems = []
      // dispatch를 사용하면 store의 action으로 보낼 수 있다.
      store.dispatch('clearAll')
    },
    addTodo (todoItem) {
      // this.todoItems.push(todoItem)
      store.dispatch('addTodo', todoItem)
    },
    removeTodo (todoItem, idx) {
      // this.todoItems.splice(idx, 1)
      store.dispatch('removeTodo', idx)
    } */
  },
  // computed : 간단한 연산을 도와주는 녀석, 많은 데이터 처리에는 적합하지 않다.
  computed: {
    ...mapState([
      'todoItems'
    ])

    /* todoItems () {
      return store.state.todoItems
    } */
  }
}
</script>

<style>
  body {
    text-align: center;
    background-color:#FCF0C0;
  }
</style>
