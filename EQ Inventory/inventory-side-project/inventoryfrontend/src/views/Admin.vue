<template>
  <div>
      <admin-list/>
      <admin-inventory v-if="showInventoryView" />
      <admin-team v-if="showTeamView" />
  </div>
</template>

<script>
import AdminList from "../components/admin/AdminList.vue";
import AdminInventory from "../components/admin/Inventory.vue";
import AdminTeam from "../components/admin/Team.vue";
export default {
    name: "AdminView",
    components: {
        AdminList,
        AdminInventory,
        AdminTeam,
    },
    computed: {
        showInventoryView() {
            return this.$store.state.currentlySelectedAdminView === 'inventory';
        },
        showTeamView() {
            return this.$store.state.currentlySelectedAdminView === 'team';
        }
    }
}
</script>

<style>

</style>