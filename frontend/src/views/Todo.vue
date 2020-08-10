<template>
  <div class="todo">
    <todo-header></todo-header>
    <todo-input v-on:addTodo="onAddTodo"></todo-input>
    <todo-filter></todo-filter>
    <todo-list v-on:removeTodo="onRemoveTodo"
              v-on:updateTodo="onEditTodo"
              v-on:toggleTodoStatus="onToggleTodoStatus"></todo-list>
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
import TodoFilter from '../components/TodoFilter.vue'
import { mapActions } from 'vuex'
// import store from '../store'
// import { SET_EDITING_ID, RESET_EDITING_ID } from '../store/mutation-types'

export default {
  name: 'Todo',
  components: {
    // GlobalComponent의 형식?
    'todo-header': TodoHeader,
    'todo-input': TodoInput,
    'todo-list': TodoList,
    'todo-footer': TodoFooter,
    'todo-filter': TodoFilter
  },
  methods: {
    ...mapActions([
      'clearAll',
      'addTodo',
      'removeTodo',
      'generateRandomNumber',
      'save',
      'restore',
      'editTodo',
      'toggleTodoStatus'
    ]),
    onClearAll () {
      this.clearAll()
      this.save()
    },
    onAddTodo (content) {
      const todoItem = { content }
      this.addTodo(todoItem)
      this.save()
    },
    onRemoveTodo (id) {
      this.removeTodo(id)
      this.save()
    },
    randomNumber () {
      // this.$store.dispatch('generateRandomNumber')
      // 인자가 없어도 액션에 전달이 된다
      this.generateRandomNumber()
    },
    onEditTodo (content, id) {
      this.editTodo({ id, content })
      this.save()
    },
    onToggleTodoStatus (id) {
      this.toggleTodoStatus(id)
      this.save()
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
  created () {
    // 새로고침 했을 때 데이터를 유지해주는 코드
    this.restore()
  },
  // computed : 간단한 연산을 도와주는 녀석, 많은 데이터 처리에는 적합하지 않다.
  computed () {
    this.restore()
  }
}
</script>

<style>
  body {
    text-align: center;
    background-color:#FCF0C0;
  }
</style>
