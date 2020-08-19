<template>
  <div class="mania_main" align="center">
    <h1>Movie Mania Page (Beta)</h1>
    <br>
    <!--
    <div id="mania_text_field">
      <v-col cols="12" sm="5">
        <v-text-field
          label="영상의 폴더 경로를 입력해도 업로드가 가능합니다."
          single-line
          outlined
        ></v-text-field>
      </v-col>
    </div>-->

    <div id="mania_btn1" align="center">

        <button id="login" @click="$router.push('ManiaLogin')">
          [ 로그인 ]
        </button>

        <button id="login" @click="$router.push('ManiaSignUp')">
          [ 회원가입 ]
        </button>

        <button id="login" @click="$router.push('ManiaVideoStack')">
          [ 내 영상 보기 ]
        </button>

        <button id="login" @click="$router.push('ManiaFavorite')">
          [ 관심 영상 정보 ]
        </button>

      <v-app id="inspire">
        <v-col class="text-center" cols="12" sm="4">

          <v-text-field
            label="영상의 폴더 경로를 입력해도 업로드가 가능합니다."
            single-line
            outlined
          ></v-text-field>

          <div class="my-1">
            <v-btn id="vd_upload" v-on:click="$router.push('ManiaVideoUpload')" large color="primary">영상 업로드</v-btn>
          </div>
          <div class="my-2">
            <v-btn id="vd_upload" v-on:click="$router.push('ManiaVideoStack')" large color="primary">영상 업로드(자동)</v-btn>
          </div>

          <div class="my-3">
            <v-btn id="vd_select" v-on:click="clk_vd_select" large>업로드 할 영상 찾기</v-btn>
          </div>

        </v-col>
      </v-app>
    </div>
  </div>
</template>
