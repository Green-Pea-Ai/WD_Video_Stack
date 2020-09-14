<template>
  <div id="board">
    <h2>S3 Board List</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      Create New Board
    </router-link>
    <!--
      아래에 :boards="boards"를 추가해주면
      리스트 뷰에서 db 값을 받아와 화면에 뿌려준다(mapState와 연관)
     -->
    <board-list :boards="boards"/>
  </div>
</template>

<script>
import BoardList from '@/components/s3_board_comp/BoardList'
import { mapState, mapActions } from 'vuex'

export default {
  name: 'BoardListPage',
  components: {
    BoardList
  },
  computed: {
    ...mapState(['boards'])
  },
  mounted () {
    this.fetchBoardList()
  },
  methods: {
    ...mapActions(['fetchBoardList'])
  }
}
</script>
