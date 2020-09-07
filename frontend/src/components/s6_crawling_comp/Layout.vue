<template>
  <v-app id="inspire">
    <v-app-bar
      app
      clipped-right
      color="blue"
      dark
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title><div @click="home">Crawl Project</div></v-toolbar-title>
      <v-spacer></v-spacer>
      <!-- CrawlCategory.vue에서 만든 #menubar를 가져온다 -->
      <slot name="menubar"></slot>
    </v-app-bar>
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <!-- 아이콘 변경 시 이곳을 수정 -->
            <v-icon>mdi-exit-to-app</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title @click="home">홈으로 이동</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>mdi-exit-to-app</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title @click="category">카테고리별 분류 보기</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <div>>>>></div>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title @click="suggest">추천 뉴스 보기</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list dense>
        <v-list-item @click.stop="left = !left">
          <v-list-item-action>
            <v-icon>mdi-exit-to-app</v-icon>
          </v-list-item-action>

          <v-list-item-content>
            <v-list-item-title @click="savednews()">저장된 뉴스 보기</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

    </v-navigation-drawer>

    <v-container>
      <v-content id="content">
        <!-- CrawlCategory.vue에서 만든 #content를 가져온다 -->
        <slot name="content" class="font">
        </slot>
      </v-content>
    </v-container>

    <v-footer
      app
      color="blue"
      class="white--text"
    >
      <v-spacer></v-spacer>
      <span>&copy; Crawl Project</span>
    </v-footer>
  </v-app>
</template>

<script>
import router from '@/router'

export default {
  // '=>'를 쓰면 return을 안써도 된다.
  data: () => ({
    drawer: false,
    left: false
  }),
  methods: {
    home () {
      (window.location.pathname !== '/') ? router.push('/') : router.go(0)
    },
    category () {
      (window.location.pathname !== '/CrawlCategory') ? router.push('CrawlCategory') : router.go(0)
    },
    suggest () {
      (window.location.pathname !== '/suggestednews/list') ? router.push('suggestednews/list') : router.go(0)
    },
    savednews () {
      (window.location.pathname !== '/savednews/list') ? router.push('savednews/list') : router.go(0)
    }
  }
}
</script>
