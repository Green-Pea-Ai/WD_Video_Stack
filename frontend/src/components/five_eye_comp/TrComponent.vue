<template>
  <tr>
    <td-component v-for="(cellData, index) in rowData"
        :key="index"
        :cell-data="cellData"
        :cell-index="index"
        :row-index="rowIndex"
        :table-data="tableData"
        :turn="turn"
        :winner="winner"
        v-on:updateTurn="updateTurn"
        v-on:updateTableData="updateTableData"
        v-on:updateWinner="updateWinner"
        v-model="propTurn">
    </td-component>
  </tr>
</template>

<!-- 지금은 components 를 가리키고 있다, 폴더로 묶기 전에는 src를 가리키고 있어야 됐는데
지금은 왜 이렇게 해야 될까? -->
<script>
import TdComponent from '../five_eye_comp/TdComponent.vue'

export default {
  components: {
    TdComponent
  },
  data () {
    return {
      parent: '부모',
      propTurn: this.turn,
      propWin: this.winner
    }
  },
  props: {
    rowData: Array,
    rowIndex: Number,
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
      console.log('TrComponent updateTurn: ' + val)
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
  },
  beforeUpdate: function () {
  }
}
</script>

<style></style>
