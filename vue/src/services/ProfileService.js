import axios from 'axios';

export default {

    getProfile() {
        return axios.get('/profile')
    }

}