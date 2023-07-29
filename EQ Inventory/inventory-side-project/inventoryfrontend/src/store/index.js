import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    currentlySelectedAdminView: ''
  },
  mutations: {
    SET_CURRENTLY_SELECTED_ADMIN_VIEW(state, selected) {
      state.currentlySelectedAdminView = selected;
    }
  },
  actions: {
  },
  modules: {
  }
})
