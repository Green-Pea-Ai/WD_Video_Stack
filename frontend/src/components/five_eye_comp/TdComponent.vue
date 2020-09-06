<template>
  <!--
    Td가 최상위 기준(Td -> Tr -> TbC -> FEG), 자바처럼 extends가 없어서
    최상위가 Td가 될 수도 FEG가 최상위가 될 수도 있음.
    하지만 데이터 흐름에는 변화가 없다.
  -->
  <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>
export default {
  data () {
    return {
      game: {
        propTurn: this.turn,
        propWin: this.winner
      }
    }
  },
  props: {
    // GlobalComponent 를 쓰려면 형식을 맞춰줘야 한다.
    // GlobalComponent ===> global-component
    cellData: String,
    rowIndex: Number,
    cellIndex: Number,
    tableData: Array,
    turn: String,
    winner: String
  },
  methods: {
    onClickTd () {
      // 클릭했을 때 OX 찍어주는 코드
      if (this.cellData) return
      this.$set(this.tableData[this.rowIndex], this.cellIndex, this.turn)

      let win = false

      if (
        this.tableData[this.rowIndex][0] === this.turn &&
        this.tableData[this.rowIndex][1] === this.turn &&
        this.tableData[this.rowIndex][2] === this.turn
      ) {
        win = true
      }
      if (
        this.tableData[0][this.cellIndex] === this.turn &&
        this.tableData[1][this.cellIndex] === this.turn &&
        this.tableData[2][this.cellIndex] === this.turn
      ) {
        win = true
      }
      if (
        this.tableData[0][0] === this.turn &&
        this.tableData[1][1] === this.turn &&
        this.tableData[2][2] === this.turn
      ) {
        win = true
      }
      if (
        this.tableData[0][2] === this.turn &&
        this.tableData[1][1] === this.turn &&
        this.tableData[2][0] === this.turn
      ) {
        win = true
      }
      if (win) {
        this.game.propWin = this.turn
        // 하위에 데이터 전달
        this.$emit('updateWinner', this.game.propWin)
        this.$emit('updateTurn', 'O')
        this.$emit('updateTableData')
      } else {
        let all = true
        // 모든 셀들이 체크가 되었는가?
        this.tableData.forEach(row => {
          row.forEach(cell => {
            if (!cell) {
              all = false
            }
          })
        })

        if (all) {
          this.propWin = ''
          this.$emit('updateTurn', 'O')
          this.$emit('updateTableData')
        } else {
          this.game.propTurn = this.turn === 'O' ? 'X' : 'O'
          this.$emit('updateTurn', this.game.propTurn)
        }
      }
    }
  },
  mounted: function () {
    console.log('tableData: ' + this.tableData +
                ', turn: ' + this.turn +
                ', winner: ' + this.winner)
  }
}
</script>

<style></style>
