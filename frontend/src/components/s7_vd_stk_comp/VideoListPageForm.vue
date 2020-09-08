<template>
  <div>
    <button id="login" @click="$router.push('VideoStackFavorite')">
      [ 관심 영상 정보 ]
    </button>
    <br><br>
    <button id="login" @click="$router.push('')">
      [ 로그아웃 ]
    </button>
    <br><br>

    <h3>영상 정보 리스트</h3>
    <table border="1">
      <tr>
        <th align="center" width="80">No</th>
        <th align="center" width="320">Movie Title</th>
        <th align="center" width="150">Director</th>
        <th align="center" width="200">Registration Date</th>
      </tr>

      <tr v-for="page in paginatedData" :key="page.boardNo">
        <td>{{ page.boardNo }}</td>
        <td>{{ page.mov_title }}</td>
        <td>{{ page.director }}</td>
        <td>{{ page.regDate }}</td>
      </tr>
    </table>

    <div class="btn-cover">
      <button :disabled="pageNum === 0"
        @click="prevPage" class="page-btn">
        [이전]
      </button>
      <span class="page-count"> {{ pageNum + 1 }} / {{ pageCount }} 페이지 </span>
      <button :disabled="pageNum >= pageCount - 1"
        @click="nextPage" class="page-btn">
         [다음]
      </button>
    </div>

    <v-app id="inspire">
      <v-col class="text-center" cols="12" sm="15">

        <v-text-field
          label="제목이나 내용을 입력하여 검색하세요."
          single-line
          outlined
        ></v-text-field>

        <div class="my-1">
          <v-btn id="vd_upload" v-on:click="$router.push('VideoStackUpload')" large color="primary">영상 정보 검색</v-btn>
        </div>

        <div class="my-2">
          <v-btn id="vd_upload" v-on:click="$router.push('')" large color="primary">미사용 버튼</v-btn>
          <br>
        </div>

        <div class="my-3">
          <v-btn id="vd_select" v-on:click="clk_vd_select" large>미사용 버튼2</v-btn>
        </div>

      </v-col>
    </v-app>
  </div>
</template>

<script>
export default {
  name: 'VideoListPageForm',
  data () {
    return {
      pageNum: 0
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: true,
      default: 3
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    }
  },
  // 하나에 몰아넣을 것임. 리팩토링 필요함
  // let은 var와 비슷하다.
  computed: {
    pageCount () {
      const listLen = this.listArray.length
      const listSize = this.pageSize

      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }
      return page
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize

      return this.listArray.slice(start, end)
    }
  }
}
</script>
