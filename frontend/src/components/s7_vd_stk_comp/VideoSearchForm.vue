<template>
  <div class="searchform">
    <h3>검색 테스트</h3>

    <v-app id="inspire">
      <v-col class="search-form" cols="12" sm="15">

        <input type="text" placeholder="영화명 검색" class="form-control" id="mov_title" required v-model="movTitle" name="mov_title">

        <div class="my-1">
          <v-btn id="vd_upload" v-on:click="$router.push('VideoStackUpload')" large color="primary">검색 버튼</v-btn>
        </div>

      </v-col>
    </v-app>
  </div>
</template>

<style>
.searchform {
  background-color: #FF0044;
  max-height: 350px;
}
</style>
