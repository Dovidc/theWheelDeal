<template>
  <div id="employee-page">
    <h1>Employee Dashboard</h1>
    <div class="work-orders">
      <h2>Work Orders</h2>
      <div v-for="order in workOrders" :key="order.id" class="work-order">
        <div class="order-info">
          <p><strong>Customer:</strong> {{ order.customerName }}</p>
          <p><strong>Workorder:</strong> {{ order.workOrder }}</p>
          <p><strong>Status:</strong> {{ order.status }}</p>
        </div>
        <button @click="viewInvoice(order)" class="view-invoice-btn">View Invoice</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
 data() {
    return {
      workOrders: [
        {
          id: 1,
          customerName: "John Doe",
          workOrder: "Replace Brake Pads",
          status: "In Progress",
        },
        {
          id: 2,
          customerName: "Jane Smith",
          workOrder: "Oil Change",
          status: "Completed",
        },
        // Add more work orders as needed
      ],
    };
},
methods: {
    // Sayf: will we need this?
    viewInvoice() {
        
      // Logic to view invoice for the selected work order
    },
  },
};
</script>

<style >
#employee-page {
  padding: 20px;
}

.work-orders {
  margin-top: 20px;
}

.work-order {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  margin-bottom: 10px;
  background-color: #f5f5f5;
  border-radius: 5px;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
}

.order-info {
  flex: 1;
}

.view-invoice-btn {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 5px 10px;
  border-radius: 4px;
  cursor: pointer;
}

.view-invoice-btn:hover {
  background-color: #0056b3;
}
body {
      background-image: url("https://cdn.cnn.com/cnnnext/dam/assets/220721175751-woman-mechanic-stock-super-tease.jpg"); /* Replace with the actual path to your image */
      background-size:cover; /* Adjust this property to control how the image covers the background */
      background-repeat: no-repeat;
    }
</style>