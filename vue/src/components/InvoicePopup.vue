<template>
  <div class="invoice">
    <h1>Invoice</h1>
    
    <div class="invoice-details">
      <p><strong>Work Order ID:</strong> {{ workOrderId }}</p>
      <p><strong>Employee Assigned:</strong> {{ employeeAssigned }}</p>
      <p><strong>Customer Name:</strong> {{ customerName }}</p>
      <p><strong>Vehicle:</strong> {{ vehicleMake }} {{ vehicleModel }} (Plate No: {{ plateNumber }})</p>
    </div>
    
    <table class="services-table">
      <thead>
        <tr>
          <th>Services</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(service, index) in services" :key="index">
          <td>{{ service.name }}</td>
          <td>{{ service.price }}</td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <th>Total:</th>
          <td>{{ total }}</td>
        </tr>
      </tfoot>
    </table>
    
    <div class="paid-checkbox">
        <button v-show="submitInvoiceBtn" >Submit Invoice</button>
      <label>
        <input type="checkbox" v-model="paid" @click="showSubmitInvoiceBtn(submitInvoiceBtn)"> Paid
      </label>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      submitInvoiceBtn: false, 
      workOrderId: "12345",
      employeeAssigned: "John Doe",
      customerName: "Jane Smith",
      vehicleMake: "Toyota",
      vehicleModel: "Camry",
      plateNumber: "ABC123",
      services: [
        { name: "Oil Change", price: "$25.00" },
        { name: "Brake Inspection", price: "$40.00" },
        // Add more services here
      ],
      paid: false,
    };
  },
    methods: {
        showSubmitInvoiceBtn(submitInvoiceBtn) {
            this.submitInvoiceBtn = !submitInvoiceBtn;
        }
    },
  computed: {
    total() {
      return "$" + this.services.reduce((total, service) => total + parseFloat(service.price.slice(1)), 0).toFixed(2);
    },
  },
};
</script>

<style scoped>
.invoice {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ffffff;
  background-color: rgba(143, 142, 142, 0.8);
}

.invoice-details {
  margin-bottom: 20px;
  color: white;
}

.services-table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
  color: rgb(0, 0, 0);
  
}
label {
    padding: 10px
}

.services-table th,
.services-table td {
  padding: 8px;
  border: 1px solid rgb(255, 255, 255);
  text-align: left;
}

.paid-checkbox {
  text-align: right;
  margin-top: 20px;
}
</style>
