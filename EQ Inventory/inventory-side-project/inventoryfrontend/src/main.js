import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import axios from 'axios'

Vue.config.productionTip = false
axios.defaults.baseURL = 'http://localhost:9000'

new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
