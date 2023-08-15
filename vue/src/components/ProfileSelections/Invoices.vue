<template>
  <div class="invoices-page">
    <h1>User Invoices</h1>
    <div class="invoices-list">
      <div v-for="invoice in invoices" :key="invoice.id" class="invoice">
        <div class="invoice-header">
         
          <div class="invoice-summary">
            <p><strong>Customer:</strong> {{ invoice.customerName }}</p>
            <p><strong>Total:</strong> {{ invoice.total }}</p>
          </div>
           <button class="toggle-details-btn" @click="toggleDetails(invoice)">
            {{ invoice.isOpen ? 'Hide Details' : 'Show Details' }}
          </button>
        </div>
        <transition name="fade">
          <div v-if="invoice.isOpen" class="invoice-details">
            <div class="purchase" v-for="purchase in invoice.purchases" :key="purchase.id">
              <div class="purchase-info">
                <p><strong>Description:</strong> {{ purchase.description }}</p>
                <p><strong>Quantity:</strong> {{ purchase.quantity }}</p>
                <p><strong>Price:</strong> {{ purchase.price }}</p>
              </div>
              <div class="purchase-total">
                <p><strong>Total:</strong> {{ purchase.price * purchase.quantity + '.00$' }}</p>
              </div>
            </div>
          </div>
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      invoices: [
        {
          id: 1,
          customerName: 'John Doe',
          total: '80.00$',
          isOpen: false,
          purchases: [
            { id: 1, description: 'Oil Change', quantity: 2, price: '25.00', total: '50.00' },
            { id: 2, description: 'Engine Repair', quantity: 1, price: '30.00', total: '30.00' }
          ]
        },
        {
          id: 2,
          customerName: 'Jane Smith',
          total: '60.00$',
          isOpen: false,
          purchases: [
            { id: 3, description: 'Break Pads', quantity: 3, price: '60.00', total: '60.00' }
          ]
        }
        // ...other user invoices...
      ]
    };
  },
  methods: {
    toggleDetails(invoice) {
      invoice.isOpen = !invoice.isOpen;
    },
    calculateTotal(purchase) {
      (purchase.price * purchase.quantity)
    }
  }
}
</script>
<style scoped>
html, body {
  height: 100%;
  margin: 0;
  padding: 0;
}

body {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  margin: 0;
  background-image: url("https://cdn.cnn.com/cnnnext/dam/assets/220721175751-woman-mechanic-stock-super-tease.jpg");
  background-size: cover;
  background-repeat: no-repeat;
}

.invoices-page {
  max-width: 800px;
  width: 1000px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid rgb(253, 253, 253);
  background-color: #ffffffcc;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  box-sizing: border-box;
}

h1 {
  font-size: 24px;
  margin-bottom: 20px;
  color: #555555;
}

.invoices-list {
  display: flex;
  flex-direction: column;
}

.invoice {
  border: 1px solid #ddd;
  padding: 10px;
  margin-bottom: 10px;
  background-color: #9c9a9acc;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  
}

.invoice-header {
  display: flex;
  justify-content: space-between;
}

.toggle-details-btn {
  background-color: #007bff;
  color: white;
  border: none;
  padding: 5px 10px;
  cursor: pointer;
  border-radius: 20px;
}

.invoice-summary {
  display: flex;
  flex-direction: column;
  align-items: flex;
  border-radius: 333px;
}

.invoice-details {
  border-top: 1px solid rgb(18, 22, 243);
  margin-top: 10px;
  padding-top: 10px;
  
}

.purchase {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
  border-top: 1px solid rgb(38, 17, 226);
  padding-top: 10px;
}

.purchase-info {
  flex: 1;
}

.purchase-total {
  flex: 0.5;
}

strong {
  font-weight: bold;
  color: #007bff;
}

p {
  margin: 5px 0;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity .5s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}

</style>
