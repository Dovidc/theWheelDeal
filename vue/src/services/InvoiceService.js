import axios from "axios";

export default {

    getInvoiceForUser(userId) {
        return axios.get(`/profile/${userId}/invoices`);
    },

    createInvoice(workorderId, invoice) {
        return axios.post(`/workorders/${workorderId}/createinvoice`, invoice)
    }


}