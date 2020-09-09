<template>
  <div align="center">
    <h1>VideoStack Main Page(Beta)</h1>
    <br>
    <router-link :to="{ name: 'VideoListPage'}">
      [영화 게시판]
    </router-link>

    <router-link :to="{ name: 'VideoStackFavorite'}">
      [관심 영화 정보]
    </router-link>
    <br><br>
    <button id="login" @click="$router.push('')">
      [ 로그아웃 ]
    </button>
  </div>
</template>
