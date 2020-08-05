<template>
  <button @click="addCounter">{{ counter }}</button>
</template>

<script>
export default {
  name: 'global-component',
  props: ['initialCounter'],
  template: '<button @click="addCounter">{{ counter }}</button>',
  data: function () {
    return {
      // <global-component v-bind:initial-counter="counter">
      // this.initialCounter 썼으면 v-bind에서는 initial-counter(헝가리안?) 방식으로 써줘야 함?
      counter: this.initialCounter
    }
  },
  methods: {
    addCounter: function () {
      this.counter += 1
    }
  }
}
</script>
