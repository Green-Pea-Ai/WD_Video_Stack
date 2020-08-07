<template>
  <div class="todo">
    <li>
      <span v-if="!isEditing" v-on:dblclick="handleDblClick">
        {{ todoItem.content }}
      </span>
      <input v-else type="text" ref="content"
        v-bind:value="todoItem.content"
        v-on:blur="handleBlur"
        v-on:keydown.enter="updateTodo"/>

      <input type="checkbox"
        v-bind:checked="todoItem.done"
        v-on:change="toggleTodoStatus()">
      <button v-on:click="removeTodo">Delete</button>
    </li>
  </div>
</template>

<script>
export default {
  name: 'TodoItem',
  // props -> 컴포넌트 안에서 통신할 때 사용
  // TodoList 바인드 -> TodoItem props로 받음(하위 -> 상위)
  // 상위 -> 하위는 오목만들 때 배움?
  // props가 v-bind에 연결된다.
  props: {
    todoItem: {
      type: Object
    },
    editingId: {
      type: Number
    }
  },
  computed: {
    isEditing () {
      return this.todoItem.id === this.editingId
    }
  },
  methods: {
    removeTodo () {
      const id = this.todoItem.id
      this.$emit('removeTodo', id)
    },
    handleDblClick () {
      const { id } = this.todoItem
      this.$emit('setEditingId', id)
      this.$nextTick(() => {
        this.$refs.content.focus()
      })
    },
    handleBlur () {
      this.$emit('resetEditingId')
    },
    updateTodo (e) {
      const id = this.todoItem.id
      const content = e.target.value.trim()
      if (content.length <= 0) {
        return false
      }
      this.$emit('updateTodo', content, id)
      this.$refs.content.blur()
    },
    toggleTodoStatus () {
      const id = this.todoItem.id
      this.$emit('toggleTodoStatus', id)
    }
  }
}
</script>
