<template>
  <div class="favorite_page" align="center">
    <!--
      처음에는 직접 설정을 하게 하고 on, off 태그 버튼을 통해 [내 영상
      보기] 페이지에 있는 영상 기반으로도 관심 영상이 표시될 수 있게 구현

      <h4>카테고리를 직접 설정하거나(off) 데이터 수집후에 맞춤기능 버튼을(on)
           이용해 사용자 맞춤 카테고리에 대한 영상정보를 표시합니다.</h4>
    -->
    <br>
    <h2>관심사 영상 리스트</h2><br>
    <h4>유튜브 크롤링 데이터 표시</h4><br>
    <!--<img src="/home/bitai/Downloads/Mania_favorite1.jpeg" alt="관심사 이미지">-->
    <table border="1">
      <tr>
        <th align="center" width="100">YouTube No</th>
        <th align="center" width="130">YouTuber Name</th>
        <th align="center" width="250">YouTube Title</th>
        <th align="center" width="100">Play Time</th>
        <th align="center" width="130">Subscribe Num</th>
        <th align="center" width="130">Views Num</th>
        <th align="center" width="150">Upload Time</th>
        <th align="center" width="130">Crawling Time</th>
        <!-- <th align="center" width="130">YouTube Link</th> -->
      </tr>

      <tr v-for="page in paginatedCrawlData" :key="page.youtubeNo">
        <td>{{ page.youtubeNo }}</td>
        <td>{{ page.youtuberName }}</td>
        <td><a v-bind:href="page.youtubeLink">{{ page.youtubeTitle }}</a></td>
        <td>{{ page.youtubePlayTime }}</td>
        <td>{{ page.subscribeNum }}</td>
        <td>{{ page.viewsNum }}</td>
        <td>{{ page.uploadTime }}</td>
        <td>{{ page.crawlingTime }}</td>
        <!-- <td><a v-bind:href="page.youtubeLink">{{ page.youtubeLink }}</a></td> -->
      </tr>
    </table>

    <div class="btn-cover2">
      <button :disabled="pageNum === 0"
        @click="prevPage" class="page-btn2">
        [이전]
      </button>
      <span class="page-count2"> {{ pageNum + 1 }} / {{ pageCount }} 페이지 </span>
      <button :disabled="pageNum >= pageCount - 1"
        @click="nextPage" class="page-btn2">
        [다음]
      </button>
    </div>
    <br>
    <!--
    <table>
      <tr>
        <td><label>엑셀 다운로드하기</label></td>
        <td><button @click="onCSVFileDownload">[버튼1: 파이썬 코드를 작동시켜 다운로드]</button></td>
        <td><button @click="onCSVFileDownload">[버튼2: Vue에 띄워진 것을 다운로드]</button></td>
      </tr>
    </table>
    -->
  </div>
</template>

<script>
export default {
  name: 'VideoFavoriteForm',
  data () {
    return {
      pageNum: 0
    }
  },
  // props는 어딘가에서 가져온 것을 쓰는 것이다.
  // 오목예제, FEG -> TC에서 props가 어떤 데이터를 가져오는지 확인해보면 됨
  // pageSize는 default 줘서 쓸 수 있다.(다른 곳에서 안받아와도 됨)
  props: {
    crawlListArray: {
      type: Array,
      required: true
    },
    // 웹페이지 개발도구에서 FavoritePage,
    // Missing required prop: pageSize 오류 띄움
    // required를 true -> false로 변경함
    // 사용한다고 해놓고 사용 안해서 나는 오류인듯하다.
    pageSize: {
      type: Number,
      required: false,
      default: 3
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1
    },
    prevPage () {
      this.pageNum -= 1
    },
    onCSVFileDownload () {
    }
  },
  // 리팩토링 필요
  computed: {
    pageCount () {
      const listLen = this.crawlListArray.length
      const listSize = this.pageSize

      let page = Math.floor(listLen / listSize)
      if (listLen % listSize > 0) {
        page += 1
      }
      return page
    },
    paginatedCrawlData () {
      const start = this.pageNum * this.pageSize
      const end = start + this.pageSize

      return this.crawlListArray.slice(start, end)
    }
  }
}
</script>

<style>
.favorite_page {
  max-width: auto;
  max-height: auto;
  margin: auto;
  background-color: #D0F0C8;
}
</style>
