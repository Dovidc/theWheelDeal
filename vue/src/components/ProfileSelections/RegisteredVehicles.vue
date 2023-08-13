<template>
  <div class="vehicle-form-container">
    <h1>Registered Vehicles</h1>
    <div class="vehicle-list">
      <div v-for="vehicle in registeredVehicles" :key="vehicle.id" class="vehicle">
        <p><strong>Make:</strong> {{ vehicle.make }}</p>
        <p><strong>Model:</strong> {{ vehicle.model }}</p>
        <p><strong>Year:</strong> {{ vehicle.year }}</p>
        <p><strong>Plate No:</strong> {{ vehicle.plateNumber }}</p>
      </div>
    </div>
    
    <h2>Register New Vehicle</h2>
    <form @submit.prevent="registerVehicle" class="new-vehicle-form">
      <div class="form-group">
        <label for="make">Make:</label>
        <input type="text" id="make" v-model="newVehicle.make" required />
      </div>
      <div class="form-group">
        <label for="model">Model:</label>
        <input type="text" id="model" v-model="newVehicle.model" required />
      </div>
      <div class="form-group">
        <label for="year">Year:</label>
        <input type="number" id="year" v-model="newVehicle.year" required />
      </div>
      <div class="form-group">
        <label for="color">Color:</label>
        <input type="text" id="color" v-model="newVehicle.color" required />
      </div>
      <div class="form-group">
        <label for="plate_number">Plate No:</label>
        <input type="text" id="plate_number" v-model="newVehicle.plateNumber" required />
      </div>
      <div class="form-group">
        <label for="mileage">Mileage:</label>
        <input type="number" id="mileage" v-model="newVehicle.mileage" required />
      </div>
      <button type="submit">Register Vehicle</button>
    </form>
  </div>
</template>

<script>
export default {
data() {
    return {
      registeredVehicles: [
        { id: 1, make: 'Toyota', model: 'Camry', year: 2022, plateNumber: 'DWT3878' },
        { id: 2, make: 'Honda', model: 'Civic', year: 2021, plateNumber: 'HMT3570' },
        // ...other registered vehicles...
      ],
      newVehicle: {
        make: '',
        model: '',
        year: '',
        color: '',
        plateNumber: '',
        mileage: ''
      }
    };
  },
  methods: {
    registerVehicle() {
      // Add the new vehicle to the registeredVehicles array
      this.registeredVehicles.push({
        id: this.registeredVehicles.length + 1,
        make: this.newVehicle.make,
        model: this.newVehicle.model,
        year: this.newVehicle.year,
        // ...other properties...
      });
      // Reset the newVehicle object
      this.newVehicle = {
        make: '',
        model: '',
        year: '',
        color: '',
        plateNumber: '',
        mileage: ''
      };
    }
  }
}
</script>

<style scoped>
.vehicle-form-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ddd;
  background-color: #f8f8f8cc;
  border-radius: 8px;
}

h1 {
  font-size: 24px;
  margin-bottom: 20px;
  color: #333333;
}

.vehicle-list {
  display: flex;
  flex-wrap: wrap;
  color: #555555;
}

.vehicle {
  border: 1px solid #ddd;
  padding: 10px;
  margin: 10px;
  background-color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

h2 {
  font-size: 20px;
  margin-top: 30px;
  color: #555555;
}

.new-vehicle-form {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 20px;
  margin-top: 10px;
  
}

.form-group {
  display: flex;
  flex-direction: column;
  padding: 10px;
}
#color {
    margin-right: 10px;
    
}

label {
  margin-bottom: 5px;
}

input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  text-align: center;
}

button {
  padding: 8px 12px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
  
}

button:hover {
  background-color: #0056b3;
}
</style>