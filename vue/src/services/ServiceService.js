<<<<<<< HEAD
import axios from 'axios';

export default {

    getAllServices() {
        return axios.get('/services');
=======
import axios from "axios";

export default {
                    // Is this right?
    getAllServices() {
        return axios.get(`/`)
>>>>>>> 6003a03db8000ef9b5bb1b656512c8751facfc3e
    }

}