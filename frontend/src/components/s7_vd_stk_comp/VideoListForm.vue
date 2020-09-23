<template>
    <div class="list-form">
      <br>
      <h3>영상 정보 리스트</h3>
      <table border="1">
        <tr>
          <th align="center" width="80">No</th>
          <th align="center" width="320">Movie Title</th>
          <th align="center" width="150">Director</th>
          <th align="center" width="200">Registration Date</th>
        </tr>

        <tr v-for="page in paginatedData" :key="page.videoNo">
          <td>{{ page.videoNo }}</td>
          <td>
            <router-link :to="{ name: 'VideoReadPage',
                params: { videoNo: page.videoNo.toString() } }">
              {{ page.movTitle }}
            </router-link>
          </td>
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
      <br>

      <!--
      <v-app id="inspire">
        <v-col class="listform-btn" cols="12" sm="15">

          <v-text-field label="제목이나 내용을 입력하여 검색하세요."
            single-line outlined
          ></v-text-field>

        </v-col>
      </v-app>
      -->
    </div>
</template>

<script>
export default {
  name: 'VideoListForm',
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

<style>
.list-form {
  max-width: auto;
  max-height: auto;
  margin: auto;
  /* text-align: center; */
  background-color: #E7F288;
}
/*
.listform-btn {
  background-color: #D7FAB9;
  max-height: 200px;
} */
/* 검색폼(VideoSearchForm)은 여기 없지만 전역으로 쓸 수 있는 것 같다 */
.search-form {
  background-color: #A9B2F5;
}
</style>
