<template>
  <ul>
      <li v-for="inventoryItem in inventoryItems" :key="inventoryItem.id"> {{ inventoryItem.name }} </li>
  </ul>
</template>

<script>
import InventoryService from "../../services/InventoryService.js"
export default {
    name: "AdminInventory",
    data() {
        return {
            inventoryItems: []
        }
    },
    methods: {
        getAll() {
            InventoryService.getAll().then(response => {
                this.inventoryItems = response.data;
            });
        }
    },
    created() {
        this.getAll();
    }
}
</script>

<style>

</style>