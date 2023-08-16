import axios from "axios";

export default {
                    // Is this right?
    getAllServices() {
        return axios.get(`/`)
    }

}