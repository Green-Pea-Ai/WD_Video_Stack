<template>
  <div class="search-form">
    <h3>검색 테스트(사용 안함)</h3>

    <v-app id="inspire">
      <v-col class="search-form" cols="12" sm="15">

        <input type="text" placeholder="영화명 검색" class="form-control"
                 id="mov_title" required v-model="movTitle" name="mov_title">

        <div class="btn-group">
          <v-btn id="vd_upload" v-on:click="searchVideoInfo" large color="primary">검색 버튼</v-btn>
        </div>

        <div class="my-2">
          <v-btn id="vd_select" v-on:click="clk_vd_select" large>미사용 버튼</v-btn>
        </div>

      </v-col>
    </v-app>
  </div>
</template>

<style>
.search-form {
  background-color: #FFDADA;
  max-height: 350px;
}
</style>
