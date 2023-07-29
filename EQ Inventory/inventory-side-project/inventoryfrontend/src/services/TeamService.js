import axios from "axios";
export default {
    getAll(){
        return axios.get('/team');
    },
    getById(id){
        return axios.get(`/team/${id}`);
    },
}