<template>
  <div>
    <!-- <h3 class="monospace">Todo List</h3> -->
    <ul>
      <h3>Todo List 333</h3>
      <todo-item v-for="todoItem in todoItems"
          v-bind:key="todoItem.id"
          v-bind:todoItem="todoItem"
          v-bind:editingId="editingId"
          v-on:removeTodo="onRemoveTodo"
          v-on:updateTodo="onUpdateTodo"
          v-on:setEditingId="SET_EDITING_ID"
          v-on:resetEditingId="RESET_EDITING_ID"
          v-on:toggleTodoStatus="onToggleTodoStatus"/>
    </ul>
  </div>
</template>

<script>
import TodoItem from './TodoItem.vue'
import { mapState, mapMutations, mapGetters } from 'vuex'
// ../../store (components/todo_comp/store) 이렇게 해줘야 store를 찾아갈 수 있다.
import { RESET_EDITING_ID, SET_EDITING_ID } from '../../store/mutation-types'

export default {
  components: {
    'todo-item': TodoItem
  },
  computed: {
    todoItems () {
      return this.filteredTodoItems
    },
    ...mapState([
      'editingId'
    ]),
    ...mapGetters([
      'filteredTodoItems'
    ])
  },
  methods: {
    ...mapMutations([
      SET_EDITING_ID,
      RESET_EDITING_ID
    ]),
    onRemoveTodo (id) {
      this.$emit('removeTodo', id)
    },
    onUpdateTodo (content, id) {
      this.$emit('updateTodo', content, id)
    },
    onToggleTodoStatus (id) {
      this.$emit('toggleTodoStatus', id)
    }
    /* removeTodo (todoItem, idx) {
      console.log('removeTodo')
      // splice() : 배열에서 값 추출
      // this.todoItems.splice(idx, 1)
      this.$emit('removeTodo', todoItem, idx)
    },
    handleDblClick (idx) {
      const { id } = this.todoItems[idx]
      this.$emit('setEditingId', id)

      // this.todoItems[idx].isEditing = true

      // refs 자바스크립트에 보면 DOM이란 것이 있다.
      // DOM에 각종 HTML 태그들이 연결이 되는데
      // Vue, React 것들은 자동으로 template을 맵핑시켜서 재활용성을 높여주는 녀석들임
      // 특정 키워드를 통해서 Automatic HTML Tag를 생성해준다고도 말할 수 있다.
      // 그러다보니 HTML내에 있는 값들을 참조할때 $refs 통해 접근할 수 있게 해준다.
      // console.log('handleDblClick this.$refs:', this.$refs.content[0])
      // console.log('handleDblClick this.$refs.content[0]:', this.$refs.content[0])

      // UI 처리가 끝난 시점에 혹시 처리가 되지 않을 수도 있는 녀석들이 있다 판단하면
      // nextTick()에서 처리를 해주면 미처 처리되지 않았을 수도 있는 것들을 완벽하게 처리할 수 있다.
      this.$nextTick(() => {
        console.log('handleDblClick this.$refs.content[0]:', this.$refs.content[0])
        this.$refs.content[0].focus()
      })
    },
    updateTodo (id, e) {
      // console.log('updateTodo e:', e)

      const content = e.target.value.trim()

      if (content.length <= 0) {
        return false
      }
      // emit을 쓰면 컴포넌트 전달이 된다.(TodoList.vue -> Todo.vue)
      this.$emit('updateTodo', content, id)

      this.$ref.content[0].blur()
    }, */
  }
}
</script>

<style scoped>
  div {
    background-color: #C0FCC5;
  }
  .monospace {
    font-family: "Lucida Console", Courier, monospace;
    text-decoration: underline;
  }
</style>
