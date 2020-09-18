<template>
  <table>
    <tr-component v-for="(rowData, index) in tableData"
        :key="index"
        :row-data="rowData"
        :row-index="index"
        :table-data="tableData"
        :turn="turn"
        :winner="winner"
        v-on:updateTurn="updateTurn"
        v-on:updateTableData="updateTableData"
        v-on:updateWinner="updateWinner"
        v-model="propTurn">
    </tr-component>
  </table>
</template>

<script>
import TrComponent from '../five_eye_comp/TrComponent.vue'

export default {
  data () {
    return {
      propTurn: this.turn,
      propWin: this.winner
    }
  },
  components: {
    TrComponent
  },
  props: {
    tableData: Array,
    turn: String,
    winner: String
  },
  updated: function () {
    console.log('tableData: ' + this.tableData +
                ', turn: ' + this.turn +
                ', winner: ' + this.winner)
  },
  methods: {
    updateTurn: function (val) {
      console.log('TableComponent updateTurn: ' + val)
      this.propTurn = val
      this.$emit('updateTurn', this.propTurn)
    },
    updateTableData: function () {
      this.$emit('updateTableData')
    },
    updateWinner: function (val) {
      this.propWin = val
      this.$emit('updateWinner', this.propWin)
    }
  }
}
</script>

<!--
<style>

table {
  border-collapse: collapse;
}
td {
  /* css, 최근에 진행한 Vutify 예제에도 영향을 주는 스타일 시트 옵션이다 */
  border: 1px solid black;
  width: 180px;
  height: 80px;
  text-align: center;
}
</style>
-->
