<template>
  <div align="center">
    <h2>Vuetify Real Board List</h2>
    <router-link :to="{ name: 'BoardRegisterPage' }">
      Create New Board
    </router-link>
    <board-list-page-form :list-array="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import BoardListPageForm from '@/components/s5_pagination_comp/BoardListPageForm.vue'

export default {
  name: 'VuetifyBoardListPage',
  components: {
    BoardListPageForm
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    // DB 가져오는 코드
    // 액션으로 분리시키는게 낫다(리팩토링)
    axios.get('http://localhost:7777/boards')
      .then(res => {
        console.log(res)
        this.pageArray = res.data
      })
      .catch(err => {
        console.log(err)
      })
  }
}
</script>
