import axios from "axios";
export default {
    getAll(){
        return axios.get('/inventory');
    },
    getById(id){
        return axios.get(`/inventory/${id}`);
    },
}