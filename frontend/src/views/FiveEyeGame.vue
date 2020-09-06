<template>
  <!-- 실제로는 오목아니고 삼목 -->
  <div class="FiveEyeGame">
    <div>{{ turn }}님의 턴입니다.</div>

    <!-- v-bind:turn="turn"을 아래처럼
    :turn="turn"으로 생략해서 쓸 수도 있다. -->
    <table-component :table-data="tableData"
        :turn="turn"
        :winner="winner석"
        v-on:updateTurn="updateTurn"
        v-on:updateTableData="updateTableData"
        v-on:updateWinner="updateWinner">
    </table-component>
    <div v-if="winner">{{ winner }}님의 승리!</div>
  </div>
</template>

<script>
import TableComponent from '../components/five_eye_comp/TableComponent.vue'

export default {
  components: {
    TableComponent
  },
  data () {
    return {
      turn: 'O',
      winner: '',
      tableData: [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ]
    }
  },
  updated: function () {
    console.log('tableData: ' + this.tableData +
                ', turn: ' + this.turn +
                ', winner: ' + this.winner)
  },
  methods: {
    updateTurn: function (val) {
      console.log('FiveEyeGame updateTurn: ' + val)
      this.turn = val
    },
    updateTableData: function () {
      this.tableData = [
        ['', '', ''],
        ['', '', ''],
        ['', '', '']
      ]
    },
    updateWinner: function (val) {
      this.winner = val
    }
  }
}

</script>
