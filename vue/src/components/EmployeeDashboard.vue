<template>
  <div class="employee-dashboard">
    <h1>Employee Dashboard</h1>
    <!-- Filter Div -->

    <div class="workorder-filters">
      <h2>Filter Results:</h2>
      <label>Name:</label>
      <input  />
      <label>Completed:</label>
      <input type="checkbox"/>
    </div>
    <!--  -->
    <div class="workorder-list">
      <div
        v-for="workorder in workorders"
        :key="workorder.id"
        class="workorder-item"
      >
        <div class="workorder-details">
          <p><strong>Work Order ID:</strong> {{ workorder.id }}</p>
          <p>
            <strong>Assigned Employee:</strong> {{ workorder.assignedEmployee }}
          </p>
          <p><strong>Customer Name:</strong> {{ workorder.customerName }}</p>
          <!-- Add The Vehicle Info Here -->
          <p><strong>Vehicle:</strong> Make: Model: Plate No:</p>
        </div>

        <div class="services-list">
          <div
            v-for="(service, index) in services"
            :key="index"
            class="service-item"
          >
            <p><strong>Service:</strong> {{ service.name }}</p>
            <p>
              <strong>Status:</strong>
              <select v-model="service.status">
                <option value="Declined">Declined</option>
                <option value="Pending">Pending</option>
                <option value="In Progress">In Progress</option>
                <option value="Completed">Completed</option>
              </select>
            </p>
          </div>
        </div>

        <div class="workorder-checkbox">
          <label>
            <input type="checkbox" v-model="workorder.completed" /> Complete
          </label>
          <button
            v-show="workorder.completed"
            @click="createInvoice(workorder)"
          >
            <!-- When clicked "Create Invoice", it should switch to "Invoice Created" -->
            {{
              workorder.invoiceCreated ? "Invoice Created" : "Create Invoice"
            }}
          </button>
        </div>
        <div class="modal " :class="{'is-active':workorder.id == activeModal}" >
          <div class="modal-background"></div>
          <div class="modal-content"> <Invoice-Popup /></div>
          <button class="modal-close is-large" aria-label="close" @click="activeModal=-1"></button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import InvoicePopup from '../components/InvoicePopup';

export default {
  data() {
    return {
      workorders: [
        {
          id: 1,
          assignedEmployee: "John Doe",
          customerName: "Mr. Potato",
          status: "Pending",
          service: "Oil Change",
          invoiceCreated: false,
          completed: false,
        },
        {
          id: 2,
          assignedEmployee: "Jack Black",
          customerName: "Bruce Wayne",
          status: "Pending",
          service: "Oil Change",
          invoiceCreated: false,
          completed: false,
        },
        // ... other workorders
      ],
      employees: [
        { id: 1, name: "" },
        { id: 2, name: "" },
      ],
      customers: [
        { id: 1, name: "Customer A" },
        { id: 2, name: "Customer B" },
        // ... other customers
      ],
      services: [
        { id: 1, name: "Oil Change" },
        { id: 2, name: "Brake Repair" },
        // ... other services
      ],
      activeModal:-1
    };
  },
  methods: {
    createInvoice(workorder) {
      workorder.invoiceCreated = true; // Mark the workorder as invoice created
      this.activeModal = workorder.id; // set the id to match the model
    },
  },
  components: {
    InvoicePopup
  },
};
</script>

<style scoped>
.employee-dashboard {
  padding: 20px;
  height: 100vh;
}
h1 {
  font-size: 25px;
  font-weight: bolder;
}

.workorder-filters label {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  margin-bottom: 20px;
}

.workorder-filters h2 {
  display: flex;
  margin-bottom: 10px;
  /* padding-top: 10px; */
}

.workorder-filters label {
  margin-right: 5px;
  margin-bottom: 5px;
}

.workorder-item {
  margin-bottom: 20px;
  border: 1px solid #ccc;
  padding: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: rgba(255, 255, 255, 0.8);
  border-radius: 8px;
}

.workorder-details {
  flex: 1;
  color: #555555;
}

.workorder-checkbox {
  flex-shrink: 0;
  color: #555555;
  font-size: 20px;
}
.services-list {
  color: #555555;
}
body {
  background-image: url("https://cdn.cnn.com/cnnnext/dam/assets/220721175751-woman-mechanic-stock-super-tease.jpg"); /* Replace with the actual path to your image */
  background-size: cover; /* Adjust this property to control how the image covers the background */
  background-repeat: no-repeat;
  min-height: 100vh;
}
</style>