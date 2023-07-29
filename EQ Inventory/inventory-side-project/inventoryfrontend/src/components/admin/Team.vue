<template>
  <ul>
      <li v-for="team in teams" :key="team.id"> {{ team.name }} </li>
  </ul>
</template>

<script>
import TeamService from "../../services/TeamService.js"
export default {
    name: "AdminTeam",
    data() {
        return {
            teams: []
        }
    },
    methods: {
        getAll() {
            TeamService.getAll().then(response => {
                this.teams = response.data;
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