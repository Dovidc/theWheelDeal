import axios from "axios";

export default {

    getWorkOrderByUserId(userId) {
        return axios.get(`/profile/${userId}/currentservices`);
    },

    getAllWorkOrders() {
        return axios.get('/employeedashboard/workorders');
    },
        
    createWorkOrder(userId, user) {
        return axios.post(`/profile/${userId}/currentservices`, user);
    },
        // is this right?
    updateWorkOrder(workOrderId ,workOrder) {
        return axios.put(`/employeedashboard/workorders/${workOrderId}`, workOrder)
    }

}