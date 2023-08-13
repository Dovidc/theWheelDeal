<template>
  <div class="invoice">
        <div class="invoice-header">
            <h1>Invoice</h1>
            <p>Invoice #12345</p>
            <p>Date: August 13, 2023</p>
        </div>
        <div class="invoice-details">
            <h2>Bill To:</h2>
            <p>Customer Name</p>
            <p>123 Main Street</p>
            <p>City, State, ZIP</p>
        </div>
        <table class="invoice-table">
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Item 1</td>
                    <td>2</td>
                    <td>$50.00</td>
                    <td>$100.00</td>
                </tr>
                <tr>
                    <td>Item 2</td>
                    <td>1</td>
                    <td>$75.00</td>
                    <td>$75.00</td>
                </tr>
                <tr>
                    <td colspan="3">Subtotal</td>
                    <td>$175.00</td>
                </tr>
                <tr>
                    <td colspan="3">Tax (10%)</td>
                    <td>$17.50</td>
                </tr>
                <tr>
                    <td colspan="3">Total</td>
                    <td>$192.50</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {

}
</script>
<style scoped>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f5f5f5;
}

.invoice {
  max-width: 800px;
  margin: 40px auto;
  padding: 20px;
  background-color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.invoice-header {
  text-align: center;
  margin-bottom: 20px;
}

.invoice-details {
  margin-bottom: 30px;
}

.invoice-table {
  width: 100%;
  border-collapse: collapse;
}

.invoice-table th, .invoice-table td {
  padding: 8px;
  text-align: left;
  border-bottom: 1px solid #ddd;
}

.invoice-table th {
  background-color: #f5f5f5;
}

.invoice-table td {
  vertical-align: top;
}

.invoice-table td:last-child {
  text-align: right;
}

h1, h2, h3 {
  margin: 0;
}

p {
  margin: 5px 0;
}

</style>
