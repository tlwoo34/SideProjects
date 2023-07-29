<template>
  <ul>
      <li @click="setAdminView('inventory')"><a href="#">Inventory</a></li>
      <li @click="setAdminView('team')">Team</li>
      <li @click="setAdminView('role')">Role</li>
      <li @click="setAdminView('personnel')">Personnel</li>
      <li @click="setAdminView('transactions')">Transactions</li>
      <li @click="setAdminView('rolePermissions')">Role Permissions</li>
      <li @click="setAdminView('teamPermissions')">Team Permissions</li>
  </ul>
</template>

<script>
export default {
    name: "AdminList",
    methods: {
      setAdminView(selectedView) {
        this.$store.commit('SET_CURRENTLY_SELECTED_ADMIN_VIEW', selectedView);
      }
    }

}
</script>

<style>

</style>