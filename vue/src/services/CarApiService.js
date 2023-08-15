import axios from "axios";

export default {
    getMakes() {
        return axios.get('/makes')
    },

    getModels() {
        return axios.get('/models')
    }
}