<template>
  <Layout>
    <template #menubar>
      <v-btn @click="start('society')" text color="black"
        style="padding: 10px; width: 90px;">사회</v-btn>

      <v-btn @click="start('politics')" text color="black"
        style="padding: 10px; width: 90px;">정치</v-btn>

      <v-btn @click="start('economic')" text color="black"
        style="padding: 10px; width: 90px;">경제</v-btn>

      <v-btn @click="start('foreign')" text color="black"
        style="padding: 10px; width: 90px;">국제</v-btn>

      <v-btn @click="start('culture')" text color="black"
        style="padding: 10px; width: 90px;">문화</v-btn>

      <v-btn @click="start('digital')" text color="black"
        style="padding: 10px; width: 90px;">IT</v-btn>
    </template>

    <template #content>
      <!-- vuetify를 써야 v simple table을 쓸 수 있다. -->
      <v-simple-table>
        <template v-slot:default>
          <!-- 쓰레드아니고 t헤드임 -->
          <thead>
            <tr>
              <th class="text-left">No.</th>
              <th class="text-left">제목</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="list of lists" :key="list.title">
              <td style="color: gray">{{ list.newsNo }}</td>
              <td><a @click="clickNew(list.newsNo)">{{ list.title }}</a></td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </template>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'

export default {
  components: { Layout },
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickNews (newsNo) {
      console.log('clickNews: ' + newsNo)
      this.$store.dispatch('crawlFindOne', newsNo)
    },
    start (category) {
      this.$store.dispatch('crawlFind', category)
    }
  }
}
</script>
